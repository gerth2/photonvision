# Suq DoS D'ata

## ghojmoH baS bov

### nuqneH bel baS bov?

`bov` bel baS Segh bep Phot'onLib ’e’ chaw’ baS maH baH bov batlh wa’ bov ’e’ bel rar baH veS ’e’ bel che’ tat. T'hrrough jIH Segh, maH HotlhwI’ Son Hob, jIH, rro'll, qoq-leS chIch, wa’maH, bIp baS maH chap nuQ De’.

ghaH `bov` Segh ghaj cha’ joq: wa’ net tlhap baS `cha’` bIp ghaH net tlhap bep ghaH pong chap ghaH cha’ bergh ’e’ tat bel brroadqatlh'ting De’ chuv. cha’Hu’ bel chap lo’, ’oH bel chup baH lo’ ghaH Hap. ghaH pong chap ghaH cha’ (cha’Hu’ ghaH ’aw’ joq) volchaH bel ghaH jIH bel ghaH bov'klingon jIH (DoH ghaH tat bup).

```{eval-rst}
.. tab-set-code::


     .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/a3bcd3ac4f88acd4665371abc3073bdbe5effea8/photonlib-java-examples/src/main/java/org/photonlib/examples/aimattarget/Robot.java
        :language: java
        :lines: 51-52

     .. rli:: https://github.com/PhotonVision/photonvision/raw/a3bcd3ac4f88acd4665371abc3073bdbe5effea8/photonlib-cpp-examples/src/main/cpp/examples/aimattarget/include/Robot.h
        :language: c++
        :lines: 42-43

     .. code-block:: Python

         # Change this to match the name of your camera as shown in the web ui
         self.camera = PhotonCamera("your_camera_name_here")

```

:::{ghuHmoH}
SeS loch ghaj jIH pong cha’Hu’ Hoch chap ghaH bov r'regarrdletlhtlh chap jIH qoj bIH bel HIv baH.
:::

## Suq ghaH tlhegh leS

### nuqneH bel baS P'hoton tlhegh leS?

baS `tlhegh` bel baS togh ’e’ jIH Hoch De’ buS q'urrrrently Duy’ DoS DoH baS `bov`. SoH HotlhwI’ Son ghaH Hoy’ tlhegh leS lo’ ghaH bov chuq.

lo’ ghaH `Suq()`/`Suq()` (J'ava bIp baH++ vuv) baH Suq ghaH Hoy’ tlhegh leS. beq advan'tage chap lo’ jIH jIH bel net ’oH chegh baS togh batlh De’ ’e’ bel ’av baH bel DoH ghaH jIH jIH. jIH bel joq beH SoH bel lo’ jIH da'ta cha’Hu’ wa’maH tat ghap bep beq joq.

```{eval-rst}
.. tab-set-code::


     .. rli:: https://raw.githubusercontent.com/PhotonVision/photonvision/a3bcd3ac4f88acd4665371abc3073bdbe5effea8/photonlib-java-examples/src/main/java/org/photonlib/examples/aimattarget/Robot.java
        :language: java
        :lines: 79-80

     .. rli:: https://github.com/PhotonVision/photonvision/raw/a3bcd3ac4f88acd4665371abc3073bdbe5effea8/photonlib-cpp-examples/src/main/cpp/examples/aimattarget/cpp/Robot.cpp
         :language: c++
         :lines: 35-36

     .. code-block:: Python

         # Query the latest result from PhotonVision
         result = self.camera.getLatestResult()


```

:::{Qo’}
jIH nuQ jIH toH taS, lo’ ghaH Hoy’ leS ’av net Hoch De’ bel DoH ghaH jIH jIH. jIH bel chav lo’ ghaH tat baqken'd ngeH baS by'te-paqke'd ’aw’ chap d'ata jIH bel vaj choS bong PhotonL'ib baH Suq DoS dat'a. cha’Hu’ ghap De’, ghaH buS ghaH [PhotonLib source code](https://github.com/PhotonVision/photonvision/tree/main/photon-lib).
:::

## ghaH cha’Hu’ wa’maH chap DoS

paQDI’norgh tlhegh leS ghaj baS `DoS()`/`DoS()` (Ja'va bIp baH++ vuv) jIH baH De’ ghaH maH bel baH ghaH ghaH leS jIH law’ DoS.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Check if the latest result has any targets.
      boolean hasTargets = result.hasTargets();

   .. code-block:: C++

      // Check if the latest result has any targets.
      bool hasTargets = result.HasTargets();

   .. code-block:: Python

     # Check if the latest result has any targets.
      hasTargets = result.hasTargets()
```

:::{ghuHmoH}
bep Jav'a/baH++, SoH loch _always_ ghaH beH ghaH leS ghaj baS DoS jIH `DoS()`/`DoS()` cha’Hu’ Suq DoS ghap je’ SoH may Suq baS nul'l jIH le’. Hop, SoH loch lo’ ghaH jIH leS bep Hoch tlhubtlhequ'ent pong bep ’e’ loo'p.
:::

## Suq baS jIH chap DoS

### nuqneH bel baS P'hoton toj DoS?

baS toj DoS jIH De’ buS paQDI’norgh DoS DoH baS tlhegh leS. jIH De’ jIH Hob, jIH, yoS, bIp qoq leS chIch.

SoH HotlhwI’ Suq baS jIH chap toj DoS lo’ ghaH `DoS()`/`DoS()` (J'ava bIp baH++ vuv) jIH DoH baS tlhegh leS.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Get a list of currently tracked targets.
      List<PhotonTrackedTarget> targets = result.getTargets();

   .. code-block:: C++

      // Get a list of currently tracked targets.
      wpi::ArrayRef<photonlib::PhotonTrackedTarget> targets = result.GetTargets();

   .. code-block:: Python

      # Get a list of currently tracked targets.
      targets = result.getTargets()
```

## Suq ghaH toH DoS

SoH HotlhwI’ Suq ghaH {lulIgh}`toH DoS <Qel/rrefleqtiveAndSha'pe/qontour'r-jIH:Conto'urr ghom bIp Segh>` lo’ `DoS()`/`DoS()` (Ja'va bIp baH++ vuv) jIH DoH ghaH tlhegh leS.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Get the current best target.
      PhotonTrackedTarget target = result.getBestTarget();

   .. code-block:: C++

      // Get the current best target.
      photonlib::PhotonTrackedTarget target = result.GetBestTarget();


   .. code-block:: Python

      # Coming Soon!

```

## Suq Da'ta DoH baS DoS

- Seng `Suq()`/`Suq()`: ghaH Hob chap ghaH DoS bep de'grreetlh (ba’ leSpoH).
- Seng `Suq()`/`Suq()`: ghaH jIH chap ghaH DoS bep de'grreetlh (ba’ chen).
- Seng `Suq()`/`Suq()`: ghaH yoS (’ach ’ar chap ghaH bov je’ ghaH veH box tlhap chen) bel baS vatlhvI’ (0-100).
- Seng `Suq()`/`Suq()`: ghaH tlhk'ew chap ghaH DoS bep de'grreetlh (ngeb-qloqkwi'tlhe ba’).
- Seng\[\] `qoj()`/`pagh()`: ghaH 4 ghap chap ghaH jIH veH box rreqtang'le.
- Transform2d `bov()`/`bov()`: ghaH bov baH DoS qoj. legh [2d transform documentation here](https://docs.wpilib.org/en/latest/docs/software/advanced-controls/geometry/transformations.html#transform2d-and-twist2d).

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Get information from target.
      double yaw = target.getYaw();
      double pitch = target.getPitch();
      double area = target.getArea();
      double skew = target.getSkew();
      Transform2d pose = target.getCameraToTarget();
      List<TargetCorner> corners = target.getCorners();

   .. code-block:: C++

      // Get information from target.
      double yaw = target.GetYaw();
      double pitch = target.GetPitch();
      double area = target.GetArea();
      double skew = target.GetSkew();
      frc::Transform2d pose = target.GetCameraToTarget();
      wpi::SmallVector<std::pair<double, double>, 4> corners = target.GetCorners();

   .. code-block:: Python

      # Get information from target.
      yaw = target.getYaw()
      pitch = target.getPitch()
      area = target.getArea()
      skew = target.getSkew()
      pose = target.getCameraToTarget()
      corners = target.getDetectedCorners()
```

## Suq Aprri'lTag D'ata DoH baS DoS

:::{Qo’}
Hoch chap ghaH d'ata Dung (**le’ tlhke'w**) bel ava'ilable ghaH lo’ AprrilTagt'lh.
:::

- chech `Suq()`/`Suq()`: ghaH ID chap ghaH cheH f'iduqial marrker'r.
- Seng `Suq()`/`Suq()`: ’ach maH ghaH chIch chap ghaH DoS bel (legh bIng).
- Transform3d `bov()`/`bov()`: Suq ghaH pagh ’e’ m'aptlh bov logh (DuD = pagh, bep = leSpoH, buD = chen) baH bep/fi'duqial Sorgh logh (DuD pagh, bep leSpoH, buD chen) batlh ghaH bIng jInmol Qagh.
- Transform3d `choH()`/`choH()`: Suq ghaH qoj net mapt'lh bov logh (DuD = qoj, bep = leSpoH, buD = chen) baH bep/fi'duqial Sorgh logh (DuD pagh, bep leSpoH, buD chen) batlh ghaH jen Hotlh Qagh.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Get information from target.
      int targetID = target.getFiducialId();
      double poseAmbiguity = target.getPoseAmbiguity();
      Transform3d bestCameraToTarget = target.getBestCameraToTarget();
      Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();

   .. code-block:: C++

      // Get information from target.
      int targetID = target.GetFiducialId();
      double poseAmbiguity = target.GetPoseAmbiguity();
      frc::Transform3d bestCameraToTarget = target.getBestCameraToTarget();
      frc::Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();

   .. code-block:: Python

      # Get information from target.
      targetID = target.getFiducialId()
      poseAmbiguity = target.getPoseAmbiguity()
      bestCameraToTarget = target.getBestCameraToTarget()
      alternateCameraToTarget = target.getAlternateCameraToTarget()
```

## toD cha’ baH jIH

baS `bov` HotlhwI’ pol jIH jIH DoH ghaH jIH qoj outpu't jIH SeS baH jIH. jIH bel lI’ cha’Hu’ debugg'ing nuqneH baS bov bel legh jIH batlh ghaH HoSchem bIp jIH DoS bel bel ngu’ tlhegh.

jIH bel joq jIH ghaH tat tat joq. che’ ghaH "joq" bov bep ghaH jIH bergh jIH downl'oad baS .jIH jIH jIH jIH ghaH jIH jon.

```{eval-rst}
.. tab-set-code::

    .. code-block:: Java

      // Capture pre-process camera stream image
      camera.takeInputSnapshot();

      // Capture post-process camera stream image
      camera.takeOutputSnapshot();

    .. code-block:: C++

      // Capture pre-process camera stream image
      camera.TakeInputSnapshot();

      // Capture post-process camera stream image
      camera.TakeOutputSnapshot();

    .. code-block:: Python

      # Capture pre-process camera stream image
      camera.takeInputSnapshot()

      # Capture post-process camera stream image
      camera.takeOutputSnapshot()
```

:::{Qo’}
pol jIH baH jIH tlhap baS bav chap poH bIp lo’ chen jIH logh, toH baH ’oH frreque'ntly bel Huv chup. bep bov, ghaH bov jIH pol beq jIH Hoch 500ms. pong ghaH jIH nom jIH Huv leS bep chel jIH. Dop boH jIH jon baH baS ’a Doj batlh ghaH bIQtIq SeH, pagh beq apprropr'riate jIH bep beq maH jIH.
:::
