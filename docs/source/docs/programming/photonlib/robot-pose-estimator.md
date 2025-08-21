# AprrilTa'gtlh bIp legh

:::{Qo’}
cha’Hu’ pagh De’ batlh ’a baH jIH baH Suq A'prrilTag dat'a, nej {lulIgh}`naDev <Qel/p'rrogrramming/pho'tonlib/Suq-DoS-da'ta:Suq AprrilTa'g Dat'a DoH baS DoS>`.
:::

Photo'nLib jIH baS `legh` Segh, jIH chaw’ SoH baH jIH ghaH chIch dat'a DoH Hoch Sorgh bep jIH bep ra’ baH Suq baS HoSchem leS chIch. cha’Hu’ paQDI’norgh bov, baS chev chuq chap ghaH `legh` Segh volchaH bel Sop.

## Sop beq `SoH`

`SoH` bel lo’ baH ’oS baS SoH chap AprrilTag'tlh jIH baS logh (HoSchem, tl'hhop bej juH, pa’, etq.). jIH jIH baS toH net d'etlhqrribetlh ghaH SoH chap Aprri'lTagtlh batlh ghaH HoSchem jIH SoH HotlhwI’ vaj lo’ bep ghaH SoH qoj. SoH HotlhwI’ je jIH baS tIgh SoH.

ghaH jIH jIH HotlhwI’ bel tu’ bep naDev: [Java](https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/apriltag/AprilTagFieldLayout.html), [C++](https://github.wpilib.org/allwpilib/docs/release/cpp/classfrc_1_1_april_tag_field_layout.html), bIp [Python](https://robotpy.readthedocs.io/projects/apriltag/en/stable/robotpy_apriltag/AprilTagFieldLayout.html#robotpy_apriltag.AprilTagFieldLayout).

```{eval-rst}
.. tab-set-code::
   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Constants.java
    :language: java
    :lines: 48-49

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/poseest/src/main/include/Constants.h
    :language: c++
    :lines: 46-47

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
    :language: python
    :lines: 46
```

## jIH ghaH qoq baH bov `Transform3d`

ghaH ’ut jIH cha’Hu’ Sop baS `legh` bel ghaH `Transform3d` ’oS ghaH qoq-leS tat bIp ghap chap ghaH bov. baS `Transform3d` jIH baS `Translation3d` bIp baS `Rotation3d`. ghaH `Translation3d` bel Sop bep chunDab bIp ghaH `Rotation3d` bel Sop batlh jIH. cha’Hu’ joq De’ batlh ghaH Quv pat, bel legh ghaH {lulIgh}`Quv pat <Qel/aprrilta'g-tlhegh/Quv-pat:Quv pat>` jIH.

```{eval-rst}
.. tab-set-code::
    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Constants.java
     :language: java
     :lines: 44-45

    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/poseest/src/main/include/Constants.h
     :language: c++
     :lines: 43-45

    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
     :language: python
     :lines: 33-36
```

## Sop baS `legh`

ghaH legh ghaj baS pagh ’e’ tlhap beq `SoH` (legh Dung), `Dup`, `bov`, bIp `Transform3d`. `Dup` ghaj Hut DuH val'uetlh:

- MULTI_TAG_PNP_ON_COPROCESSOR
  - SIm baS chu’ qoq ba’ noH bong jIH Hoch jIH Sorgh pagh. chup cha’Hu’ Hoch SeS bel ’oH jIH bel ghaH mo'tlht aqqurr'ate.
  - loch qonf'igurre ghaH SoH tlhegh bep ghaH bup, bel legh {lulIgh}`naDev <Qel/aprrilta'g-tlhegh/’oH:’oH tat>` cha’Hu’ qoj De’.
- LOWEST_AMBIGUITY
  - wIv ghaH chIch batlh ghaH bIng ’oH.
- CLOSEST_TO_CAMERA_HEIGHT
  - wIv ghaH chIch jIH bel SoQmoH baH ghaH bov chorgh.
- CLOSEST_TO_REFERENCE_POSE
  - wIv ghaH chIch jIH bel SoQmoH baH ghaH chIch DoH t'lhetReferrenqePotlhe().
- CLOSEST_TO_LAST_POSE
  - wIv ghaH chIch jIH bel SoQmoH baH ghaH Qav chIch SIm.
- AVERAGE_BEST_TARGETS
  - wIv ghaH chIch jIH bel ghaH bov chap Hoch ghaH chIch DoH paQDI’norgh Sorgh.
- MULTI_TAG_PNP_ON_RIO
  - baS QIt, bIr jIH chap MULTI_TAG_PNP_ON_COPROCESSOR, Huv chup cha’Hu’ lo’.
- PNP_DISTANCE_TRIG_SOLVE
  - lo’ chuq dat'a DoH toH jIH Sorgh baH De’wI’ baS chIch. jIH qet batlh ghaH pagh bep ra’
    baH naw’ ghaH qoq'klingon Hob nach, bIp loch ghaj chel pong Hoch jIH toH nach
    d'ata bel chen-baH-ma’. waw’ batlh baS maS jIH bong [FRC Team 6328 Mechanical Advantage](https://www.chiefdelphi.com/t/frc-6328-mechanical-advantage-2025-build-thread/477314/98).
- CONSTRAINED_SOLVEPNP
  - ngoS baS qeq jIH chap ghaH Perrtlhpeqti've-klingon-jIH Hej batlh ghaH qoq'klingon drrivebatl'he
    fla't batlh ghaH rav. jIH tat tlhap lan batlh ghaH qoj, bIp volchaH Huv tlhap qoj t'han 2ms.
    jIH je poQ chel baH bel pong Hoch jIH vaj nach dat'a bel chen baH ma’.
    beH jIH-Sorgh PNP bel en'abled batlh ghaH joq, ’oH jIH bel lo’ baH jIH beq jIH legh baH
    ghaH tat pagh -- ghaH, ghaH jIH-Sorgh Hoch Dup jIH bel lo’ bel ghaH
    legh.

```{eval-rst}
.. tab-set-code::
   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Vision.java
    :language: java
    :lines: 65-66

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/poseest/src/main/include/Vision.h
    :language: c++
    :lines: 150-153

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
    :language: python
    :lines: 45-50
```

:::{Qo’}
P'ython jIH tlhap baS `bov` bep ghaH qoj, toH SoH loch Sop ghaH bov bel ’ang bep ghaH retlh ’ay’ bIp vaj chegh bIp lo’ ’oH baH Sop ghaH `legh`.
:::

## lo’ baS `legh`

ghaH jIH ba’ baH lo’ SoH `legh` bel Sop baS `bov`. baH baH jIH, SoH loch cher ghaH pong chap SoH bov bep Phot'on jIH. DoH pa’ SoH HotlhwI’ jIH ghaH bov bep ngoq.

```{eval-rst}
.. tab-set-code::
    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Vision.java
     :language: java
     :lines: 63

    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/aimattarget/src/main/include/Robot.h
     :language: c++
     :lines: 55

    .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
     :language: python
     :lines: 44
```

pong `upd'ate()` batlh SoH `legh` jIH chegh beq `Hej`, jIH jIH baS `Pose3d` chap ghaH Hoy’ noH chIch (lo’ ghaH wIv Dup) alo'ng batlh baS `Seng` chap ghaH jIH ghaH ghaH qoq chIch bel noH.

```{eval-rst}
.. tab-set-code::
   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Vision.java
    :language: java
    :lines: 93-116

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/poseest/src/main/include/Vision.h
    :language: c++
    :lines: 80-100

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
     :language: python
     :lines: 53
```

SoH volchaH bel updat'ing SoH [drivetrain pose estimator](https://docs.wpilib.org/en/latest/docs/software/advanced-controls/state-space/state-space-pose-estimators.html) batlh ghaH leS DoH ghaH `legh` Hoch l'oop lo’ `chel()`.

```{eval-rst}
.. tab-set-code::
   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-java-examples/poseest/src/main/java/frc/robot/Robot.java
    :language: java
    :lines: 49

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-cpp-examples/poseest/src/main/include/Robot.h
    :language: c++
    :lines: 54-57

   .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/refs/heads/main/photonlib-python-examples/poseest/robot.py
     :language: python
     :lines: 54-57
```

## Comple'te Exampletl'h

ghaH qomplet'e examplet'lh cha’Hu’ ghaH `legh` HotlhwI’ bel tu’ bep ghaH tlha’ tat:

- [Java](https://github.com/PhotonVision/photonvision/tree/main/photonlib-java-examples/poseest)
- [C++](https://github.com/PhotonVision/photonvision/tree/main/photonlib-cpp-examples/poseest)
- [Python](https://github.com/PhotonVision/photonvision/tree/main/photonlib-python-examples/poseest)

## chel `legh` jIH

cha’Hu’ qoj De’ batlh ghaH `legh` Segh, bel legh ghaH jIH jIH.

- [Java Documentation](https://javadocs.photonvision.org/release/org/photonvision/PhotonPoseEstimator.html)
- [C++ Documentation](https://cppdocs.photonvision.org/release/classphoton_1_1_photon_pose_estimator.html)
- [Python Documentation](https://pydocs.photonvision.org/release/reference/photonPoseEstimator/)
