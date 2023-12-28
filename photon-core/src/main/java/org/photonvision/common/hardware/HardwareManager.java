/*
 * Copyright (C) Photon Vision.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.photonvision.common.hardware;

import edu.wpi.first.networktables.IntegerPublisher;
import edu.wpi.first.networktables.IntegerSubscriber;
import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.photonvision.common.ProgramStatus;
import org.photonvision.common.configuration.ConfigManager;
import org.photonvision.common.configuration.HardwareConfig;
import org.photonvision.common.configuration.HardwareSettings;
import org.photonvision.common.dataflow.networktables.NTDataChangeListener;
import org.photonvision.common.dataflow.networktables.NetworkTablesManager;
import org.photonvision.common.hardware.GPIO.CustomGPIO;
import org.photonvision.common.hardware.GPIO.pi.PigpioSocket;
import org.photonvision.common.hardware.metrics.MetricsManager;
import org.photonvision.common.logging.LogGroup;
import org.photonvision.common.logging.Logger;
import org.photonvision.common.util.ShellExec;
import org.photonvision.common.util.TimedTaskManager;

public class HardwareManager {
    private static HardwareManager instance;

    private final ShellExec shellExec = new ShellExec(true, false);
    private final Logger logger = new Logger(HardwareManager.class, LogGroup.General);

    private final HardwareConfig hardwareConfig;
    private final HardwareSettings hardwareSettings;

    private final MetricsManager metricsManager;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final StatusLED statusLED;

    @SuppressWarnings("FieldCanBeLocal")
    private final IntegerSubscriber ledModeRequest;

    private final IntegerPublisher ledModeState;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final NTDataChangeListener ledModeListener;

    public final VisionLED visionLED; // May be null if no LED is specified

    private final PigpioSocket pigpioSocket; // will be null unless on Raspi

    public static HardwareManager getInstance() {
        if (instance == null) {
            var conf = ConfigManager.getInstance().getConfig();
            instance = new HardwareManager(conf.getHardwareConfig(), conf.getHardwareSettings());
        }
        return instance;
    }

    private HardwareManager(HardwareConfig hardwareConfig, HardwareSettings hardwareSettings) {
        this.hardwareConfig = hardwareConfig;
        this.hardwareSettings = hardwareSettings;

        this.metricsManager = new MetricsManager();
        this.metricsManager.setConfig(hardwareConfig);

        ledModeRequest =
                NetworkTablesManager.getInstance()
                        .kRootTable
                        .getIntegerTopic("ledModeRequest")
                        .subscribe(-1);
        ledModeState =
                NetworkTablesManager.getInstance().kRootTable.getIntegerTopic("ledModeState").publish();
        ledModeState.set(VisionLEDMode.kDefault.value);

        CustomGPIO.setConfig(hardwareConfig);

        if (Platform.isRaspberryPi()) {
            pigpioSocket = new PigpioSocket();
        } else {
            pigpioSocket = null;
        }

        statusLED =
                hardwareConfig.statusRGBPins.size() == 3
                        ? new StatusLED(hardwareConfig.statusRGBPins)
                        : null;

        if(statusLED != null){
            TimedTaskManager.getInstance().addTask("StatusLEDUpdate", this::statusLEDUpdate, 200);
        }

        var hasBrightnessRange = hardwareConfig.ledBrightnessRange.size() == 2;
        visionLED =
                hardwareConfig.ledPins.isEmpty()
                        ? null
                        : new VisionLED(
                                hardwareConfig.ledPins,
                                hasBrightnessRange ? hardwareConfig.ledBrightnessRange.get(0) : 0,
                                hasBrightnessRange ? hardwareConfig.ledBrightnessRange.get(1) : 100,
                                pigpioSocket,
                                ledModeState::set);

        ledModeListener =
                visionLED == null
                        ? null
                        : new NTDataChangeListener(
                                NetworkTablesManager.getInstance().kRootTable.getInstance(),
                                ledModeRequest,
                                visionLED::onLedModeChange);

        Runtime.getRuntime().addShutdownHook(new Thread(this::onJvmExit));

        if (visionLED != null) {
            visionLED.setBrightness(hardwareSettings.ledBrightnessPercentage);
            visionLED.blink(85, 4); // bootup blink
        }

        // Start hardware metrics thread (Disabled until implemented)
        // if (Platform.isLinux()) MetricsPublisher.getInstance().startTask();
    }

    public void setBrightnessPercent(int percent) {
        if (percent != hardwareSettings.ledBrightnessPercentage) {
            hardwareSettings.ledBrightnessPercentage = percent;
            if (visionLED != null) visionLED.setBrightness(percent);
            ConfigManager.getInstance().requestSave();
            logger.info("Setting led brightness to " + percent + "%");
        }
    }

    private void onJvmExit() {
        logger.info("Shutting down LEDs...");
        if (visionLED != null) visionLED.setState(false);

        logger.info("Force-flushing settings...");
        ConfigManager.getInstance().saveToDisk();
    }

    public boolean restartDevice() {
        if (Platform.isLinux()) {
            try {
                return shellExec.executeBashCommand("reboot now") == 0;
            } catch (IOException e) {
                logger.error("Could not restart device!", e);
                return false;
            }
        }
        try {
            return shellExec.executeBashCommand(hardwareConfig.restartHardwareCommand) == 0;
        } catch (IOException e) {
            logger.error("Could not restart device!", e);
            return false;
        }
    }

    public void setStatus(ProgramStatus status) {
        this.curStatus = status;
    }

    public void statusLEDUpdate() {
        // make blinky
        boolean blinky = ((blinkCounter % 2) == 0);

        // check if any pipeline has a visible target
        boolean anyTarget = false;
        for(var t : this.pipelineTargets){
            if(t){
                anyTarget = true;
            }
        }

        switch (this.curStatus) {
            case UHOH:
                // red flashing
                statusLED.setRGB(blinky, false, false);
                break;
            case RUNNING:
                if(anyTarget){
                    // alternate blue/yellow
                    statusLED.setRGB(blinky, blinky, !blinky);
                } else {
                    // Yellow flashing
                    statusLED.setRGB(blinky, blinky, false);
                }
                break;
            case RUNNING_NT:
                if(anyTarget){
                    // alternate blue/green
                    statusLED.setRGB(false, blinky, !blinky);
                } else {
                    // blinky green
                    statusLED.setRGB(false, blinky, false);
                }
                break;
        }

        blinkCounter++;
    }

    private ArrayList<Boolean> pipelineTargets = new ArrayList<Boolean>();
    private ProgramStatus curStatus = ProgramStatus.UHOH;
    int blinkCounter = 0;


    public void setTargetsVisibleStatus(int pipelineIdx, boolean hasTargets){
        pipelineTargets.ensureCapacity(pipelineIdx);
        pipelineTargets.add(pipelineIdx, hasTargets);
    }

    public HardwareConfig getConfig() {
        return hardwareConfig;
    }

    public void publishMetrics() {
        metricsManager.publishMetrics();
    }
}
