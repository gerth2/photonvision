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
 * Auto-generated serialization & deserialization helper for PhotonPipelineMetadata
 */
public class PhotonPipelineMetadataSerde implements PacketSerde<PhotonPipelineMetadata> {
    
    // Message definition md5sum. See photon_packet.adoc for details
    public static final String MESSAGE_VERSION = "2a7039527bda14d13028a1b9282d40a2";

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, PhotonPipelineMetadata value) {
        // field sequenceID is of intrinsic type int64
        packet.encode((long) value.sequenceID);
    
        // field captureTimestampMicros is of intrinsic type int64
        packet.encode((long) value.captureTimestampMicros);
    
        // field publishTimestampMicros is of intrinsic type int64
        packet.encode((long) value.publishTimestampMicros);
    }

    @Override
    public PhotonPipelineMetadata unpack(Packet packet) {
        var ret = new PhotonPipelineMetadata();
        // sequenceID is of intrinsic type int64
        ret.sequenceID = packet.decodeLong();
    
        // captureTimestampMicros is of intrinsic type int64
        ret.captureTimestampMicros = packet.decodeLong();
    
        // publishTimestampMicros is of intrinsic type int64
        ret.publishTimestampMicros = packet.decodeLong();

        return ret;
    }
}