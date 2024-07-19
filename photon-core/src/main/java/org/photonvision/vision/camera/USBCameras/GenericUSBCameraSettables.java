package org.photonvision.vision.camera.USBCameras;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoException;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.cscore.VideoProperty;
import edu.wpi.first.util.PixelFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.photonvision.common.configuration.CameraConfiguration;
import org.photonvision.common.configuration.ConfigManager;
import org.photonvision.common.util.math.MathUtils;
import org.photonvision.vision.camera.CameraQuirk;
import org.photonvision.vision.processes.VisionSourceSettables;

public class GenericUSBCameraSettables extends VisionSourceSettables {
    // We need to remember the last exposure set when exiting
    // auto exposure mode so we can restore it
    protected double lastExposureRaw = -1;

    // Some cameras need logic where we re-apply brightness after
    // changing exposure
    protected int lastBrightness = -1;

    protected VideoProperty exposureAbsProp = null;
    protected VideoProperty autoExposureProp = null;

    protected double minExposure = 1;
    protected double maxExposure = 80000;

    protected static final int PROP_AUTO_EXPOSURE_ENABLED = 3;
    protected static final int PROP_AUTO_EXPOSURE_DISABLED = 1;

    protected UsbCamera camera;
    protected CameraConfiguration configuration;

    public GenericUSBCameraSettables(CameraConfiguration configuration, UsbCamera camera) {
        super(configuration);

        this.configuration = configuration;
        this.camera = camera;

        getAllVideoModes();

        if (!configuration.cameraQuirks.hasQuirk(CameraQuirk.StickyFPS)) {
            if (!videoModes.isEmpty()) {
                setVideoMode(videoModes.get(0)); // fixes double FPS set
            }
        }

    }

    protected void setUpExposureProperties() {
        // Photonvision needs to be able to control absolute exposure. Make sure we can
        // first.
        var expProp =
                findProperty(
                        "raw_exposure_absolute", "raw_exposure_time_absolute", "exposure", "raw_Exposure");

        // Photonvision needs to be able to control auto exposure. Make sure we can
        // first.
        var autoExpProp = findProperty("exposure_auto", "auto_exposure");

        exposureAbsProp = expProp.get();
        autoExposureProp = autoExpProp.get();
        this.minExposure = exposureAbsProp.getMin();
        this.maxExposure = exposureAbsProp.getMax();
    }

    public void setAllCamDefaults() {
        // Common settings for all cameras to attempt to get their image
        // as close as possible to what we want for image processing
        softSet("image_stabilization", 0); // No image stabilization, as this will throw off odometry
        softSet("power_line_frequency", 2); // Assume 60Hz USA
        softSet("scene_mode", 0); // no presets
        softSet("exposure_metering_mode", 0);
        softSet("exposure_dynamic_framerate", 0);
        softSet("focus_auto", 0);
        softSet("focus_absolute", 0); // Focus into infinity
    }

    public void setAutoExposure(boolean cameraAutoExposure) {
        logger.debug("Setting auto exposure to " + cameraAutoExposure);

        if (!cameraAutoExposure) {
            // Pick a bunch of reasonable setting defaults for vision processing
            softSet("auto_exposure_bias", 0);
            softSet("iso_sensitivity_auto", 0); // Disable auto ISO adjustment
            softSet("iso_sensitivity", 0); // Manual ISO adjustment
            softSet("white_balance_auto_preset", 2); // Auto white-balance disabled
            softSet("white_balance_automatic", 0);
            softSet("white_balance_temperature", 4000);
            autoExposureProp.set(PROP_AUTO_EXPOSURE_DISABLED);

            // Most cameras leave exposure time absolute at the last value from their AE
            // algorithm.
            // Set it back to the exposure slider value
            setExposureRaw(this.lastExposureRaw);

        } else {
            // Pick a bunch of reasonable setting to make the picture nice-for-humans
            softSet("auto_exposure_bias", 12);
            softSet("iso_sensitivity_auto", 1);
            softSet("iso_sensitivity", 1); // Manual ISO adjustment by default
            softSet("white_balance_auto_preset", 1); // Auto white-balance enabled
            softSet("white_balance_automatic", 1);
            autoExposureProp.set(PROP_AUTO_EXPOSURE_ENABLED);
        }
    }

    @Override
    public double getMinExposureRaw() {
        return minExposure;
    }

    @Override
    public double getMaxExposureRaw() {
        return maxExposure;
    }

    @Override
    public void setExposureRaw(double exposureRaw) {
        if (exposureRaw >= 0.0) {
            try {
                autoExposureProp.set(PROP_AUTO_EXPOSURE_DISABLED);

                int propVal = (int) MathUtils.limit(exposureRaw, minExposure, maxExposure);

                logger.debug(
                        "Setting property "
                                + exposureAbsProp.getName()
                                + " to "
                                + propVal
                                + " (user requested "
                                + exposureRaw
                                + " μs)");

                exposureAbsProp.set(propVal);

                this.lastExposureRaw = exposureRaw;


            } catch (VideoException e) {
                logger.error("Failed to set camera exposure!", e);
            }
        }
    }

    @Override
    public void setBrightness(int brightness) {
        try {
            camera.setBrightness(brightness);
            this.lastBrightness = brightness;
        } catch (VideoException e) {
            logger.error("Failed to set camera brightness!", e);
        }
    }

    @Override
    public void setGain(int gain) {
        softSet("gain_automatic", 0);
        softSet("gain", gain);
    }

    @Override
    public VideoMode getCurrentVideoMode() {
        return camera.isConnected() ? camera.getVideoMode() : null;
    }

    @Override
    public void setVideoModeInternal(VideoMode videoMode) {
        try {
            if (videoMode == null) {
                logger.error("Got a null video mode! Doing nothing...");
                return;
            }
            camera.setVideoMode(videoMode);
        } catch (Exception e) {
            logger.error("Failed to set video mode!", e);
        }
    }

    @Override
    public HashMap<Integer, VideoMode> getAllVideoModes() {
        if (videoModes == null) {
            videoModes = new HashMap<>();
            List<VideoMode> videoModesList = new ArrayList<>();
            try {
                VideoMode[] modes;

                modes = camera.enumerateVideoModes();

                for (VideoMode videoMode : modes) {
                    // Filter grey modes
                    if (videoMode.pixelFormat == PixelFormat.kGray
                            || videoMode.pixelFormat == PixelFormat.kUnknown) {
                        continue;
                    }

                    if (configuration.cameraQuirks.hasQuirk(CameraQuirk.FPSCap100)) {
                        if (videoMode.fps > 100) {
                            continue;
                        }
                    }

                    videoModesList.add(videoMode);
                }
            } catch (Exception e) {
                logger.error("Exception while enumerating video modes!", e);
                videoModesList = List.of();
            }

            // Sort by resolution
            var sortedList =
                    videoModesList.stream()
                            .distinct() // remove redundant video mode entries
                            .sorted(((a, b) -> (b.width + b.height) - (a.width + a.height)))
                            .collect(Collectors.toList());
            Collections.reverse(sortedList);

            // On vendor cameras, respect blacklisted indices
            var indexBlacklist =
                    ConfigManager.getInstance().getConfig().getHardwareConfig().blacklistedResIndices;
            for (int badIdx : indexBlacklist) {
                sortedList.remove(badIdx);
            }

            for (VideoMode videoMode : sortedList) {
                videoModes.put(sortedList.indexOf(videoMode), videoMode);
            }
        }
        return videoModes;
    }

    /**
     * Forgiving "set this property" action. Produces a debug message but skips properties if they
     * aren't supported Errors if the property exists but the set fails.
     *
     * @param property
     * @param value
     */
    protected void softSet(String property, int value) {
        VideoProperty prop = camera.getProperty(property);
        if (prop.getKind() == VideoProperty.Kind.kNone) {
            logger.debug("No property " + property + " for " + camera.getName() + " , skipping.");
        } else {
            try {
                prop.set(value);
            } catch (VideoException e) {
                logger.error("Failed to set " + property + " for " + camera.getName() + " !", e);
            }
        }
    }

    /**
     * Returns the first property with a name in the list. Useful to find gandolf property that goes
     * by many names in different os/releases/whatever
     *
     * @param options
     * @return
     */
    protected Optional<VideoProperty> findProperty(String... options) {
        VideoProperty retProp = null;
        boolean found = false;
        for (var option : options) {
            retProp = camera.getProperty(option);
            if (retProp.getKind() != VideoProperty.Kind.kNone) {
                // got em
                found = true;
                break;
            }
        }

        if (!found) {
            logger.warn(
                    "Expected at least one of the following properties to be available: "
                            + Arrays.toString(options));
            retProp = null;
        }

        return Optional.ofNullable(retProp);
    }

    
}
