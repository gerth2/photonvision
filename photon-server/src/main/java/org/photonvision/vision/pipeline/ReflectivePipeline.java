/*
 * Copyright (C) 2020 Photon Vision.
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

package org.photonvision.vision.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.photonvision.common.util.math.MathUtils;
import org.photonvision.vision.frame.Frame;
import org.photonvision.vision.frame.FrameStaticProperties;
import org.photonvision.vision.opencv.CVMat;
import org.photonvision.vision.opencv.Contour;
import org.photonvision.vision.pipe.impl.*;
import org.photonvision.vision.pipeline.result.CVPipelineResult;
import org.photonvision.vision.target.PotentialTarget;
import org.photonvision.vision.target.TrackedTarget;

/** Represents a pipeline for tracking retro-reflective targets. */
@SuppressWarnings({"DuplicatedCode"})
public class ReflectivePipeline extends CVPipeline<CVPipelineResult, ReflectivePipelineSettings> {

    private final RotateImagePipe rotateImagePipe = new RotateImagePipe();
    private final CalculateFPSPipe calculateFPSPipe = new CalculateFPSPipe();

    CascadeClassifier cascadeClassifierModel;

    private final Mat rawInputMat = new Mat();
    private final long[] pipeProfileNanos = new long[PipelineProfiler.ReflectivePipeCount];

    public ReflectivePipeline(ReflectivePipelineSettings settings) {
        commonConstructor(settings);
    }

    public ReflectivePipeline() {
        commonConstructor(new ReflectivePipelineSettings());
    }

    private void commonConstructor(ReflectivePipelineSettings settings) {
        this.settings = settings;
        cascadeClassifierModel = new CascadeClassifier();
        cascadeClassifierModel.load("./models/haarcascades/haarcascade_frontalface_default.xml"); 
    }

    @Override
    protected void setPipeParams(
            FrameStaticProperties frameStaticProperties, ReflectivePipelineSettings settings) {

        RotateImagePipe.RotateImageParams rotateImageParams =
                new RotateImagePipe.RotateImageParams(settings.inputImageRotationMode);
        rotateImagePipe.setParams(rotateImageParams);
    }

    @Override
    public CVPipelineResult process(Frame frame, ReflectivePipelineSettings settings) {
        setPipeParams(frame.frameStaticProperties, settings);

        long sumPipeNanosElapsed = 0L;

        var rotateImageResult = rotateImagePipe.run(frame.image.getMat());
        sumPipeNanosElapsed += pipeProfileNanos[0] = rotateImageResult.nanosElapsed;

        long inputCopyStartNanos = System.nanoTime();
        rawInputMat.release();
        frame.image.getMat().copyTo(rawInputMat);
        long inputCopyElapsedNanos = System.nanoTime() - inputCopyStartNanos;
        sumPipeNanosElapsed += pipeProfileNanos[1] = inputCopyElapsedNanos;

        List<TrackedTarget> targetList = new ArrayList();

        Mat frameGray = new Mat();
        Imgproc.cvtColor(rawInputMat, frameGray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(frameGray, frameGray);
        // -- Detect faces
        MatOfRect detectedObjects = new MatOfRect();
        MatOfInt rejectLevels = new MatOfInt();
        MatOfDouble levelWeights = new MatOfDouble();
        cascadeClassifierModel.detectMultiScale3(frameGray, detectedObjects, rejectLevels, levelWeights, 1.1, 3, 0, new Size(10,10), new Size(99999,99999), true);
        List<Rect> listOfdetectedObjects = detectedObjects.toList();


        for (int i = 0; i < listOfdetectedObjects.size(); i++) {
            int[] confIdxArr = {i, 0};
            Rect detectedObject = listOfdetectedObjects.get(i);
            double[] confidence = levelWeights.get(confIdxArr);

            String labelText = "Conf: " + confidence[0] + "%";
            // ROI Marker
            Imgproc.rectangle(rawInputMat, new Point(detectedObject.x, detectedObject.y), 
                                           new Point(detectedObject.x + detectedObject.width, detectedObject.y + detectedObject.height), 
                                           new Scalar(0, 0, 255), 3);
            // Label Text background
            Imgproc.rectangle(rawInputMat, new Point(detectedObject.x-1, detectedObject.y-20),
                                           new Point(detectedObject.x + labelText.length()*9, detectedObject.y), 
                                           new Scalar(0, 0, 255), -1);
            // Label text
            Imgproc.putText(rawInputMat, labelText, 
                                        new Point(detectedObject.x, detectedObject.y-5), 
                                        Core.FONT_HERSHEY_PLAIN, 1, 
                                        new Scalar(0, 0, 0), 
                                        2);
        }


        var fpsResult = calculateFPSPipe.run(null);
        var fps = fpsResult.output;
        sumPipeNanosElapsed += fpsResult.nanosElapsed;

        // FPS text
        Imgproc.putText(rawInputMat, fps.toString(), 
        new Point(5, 50), 
        Core.FONT_HERSHEY_PLAIN, 4, 
        new Scalar(0, 255, 0), 
        3);

        PipelineProfiler.printReflectiveProfile(pipeProfileNanos);

        return new CVPipelineResult(
                MathUtils.nanosToMillis(sumPipeNanosElapsed),
                targetList,
                new Frame(new CVMat(rawInputMat), frame.frameStaticProperties),
                new Frame(new CVMat(rawInputMat), frame.frameStaticProperties));
    }
}
