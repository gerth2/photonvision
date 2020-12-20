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

package org.photonvision.vision.opencv;

import java.util.HashMap;
import org.opencv.core.Mat;
import org.photonvision.common.logging.LogGroup;
import org.photonvision.common.logging.Logger;

public class CVMat implements Releasable {
    private static final Logger logger = new Logger(CVMat.class, LogGroup.General);

    private static int allMatCounter = 0;
    private static final HashMap<Mat, Integer> allMats = new HashMap<>();

    private static boolean shouldPrint;

    private final Mat mat;

    public CVMat() {
        this(new Mat());
    }

    public void copyTo(CVMat srcMat) {
        copyTo(srcMat.getMat());
    }

    public void copyTo(Mat srcMat) {
        srcMat.copyTo(mat);
    }

    public void logStackTrace(){
        var trace = Thread.currentThread().getStackTrace();

        final var traceStr = new StringBuilder();
        for (int idx = 3; idx < trace.length; idx++) {
            traceStr.append("\t\n").append(trace[idx]);
        }
        logger.trace("\n" + traceStr.toString() + "\n");
    }

    public CVMat(Mat mat) {
        this.mat = mat;
        allMatCounter++;
        allMats.put(mat, allMatCounter);

        if (shouldPrint) {
            logger.trace(() -> "CVMat" + allMatCounter + " alloc - new count: " + allMats.size());
            logStackTrace();
        }
    }

    @Override
    public void release() {
        int matNo = allMats.get(mat);
        allMats.remove(mat);
        mat.release();
        logger.trace(() -> "CVMat" + matNo + " de-alloc - new count: " + allMats.size());
        logStackTrace();
    }

    public Mat getMat() {
        return mat;
    }

    public static int getMatCount() {
        return allMats.size();
    }

    public static void enablePrint(boolean enabled) {
        shouldPrint = enabled;
    }
}
