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
 * Auto-generated serialization/deserialization helper for PhotonPipelineResult
 */
public class PhotonPipelineResultSerde implements PacketSerde<PhotonPipelineResult> {
    // Message definition md5sum. See photon_packet.adoc for details
    public static final String MESSAGE_VERSION = "eefe85cf831c55de6f95e367c3f8784b";
    public static final String MESSAGE_FORMAT = "PhotonPipelineMetadata metadata;PhotonTrackedTarget[?] targets;MultiTargetPNPResult? multitagResult;";

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, PhotonPipelineResult value) {
        // field metadata is of non-intrinsic type PhotonPipelineMetadata
        PhotonPipelineMetadata.photonStruct.pack(packet, value.metadata);

        // targets is a custom VLA!
        packet.encodeList(value.targets);

        // multitagResult is optional! it better not be a VLA too
        packet.encodeOptional(value.multitagResult);
    }

    @Override
    public PhotonPipelineResult unpack(Packet packet) {
        var ret = new PhotonPipelineResult();

        // metadata is of non-intrinsic type PhotonPipelineMetadata
        ret.metadata = PhotonPipelineMetadata.photonStruct.unpack(packet);

        // targets is a custom VLA!
        ret.targets = packet.decodeList(PhotonTrackedTarget.photonStruct);

        // multitagResult is optional! it better not be a VLA too
        ret.multitagResult = packet.decodeOptional(MultiTargetPNPResult.photonStruct);

        return ret;
    }
}