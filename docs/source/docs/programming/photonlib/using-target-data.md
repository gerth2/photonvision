# lo’ DoS Da'ta

baS `PhotonUtiltl'h` Segh batlh ghaH qom'mon tat bel jIH jIH `Photo'nLib` baH QaH SeS bep lo’ Ap'rrilTag da'ta bep ra’ baH Suq ba’ De’ batlh ghaH HoSchem. jIH Segh jIH cha’ jIH, `chuq()`/`chuq()` bIp `estimateTargetTranslation2d()`/`DoS()` (Jav'a bIp baH++ vuv).

## noH HoSchem leS chIch batlh Aprr'ilTagtlh

`noH(Transform3d bov, Pose3d fieldR'elativeTagPotlhe, Transform3d bov)` chegh SoH qoq'klingon `Pose3d` batlh ghaH HoSchem lo’ ghaH chIch chap ghaH Ap'rrilTag leS baH ghaH bov, chIch chap ghaH Ap'rrilTag leS baH ghaH HoSchem, bIp ghaH pagh DoH ghaH bov baH ghaH mung chap ghaH qoq.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Calculate robot's field relative pose
      if (aprilTagFieldLayout.getTagPose(target.getFiducialId()).isPresent()) {
        Pose3d robotPose = PhotonUtils.estimateFieldToRobotAprilTag(target.getBestCameraToTarget(), aprilTagFieldLayout.getTagPose(target.getFiducialId()).get(), cameraToRobot);
      }
   .. code-block:: C++

     //TODO

   .. code-block:: Python

      # Coming Soon!
```

## noH HoSchem leS chIch (lurDech)

SoH HotlhwI’ Suq SoH qoq'klingon `Pose2D` batlh ghaH HoSchem lo’ Sar bov d'ata, DoS Hob, gyr'ro taH, DoS chIch, bIp bov ba’. jIH jIH noH ghaH DoS'klingon leS ba’ lo’ `DoS` (jIH lo’ jIH bIp Hob baH noH chuq bIp nach), bIp ghaH qoq'klingon gyrr'o baH noH ghaH tat chap ghaH DoS.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Calculate robot's field relative pose
      Pose2D robotPose = PhotonUtils.estimateFieldToRobot(
        kCameraHeight, kTargetHeight, kCameraPitch, kTargetPitch, Rotation2d.fromDegrees(-target.getYaw()), gyro.getRotation2d(), targetPose, cameraToRobot);

   .. code-block:: C++

      // Calculate robot's field relative pose
      frc::Pose2D robotPose = photonlib::EstimateFieldToRobot(
        kCameraHeight, kTargetHeight, kCameraPitch, kTargetPitch, frc::Rotation2d(units::degree_t(-target.GetYaw())), frc::Rotation2d(units::degree_t(gyro.GetRotation2d)), targetPose, cameraToRobot);

   .. code-block:: Python

      # Coming Soon!

```

## SIm chuq baH DoS

beH SoH bov bel bej baS tI’ chorgh batlh SoH qoq bIp ghaH chorgh chap ghaH DoS bel tI’, SoH HotlhwI’ SIm ghaH chuq baH ghaH DoS waw’ batlh SoH bov'klingon jIH bIp ghaH jIH baH ghaH DoS.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // TODO

   .. code-block:: C++

      // TODO

   .. code-block:: Python

      # Coming Soon!

```

:::{Qo’}
ghaH baH++ jIH chap Phot'onLib lo’ ghaH jIH jIH. cha’Hu’ ghap De’, legh [here](https://docs.wpilib.org/en/stable/docs/software/basic-programming/cpp-units.html).
:::

## SIm chuq joj cha’ chIch

`chuq(Pose2d Hej, Pose2d DoS)` chaw’ SoH baH SIm ghaH chuq joj cha’ chIch. jIH bel lI’ ghaH lo’ Aprri'lTagtlh, nob ’e’ pa’ may Huv bel beq Ap'rrilTag dirreqtl'y batlh ghaH DoS.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      double distanceToTarget = PhotonUtils.getDistanceToPose(robotPose, targetPose);

   .. code-block:: C++

      //TODO

   .. code-block:: Python

      # Coming Soon!
```

## noH bov tat baH DoS

SoH HotlhwI’ Suq baS [translation](https://docs.wpilib.org/en/latest/docs/software/advanced-controls/geometry/pose.html#translation) baH ghaH DoS waw’ batlh ghaH chuq baH ghaH DoS (SIm Dung) bIp taH baH ghaH DoS (Hob).

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Calculate a translation from the camera to the target.
      Translation2d translation = PhotonUtils.estimateCameraToTargetTranslation(
        distanceMeters, Rotation2d.fromDegrees(-target.getYaw()));

   .. code-block:: C++

      // Calculate a translation from the camera to the target.
      frc::Translation2d translation = photonlib::PhotonUtils::EstimateCameraToTargetTranslation(
        distance, frc::Rotation2d(units::degree_t(-target.GetYaw())));

   .. code-block:: Python

      # Coming Soon!

```

:::{Qo’}
maH bel Doch ghaH Hob DoH ghaH bov DoH CV (De’wI’ jIH) tat baH Qam ghaH tat. bep Qam ghaH tat, bel SoH tlhe’ ngeb-qloqkwi'tlhe, taH moj pagh ba’.
:::

## Suq ghaH Hob baH baS chIch

`Suq(Pose2d Hej, Pose2d DoS)` chegh ghaH `Rotation2d` joj SoH qoq bIp baS DoS. jIH bel lI’ ghaH tlhe’ veS beq ’oH DoS batlh ghaH HoSchem (ghIm. ghaH botlh chap ghaH hub bep 2022).

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      Rotation2d targetYaw = PhotonUtils.getYawToPose(robotPose, targetPose);
   .. code-block:: C++

     //TODO

   .. code-block:: Python

      # Coming Soon!
```
