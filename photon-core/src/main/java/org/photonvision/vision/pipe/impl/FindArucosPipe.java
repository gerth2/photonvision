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
import java.util.Vector;

import org.opencv.core.Mat;
import org.photonvision.vision.calibration.CameraCalibrationCoefficients;
import org.photonvision.vision.opencv.CVShape;
import org.photonvision.vision.opencv.aruco.CameraParameters;
import org.photonvision.vision.opencv.aruco.Marker;
import org.photonvision.vision.opencv.aruco.MarkerDetector;
import org.photonvision.vision.pipe.CVPipe;

public class FindArucosPipe
        extends CVPipe<Mat, List<CVShape>, FindArucosPipe.FindArucosPipeParams> {

    // Output vector of found circles. Each vector is encoded as 3 or 4 element floating-point vector
    // (x,y,radius) or (x,y,radius,votes) .
    private final Mat circles = new Mat();
    private final MarkerDetector md = new MarkerDetector();
    /**
    * Runs the process for the pipe. The reason we need a separate pipe for circles is because if we
    * were to use the FindShapes pipe, we would have to assume that any shape more than 10-20+ sides
    * is a circle. Only issue with such approximation is that the user would no longer be able to
    * track shapes with 10-20+ sides. And hence,s in order to overcome this edge case, we can use
    * HoughCircles which is more flexible and accurate for finding circles.
    *
    * @param in Input for pipe processing. 8-bit, single-channel, grayscale input image.
    * @return Result of processing.
    */
    @Override
    protected List<CVShape> process(Mat in) {
        circles.release();
        Vector<Marker> output = new Vector<Marker>();

        md.detect(in, output, params.cp, params.markerSizeMeters);

        var retList = new ArrayList<CVShape>(output.size());
        for(Marker m : output){
            retList.add(new CVShape());
        }
        
        return retList;
    }

    public static class FindArucosPipeParams {
        public final float markerSizeMeters;
        public final CameraParameters cp;

        
        public FindArucosPipeParams(
                float markerSizeMeters,
                CameraCalibrationCoefficients cameraCalibrationCoefficients) {
            this.markerSizeMeters = markerSizeMeters;
            this.cp = new CameraParameters(cameraCalibrationCoefficients);

        }
    }
}
