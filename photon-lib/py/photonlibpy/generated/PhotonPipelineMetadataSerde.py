###############################################################################
## Copyright (C) Photon Vision.
###############################################################################
## This program is free software: you can redistribute it and/or modify
## it under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
##
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
##
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <https://www.gnu.org/licenses/>.
###############################################################################

###############################################################################
## THIS FILE WAS AUTO-GENERATED BY ./photon-targeting/generate_messages.py.
##                        --> DO NOT MODIFY <--
###############################################################################

from ..targeting import *


class PhotonPipelineMetadataSerde:

    # Message definition md5sum. See photon_packet.adoc for details
    MESSAGE_VERSION = "2a7039527bda14d13028a1b9282d40a2"
    MESSAGE_FORMAT = (
        "int64 sequenceID;int64 captureTimestampMicros;int64 publishTimestampMicros;"
    )

    @staticmethod
    def unpack(packet: "Packet") -> "PhotonPipelineMetadata":
        ret = PhotonPipelineMetadata()

        # sequenceID is of intrinsic type int64
        ret.sequenceID = packet.decodeLong()

        # captureTimestampMicros is of intrinsic type int64
        ret.captureTimestampMicros = packet.decodeLong()

        # publishTimestampMicros is of intrinsic type int64
        ret.publishTimestampMicros = packet.decodeLong()

        return ret
