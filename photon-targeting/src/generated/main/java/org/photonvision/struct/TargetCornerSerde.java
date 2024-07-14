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
 * Auto-generated serialization & deserialization helper for TargetCorner
 */
public class TargetCornerSerde implements PacketSerde<TargetCorner> {
    
    // Message definition md5sum. See photon_packet.adoc for details
    public static final String MESSAGE_VERSION = "22b1ff7551d10215af6fb3672fe4eda8";
    public static final String MESSAGE_FORMAT = "{\"fields\": [{\"name\": \"x\", \"type\": \"float64\"}, {\"name\": \"y\", \"type\": \"float64\"}], \"name\": \"TargetCorner\"}";

    @Override
    public int getMaxByteSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaxByteSize'");
    }

    @Override
    public void pack(Packet packet, TargetCorner value) {
        // field x is of intrinsic type float64
        packet.encode((double) value.x);
    
        // field y is of intrinsic type float64
        packet.encode((double) value.y);
    }

    @Override
    public TargetCorner unpack(Packet packet) {
        var ret = new TargetCorner();

        // x is of intrinsic type float64
        ret.x = packet.decodeDouble();
    
        // y is of intrinsic type float64
        ret.y = packet.decodeDouble();

        return ret;
    }
}