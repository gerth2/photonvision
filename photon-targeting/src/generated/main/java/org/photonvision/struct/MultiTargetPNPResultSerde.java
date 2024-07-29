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

// THIS FILE WAS AUTO-GENERATED BY ./photon-targeting/generate_messages.py. DO NOT MODIFY

package org.photonvision.struct;

import org.photonvision.common.dataflow.structures.Packet;
import org.photonvision.common.dataflow.structures.PacketSerde;
import org.photonvision.utils.PacketUtils;

// Assume that the base class lives here and we can import it
import org.photonvision.targeting.*;


/**
 * Auto-generated serialization/deserialization helper for MultiTargetPNPResult
 */
public class MultiTargetPNPResultSerde implements PacketSerde<MultiTargetPNPResult> {

    // Message definition md5sum. See photon_packet.adoc for details
    public static final String MESSAGE_VERSION = "03960a77c0071f70aa848e7a11c6dd74";
    public static final String MESSAGE_FORMAT = "PnpResult estimatedPose;int16[?] fiducialIDsUsed;";

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, MultiTargetPNPResult value) {
        // field estimatedPose is of non-intrinsic type PnpResult
        PnpResult.photonStruct.pack(packet, value.estimatedPose);
    
        // fiducialIDsUsed is a intrinsic VLA!
        packet.encode(value.fiducialIDsUsed);
    }

    @Override
    public MultiTargetPNPResult unpack(Packet packet) {
        var ret = new MultiTargetPNPResult();

        // estimatedPose is of non-intrinsic type PnpResult
        ret.estimatedPose = PnpResult.photonStruct.unpack(packet);
    
        // fiducialIDsUsed is a custom VLA!
        ret.fiducialIDsUsed = packet.decodeShortList();

        return ret;
    }
}