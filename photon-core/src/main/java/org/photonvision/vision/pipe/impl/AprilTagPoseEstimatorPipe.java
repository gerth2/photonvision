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

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.photonvision.vision.opencv.CVMat;
import org.photonvision.vision.pipe.CVPipe;

import edu.wpi.first.apriltag.AprilTagDetection;
import edu.wpi.first.apriltag.AprilTagDetector;
import edu.wpi.first.apriltag.AprilTagPoseEstimate;
import edu.wpi.first.apriltag.AprilTagPoseEstimator;

public class AprilTagPoseEstimatorPipe
        extends CVPipe<AprilTagDetection, AprilTagPoseEstimate, AprilTagPoseEstimator.Config> {
    private final AprilTagDetector m_detector = new AprilTagDetector();

    boolean useNativePoseEst;

    public AprilTagPoseEstimatorPipe() {
        super();

        m_detector.addFamily("tag16h5");
        m_detector.addFamily("tag36h11");
    }

    @Override
    protected AprilTagPoseEstimate process(AprilTagDetection in) {
            // TODO don't hardcode # iters
            return AprilTagPoseEstimator.estimateOrthogonalIteration(in, this.params, 50);
    }

    @Override
    public void setParams(AprilTagPoseEstimator.Config params) {
        super.setParams(params);
        // m_detector.updateParams(params.detectorParams);
    }

    public void setNativePoseEstimationEnabled(boolean enabled) {
        this.useNativePoseEst = enabled;
    }

    public static class AprilTagPoseEstimatorPipeParams {

    }
}
