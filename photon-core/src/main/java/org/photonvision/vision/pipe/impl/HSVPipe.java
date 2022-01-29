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

import edu.wpi.first.math.filter.LinearFilter;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.photonvision.PhotonVersion;
import org.photonvision.common.util.numbers.IntegerCouple;
import org.photonvision.jni.PhotonJNI;
import org.photonvision.vision.pipe.CVPipe;
import sun.misc.Unsafe;

import java.nio.ByteBuffer;

public class HSVPipe extends CVPipe<Mat, Mat, HSVPipe.HSVParams> {

    LinearFilter f = LinearFilter.movingAverage(1000);

    @Override
    protected Mat process(Mat in) {
        var outputMat = new Mat();
//        in.copyTo(outputMat);
        Imgproc.cvtColor(in, outputMat, Imgproc.COLOR_BGR2HSV, 3);

        var start = System.nanoTime();

        if(params.getHueInverted()) {
            Scalar firstLower = params.getHsvLower().clone();
            Scalar firstUpper = params.getHsvUpper().clone();
            // we want hue from the end of the slider to the top
            firstLower.val[0] = params.getHsvUpper().val[0];;
            firstUpper.val[0] = 180;

            var lowerThresholdMat = new Mat();
//            outputMat.copyTo(matCopy);
            Core.inRange(outputMat, firstLower, firstUpper, lowerThresholdMat);

            // sat/value are dealt with, now just need to get an image that includes the second part of hue
            var secondLower = params.getHsvLower().clone();
            var secondUpper = params.getHsvUpper().clone();
            // We want hue from 0 to the start of the slider
            secondLower.val[0] = 0;
            secondUpper.val[0] = params.getHsvLower().val[0];

            var upperThresholdMat = new Mat();
            Core.inRange(outputMat, secondLower, secondUpper, upperThresholdMat);

            // Now OR the two images together
            Core.bitwise_or(lowerThresholdMat, upperThresholdMat, outputMat);
            upperThresholdMat.release();
            lowerThresholdMat.release();

//            // This is a long pointer to the start of the data
//            // We expect our input to be 8uc3, and it should be row major. not that that matters as we apply the same operaton to everything
//            var rows = outputMat.rows();
//            var cols = outputMat.cols();
//            var dataPtr = outputMat.dataAddr();
//            var lower = params.getHsvLower().val;
//            var upper = params.getHsvUpper().val;
//            PhotonJNI.inRangeInvertedHue(dataPtr, dataPtr, rows, cols,
//                    (int) lower[0], (int) upper[0], // hue exclusion range
//                    (int) lower[1], (int) upper[1],
//                    (int) lower[2], (int) upper[2]);

            // We want a mat of pixels where saturation and value are both satisfied, AND hue is NOT between our range
            // We could do this by taking the OR of an image with hue

//            // First, mask out ONLY hue. this yields a b/w image with pixels of the WRONG hue lit
//            var bwMat = new Mat(outputMat.rows(), outputMat.cols(), CvType.CV_8UC1);
//            var lower = params.getHsvLower().val;
//            var upper = params.getHsvUpper().val;
//            var newLower = new Scalar(lower[0], 0, 0);
//            var newUpper = new Scalar(upper[0], 255, 255);
//            Core.inRange(outputMat, newLower, newUpper, bwMat);
//            // Invert it, so images with the RIGHT hue are lit
//            Core.bitwise_not(bwMat, bwMat);
//            // Use this mask on our first image to mask out the WRONG hue
//            Core.bitwise_and(bwMat, outputMat, outputMat);
//            // Then mask saturation and value
//            newLower = new Scalar(0, lower[1], lower[2]);
//            newUpper = new Scalar(0, upper[1], upper[2]);
//            Core.inRange(outputMat, newLower, newUpper, outputMat);
//
//            bwMat.release();

            var end = System.nanoTime();
            var ret = f.calculate(end-start);
            System.out.printf("Took %f MS\n", ret / 1e6);
        } else {
            Core.inRange(outputMat, params.getHsvLower(), params.getHsvUpper(), outputMat);
            var end = System.nanoTime();
            var ret = f.calculate(end-start);
            System.out.printf("Took %f MS\n", ret / 1e6);
        }

        return outputMat;
    }

    public static class HSVParams {
        private final Scalar m_hsvLower;
        private final Scalar m_hsvUpper;
        private final boolean m_hueInverted;

        public HSVParams(IntegerCouple hue, IntegerCouple saturation, IntegerCouple value) {
            // m_hsvLower = new Scalar(hue.getSecond(), saturation.getFirst(), value.getFirst());
            // m_hsvUpper = new Scalar(hue.getFirst(), saturation.getSecond(), value.getSecond());
            m_hsvLower = new Scalar(hue.getFirst(), saturation.getFirst(), value.getFirst());
            m_hsvUpper = new Scalar(hue.getSecond(), saturation.getSecond(), value.getSecond());

            this.m_hueInverted = false;// hue.getFirst() > hue.getSecond();
        }

        public Scalar getHsvLower() {
            return m_hsvLower;
        }

        public Scalar getHsvUpper() {
            return m_hsvUpper;
        }

        public boolean getHueInverted() {
            return true;//m_hueInverted;
        }
    }
}
