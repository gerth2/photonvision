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

package org.photonvision.vision.pipe.impl;

import java.util.List;

import org.opencv.core.Mat;
import org.photonvision.vision.pipe.CVPipe;

import edu.wpi.first.apriltag.AprilTagDetection;
import edu.wpi.first.apriltag.AprilTagDetector;

public class AprilTagDetectionPipe
        extends CVPipe<Mat, List<AprilTagDetection>, AprilTagDetectionPipeParams> {
    private final AprilTagDetector m_detector = new AprilTagDetector();

    boolean useNativePoseEst;

    public AprilTagDetectionPipe() {
        super();

        m_detector.addFamily("tag16h5");
        m_detector.addFamily("tag36h11");
    }

    @Override
    protected List<AprilTagDetection> process(Mat in) {
        var ret =
                m_detector.detect(
                        in);
                        // params.cameraCalibrationCoefficients,
                        // useNativePoseEst,
                        // params.numIterations,
                        // params.tagWidthMeters);
        if (ret == null) return List.of();
        return List.of(ret);
    }

    @Override
    public void setParams(AprilTagDetectionPipeParams params) {
        super.setParams(params);
        // m_detector.updateParams(params.detectorParams);
    }

    public void setNativePoseEstimationEnabled(boolean enabled) {
        this.useNativePoseEst = enabled;
    }
}
