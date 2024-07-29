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

#include "photon/serde/PhotonTrackedTargetSerde.h"

namespace photon {

using StructType = SerdeType<PhotonTrackedTarget>;

void StructType::Pack(Packet& packet, const PhotonTrackedTarget& value) {
    packet.Pack<double>(value.yaw);
    packet.Pack<double>(value.pitch);
    packet.Pack<double>(value.area);
    packet.Pack<double>(value.skew);
    packet.Pack<int32_t>(value.fiducialId);
    packet.Pack<int32_t>(value.objDetectId);
    packet.Pack<float>(value.objDetectConf);
    packet.Pack<frc::Transform3d>(value.bestCameraToTarget);
    packet.Pack<frc::Transform3d>(value.altCameraToTarget);
    packet.Pack<double>(value.poseAmbiguity);
    packet.Pack<std::vector<photon::TargetCorner>>(value.minAreaRectCorners);
    packet.Pack<std::vector<photon::TargetCorner>>(value.detectedCorners);
}

PhotonTrackedTarget StructType::Unpack(Packet& packet) {
    return PhotonTrackedTarget{ PhotonTrackedTarget_PhotonStruct{
        .yaw = packet.Unpack<double>(),
        .pitch = packet.Unpack<double>(),
        .area = packet.Unpack<double>(),
        .skew = packet.Unpack<double>(),
        .fiducialId = packet.Unpack<int32_t>(),
        .objDetectId = packet.Unpack<int32_t>(),
        .objDetectConf = packet.Unpack<float>(),
        .bestCameraToTarget = packet.Unpack<frc::Transform3d>(),
        .altCameraToTarget = packet.Unpack<frc::Transform3d>(),
        .poseAmbiguity = packet.Unpack<double>(),
        .minAreaRectCorners = packet.Unpack<std::vector<photon::TargetCorner>>(),
        .detectedCorners = packet.Unpack<std::vector<photon::TargetCorner>>(),
    }};
}

} // namespace photon