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

#include "photon/serde/PhotonPipelineResultSerde.h"

namespace photon {

using StructType = SerdeType<PhotonPipelineResult>;

void StructType::Pack(Packet& packet, const PhotonPipelineResult& value) {
    packet.Pack<photon::PhotonPipelineMetadata>(value.metadata);
    packet.Pack<std::vector<photon::PhotonTrackedTarget>>(value.targets);
    packet.Pack<std::optional<photon::MultiTargetPNPResult>>(value.multitagResult);
}

PhotonPipelineResult StructType::Unpack(Packet& packet) {
    return PhotonPipelineResult{ PhotonPipelineResult_PhotonStruct{
        .metadata = packet.Unpack<photon::PhotonPipelineMetadata>(),
        .targets = packet.Unpack<std::vector<photon::PhotonTrackedTarget>>(),
        .multitagResult = packet.Unpack<std::optional<photon::MultiTargetPNPResult>>(),
    }};
}

} // namespace photon