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

#pragma once

// THIS FILE WAS AUTO-GENERATED BY ./photon-targeting/generate_messages.py. DO NOT MODIFY

#include "photon/dataflow/structures/Packet.h"

#include "photon/targeting/TargetCorner.h"
#include <frc/geometry/Transform3d.h>


struct PhotonTrackedTarget_PhotonStruct {
  double yaw;
  double pitch;
  double area;
  double skew;
  int32_t fiducialId;
  float objDetectConf;
  frc::Transform3d bestCameraToTarget;
  frc::Transform3d altCameraToTarget;
  double poseAmbiguity;
  std::vector<photon::TargetCorner> minAreaRectCorners;
  std::vector<photon::TargetCorner> detectedCorners;
};


template <>
struct WPILIB_DLLEXPORT photon::Struct<photon::PhotonTrackedTarget> {
  static constexpr std::string_view GetSchemaHash() {
    return "3551a569eb01ef7ee42981ba7331e7f3";
  }

  static constexpr std::string_view GetSchema() {
    return "{\"fields\": [{\"name\": \"yaw\", \"type\": \"float64\"}, {\"name\": \"pitch\", \"type\": \"float64\"}, {\"name\": \"area\", \"type\": \"float64\"}, {\"name\": \"skew\", \"type\": \"float64\"}, {\"name\": \"fiducialId\", \"type\": \"int32\"}, {\"name\": \"objDetectConf\", \"type\": \"float32\"}, {\"name\": \"bestCameraToTarget\", \"type\": \"Transform3d\"}, {\"name\": \"altCameraToTarget\", \"type\": \"Transform3d\"}, {\"name\": \"poseAmbiguity\", \"type\": \"float64\"}, {\"name\": \"minAreaRectCorners\", \"type\": \"TargetCorner\", \"vla\": true}, {\"name\": \"detectedCorners\", \"type\": \"TargetCorner\", \"vla\": true}], \"name\": \"PhotonTrackedTarget\"}";
  }

  static photon::PhotonTrackedTarget Unpack(photon::Packet& packet);
  static void Pack(photon::Packet& packet, const photon::PhotonTrackedTarget& value);
};

static_assert(photon::PhotonStructSerializable<photon::PhotonTrackedTarget>);