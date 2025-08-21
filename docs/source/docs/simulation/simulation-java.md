# tat qoj bep PhotonLi'b bep J'ava

## nuqneH bel Sim'ulated?

tat bel baS HoSghaj t'ool cha’Hu’ validat'ing qoq ngoq jIH naw’ baH baS Qel qoq. laD ghap buS [simulation in WPILib](https://docs.wpilib.org/en/stable/docs/software/wpilib-tools/robot-simulation/introduction.html).

bep J'ava, P'hotonLib HotlhwI’ tl'himulate bov batlh ghaH HoSchem bIp bov DoS da'ta apprroximatin'g nuqneH QID bel legh bep jIH. jIH tat nID baH jIH ghaH tlha’:

- bov tlhegh
  - HoSchem chap jIH
  - nI’ qoj
  - jIH jIH
  - bov
  - wa’maH
- DoS Dat'a
  - cheH / jIH-yoS-rreqtang'le ghap
  - botlh Hob/jIH
  - Cont'ourr jIH yoS vatlhvI’
  - Fid'uqial ID
  - Fiduqi'al ’oH
  - Fiduqi'al toH joq tat
- bov tlhol/tlhol SeS (tIH)

:::{Qo’}
tat baH Huv jIH ghaH tlha’:

- Ful'l Qel bov/joq tat (DoS bel Hoch pa’)
- jIH pa’ tlhol (bov jIH, wov, etq)
- tlhegh leQ
- bach
  :::

jIH tlhqop'e bel wIv baH boq ’oH chap ghaH tat batlh ghaH bel chap cher, bep baS DoH net QID toH jIH motlh't SeS.

```{image} diagrams/SimArchitecture.drawio.svg
:alt: A diagram comparing the architecture of a real PhotonVision process to a simulated
:  one.
```

## qeq tat ba’

baS ba’ cha’Hu’ tlhimula'ting jIH jIH bel Sov nuqDaq ghaH bov bel batlh ghaH HoSchem-- baH jIH tat tat, SoH'bong ne'ed baH t'lhupply ghaH tl'himulated qoq chIch Hoch. jIH poQ qeq tat cha’Hu’ SoH qoq jInmol beH SoH neH baH bov bov jIH bel SoH qoq nech yav ghaH HoSchem.

maS cha’Hu’ lo’ tat tat batlh qeq tat HotlhwI’ bel tu’ bep ghaH [PhotonLib Java Examples](https://github.com/PhotonVision/photonvision/blob/2a6fa1b6ac81f239c59d724da5339f608897c510/photonlib-java-examples/README.md) cha’Hu’ nuQ baS dif'ferrential qeq bIp baS maH jIH.

:::{pagh}
ghaH t'lhimulated qeq chIch loch bel chev DoH ghaH qeq noH chIch beH baS chIch joq bel jIH.
:::

## jIH pat tat

baS `pat` ’oS ghaH tlhim'ulated qoj cha’Hu’ wa’ ghap joq bov, bIp jIH ghaH jIH DoS bIH HotlhwI’ legh. ’oH bel ghojmoH batlh baS jIH per:

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // A vision system sim labelled as "main" in NetworkTables
      VisionSystemSim visionSim = new VisionSystemSim("main");
```

PhotonLi'b jIH lo’ jIH per baH De’wI’ baS `Field2d` jIH batlh cha’ bej `/pat-[per]/jIH HoSchem`. jIH per baH Huv ne'ed baH bej law’ bov pong joq tlhegh pong bep tat.

jIH DoS poQ baS `DoS`, jIH d'etlhqrribetlh ghaH tuHmoH chap ghaH DoS. cha’Hu’ AprrilTagtl'h, Ph'otonLib jIH `DoS.kAprilTag16h5` cha’Hu’ ghaH Sorgh lo’ bep 2023, bIp `DoS.kAprilTag36h11` cha’Hu’ ghaH Sorgh lo’ Hov bep 2024. cha’Hu’ nuQ DoS tuHmoH, pon qoj jIH cha’Hu’ moQ, jIH, bIp nab rreqtanglet'lh. cha’Hu’ exa'mple, baS nab rreqt'angle HotlhwI’ bel Sop batlh:

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // A 0.5 x 0.25 meter rectangular target
      TargetModel targetModel = new TargetModel(0.5, 0.25);
```

ghaH `DoS` bel jIH batlh baS DoS chIch baH Sop baS `DoS`. baS `DoS` bel chel baH ghaH `pat` baH moj jIH baH Hoch chap jIH bov.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // The pose of where the target is on the field.
      // Its rotation determines where "forward" or the target x-axis points.
      // Let's say this target is flat against the far wall center, facing the blue driver stations.
      Pose3d targetPose = new Pose3d(16, 4, 2, new Rotation3d(0, 0, Math.PI));
      // The given target model at the given pose
      VisionTargetSim visionTarget = new VisionTargetSim(targetPose, targetModel);

      // Add this vision target to the vision system simulation to make it visible
      visionSim.addVisionTargets(visionTarget);
```

:::{Qo’}
ghaH chIch chap baS `DoS` bep HotlhwI’ bel update'd baH tl'himulate nech DoS. Qo’, ’ach, ’e’ jIH jIH ghor wa’maH tat cha’Hu’ net DoS.
:::

cha’Hu’ pon, beq `SoH` HotlhwI’ je bel chel baH Hoch Sop baS DoS cha’Hu’ paQDI’norgh chap jIH Aprr'ilTagtlh.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // The layout of AprilTags which we want to add to the vision system
      AprilTagFieldLayout tagLayout = AprilTagFieldLayout.loadFromResource(AprilTagFields.kDefaultField.m_resourceFile);

      visionSim.addAprilTags(tagLayout);
```

:::{Qo’}
ghaH chIch chap ghaH Aprr'ilTagtlh DoH jIH SoH tlhab batlh jIH qur'rrrent boq mung (klingon.klingon. SuD ghap Doq). beH jIH mung bel choH nech, ghaH DoS jIH ghaj baH bel Huv DoH ghaH `pat` bIp baH-chel.
:::

## bov tat

DaH ’e’ maH ghaj baS tat ghap batlh jIH DoS, maH HotlhwI’ chel tl'himulated bov baH jIH ’oH.

cha’Hu’ chel baS tl'himulated bov, maH nee'd baH jIH jIH tlhegh. jIH bel baH batlh ghaH `bov` Segh:

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // The simulated camera properties
      SimCameraProperties cameraProp = new SimCameraProperties();
```

bong pIch, jIH jIH Sop baS 960 DuD 720 tat bov batlh baS 90 degrre'e jaH FOV(HoSchem-chap-jIH) bIp Qo’ jIH, joq, ghap wa’maH. beH maH neH baH choH ghaH tlhegh, maH HotlhwI’ baH toH:

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // A 640 x 480 camera with a 100 degree diagonal FOV.
      cameraProp.setCalibration(640, 480, Rotation2d.fromDegrees(100));
      // Approximate detection noise with average and standard deviation error in pixels.
      cameraProp.setCalibError(0.25, 0.08);
      // Set the camera image capture framerate (Note: this is limited by robot loop rate).
      cameraProp.setFPS(20);
      // The average and standard deviation in milliseconds of image data latency.
      cameraProp.setAvgLatencyMs(35);
      cameraProp.setLatencyStdDevMs(5);
```

ghaH tlhegh bel lo’ bep baS `bov`, jIH ghop bov jon jIH chap ghaH HoSchem DoH ghaH tl'himulated bov'klingon perrtl'hpeqtive, bIp SIm ghaH DoS da'ta jIH bel ngeH baH ghaH `bov` bel tlhimulat'ed.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // The PhotonCamera used in the real robot code.
      PhotonCamera camera = new PhotonCamera("cameraName");

      // The simulation of this camera. Its values used in real robot code will be updated.
      PhotonCameraSim cameraSim = new PhotonCameraSim(camera, cameraProp);
```

ghaH `bov` HotlhwI’ DaH bel chel baH ghaH `pat`. maH ghaj baH jIH baS qoq-baH-bov pagh, jIH det'lhqrribetlh nuqDaq ghaH bov bel leS baH ghaH qoq chIch (jIH HotlhwI’ bel juv bep CAD joq bong ghop).

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // Our camera is mounted 0.1 meters forward and 0.5 meters up from the robot pose,
      // (Robot pose is considered the center of rotation at the floor level, or Z = 0)
      Translation3d robotToCameraTrl = new Translation3d(0.1, 0, 0.5);
      // and pitched 15 degrees up.
      Rotation3d robotToCameraRot = new Rotation3d(0, Math.toRadians(-15), 0);
      Transform3d robotToCamera = new Transform3d(robotToCameraTrl, robotToCameraRot);

      // Add this camera to the vision system simulation with the given robot-to-camera transform.
      visionSim.addCamera(cameraSim, robotToCamera);
```

:::{ghap}
SoH may chel multi'ple bov baH wa’ `pat`, ’a Huv wa’ bov baH multipl'e `pat`. Hoch DoS bep ghaH `pat` jIH bel jIH baH Hoch jIH bov.
:::

beH ghaH bov bel HuD batlh baS jIH jIH (parHa’ baS tur'rrret) jIH joq HotlhwI’ bel u'pdated bep baS pe'rriodiq loo'p.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // The turret the camera is mounted on is rotated 5 degrees
      Rotation3d turretRotation = new Rotation3d(0, 0, Math.toRadians(5));
      robotToCamera = new Transform3d(
              robotToCameraTrl.rotateBy(turretRotation),
              robotToCameraRot.rotateBy(turretRotation));
      visionSim.adjustCamera(cameraSim, robotToCamera);
```

## Updat'ing ghaH tat joq

baH upd'ate ghaH `pat`, maH jIH ghaj baH juS bep ghaH tlhim'ulated qoq chIch Hoch (bep `tat()`).

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // Update with the simulated drivetrain pose. This should be called every loop in simulation.
      visionSim.update(robotPoseMeters);
```

DoS bIp bov HotlhwI’ bel chel bIp teq, bIp bov tlhegh HotlhwI’ bel choH bej law’ poH.

## Vitlhuali'zing leS

paQDI’norgh `pat` ghaj jIH jotlh chen-bep `Field2d` cha’Hu’ cha’ bep chIch bep ghaH tat pagh tl'huqh bel ghaH qoq, tlh'imulated bov, bIp vang/juv DoS chIch.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // Get the built-in Field2d used by this VisionSystemSim
      visionSim.getDebugField();
```

:::{jIH} jIH/jIH.png
_A_ `pat`_'klingon internal_ `Field2d` _customized batlh DoS jIH bIp colors_
:::

baS `bov` HotlhwI’ je d'rraw bIp jIH bov bov jIH baH baS M'JPEG SeS jIH baH beq vang tat tlhol.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      // Enable the raw and processed streams. These are enabled by default.
      cameraSim.enableRawStream(true);
      cameraSim.enableProcessedStream(true);

      // Enable drawing a wireframe visualization of the field to the camera streams.
      // This is extremely resource-intensive and is disabled by default.
      cameraSim.enableDrawWireframe(true);
```

ghaH SeS tlha’ ghaH ghap ra’ jIH bep {lulIgh}`Qel/jIH-Hov/cha’:bov SeS qoj`. cha’Hu’ exa'mple, baS jIH tlhi'mulated bov jIH ghaj jIH tlhol SeS bej `loqal'hotlht:1181` bIp tlhol SeS bej `loq'alhotlht:1182`, jIH HotlhwI’ je bel tu’ bep ghaH bov bergh chap tIj parHa’ baS qoj bov SeS.

:::{jIH} jIH/jIH.png
_A jIH DoH ghaH tlhol SeS chap baS tl'himulated bov jIH je’ 2023 AprrilTagtl'h batlh ghaH HoSchem jIH enabled_
:::
