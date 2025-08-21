# Duv Dup

Duv Dup cha’Hu’ lo’ jIH tlhol leS jIH vum batlh ghaH qoq'klingon *chIch* batlh ghaH HoSchem.

baS *chIch* bel baS tat beq DuD/bep Quv, bIp beq taH detlhqrrib'ing nuqDaq ghaH qoq'klingon frro'nt bel jIH. baS chIch bel reH Dop *leS* baH je’ tI’ jIH batlh ghaH HoSchem.

jIH jIH baS [Pose2d](https://docs.wpilib.org/en/stable/docs/software/advanced-controls/geometry/pose.html) Segh baH detlhqrrib'e chIch bep toH.

tat HotlhwI’ t'lhupply lugh De’ baH pol noH chap *chIch* aqqur'rate chuv baS ful'l bej.

## DaH bIp luch Need'ed

- baS ghap qet tat
  \- Aqq'urrate bov tat baH joq "3D bobcho’" poQ
- baS qeq batlh ghaH bIp noch
  \- yap noch baH juv ghaH tat
  \- bIH chap SoQmoH-lo'op Do SeH
- baS gyrr'otlhqope qoj jIH juv vang qoq nach
- Qom lo’ je’ p'ath-nab jIH

## qoq chIch DoH ghaH bov

ghaH lo’ 3D bobcho’ bep tat, beq chel gho’ bel che’ baH noH ghaH 3D ba’ chap bov, leS baH wa’ qoj joq A'prrilTagtlh.

jIH tlhol baH Huv lIng baS *jIH* taS. pa’ bel m'ultiple DuH bov ba’ jIH jIH QIj ghaH jIH ’oH tu’. chel, ghaH bov bel rrarrel'y HuD bep ghaH pup botlh chap baS qoq.

cha’Hu’ ghaH meq, ghaH 3D De’ loch bel jIH bIp pagh cha’Hu’ bIH HotlhwI’ detlhqrr'ibe ghaH qoq'klingon chIch.

PhotonLi'b jIH {lulIgh}`baS jIH Segh baH boQ batlh jIH tlhol batlh ghaH qoj <Qel/prrogr'ramming/ph'otonlib/qoq-chIch-qoj:Ap'rrilTagtlh bIp legh>`. choH, {lulIgh}`baS "jIH-Sorgh" Dup HotlhwI’ baH jIH tlhol batlh ghaH pagh. <Qel/a'prriltag-tlhegh/’oH:Enab'ling ’oH>`.

## HoSchem-leS chIch tat

ghaH bov'klingon loy chap ghaH qoq chIch bov volchaH bel *maH* batlh nuQ noch jIH.

jIH jIH [a set of pose estimation classes](https://docs.wpilib.org/en/stable/docs/software/advanced-controls/state-space/state-space-pose-estimators.html) cha’Hu’ baH jIH Qap.

## I ghaj baS chIch noH, DaH nuqneH?

### jIH jIH Hoch

baS jIH DoH baH lo’ baS chIch noH bel baH chu’ qoq Qap Hoch ghaH bep ghaH lugh t'lhpot batlh ghaH HoSchem.

```{eval-rst}
.. tab-set-code::

   .. code-block:: Java

      Pose3d robotPose;
      boolean launcherSpinCmd;

      // ...

      if(robotPose.X() < 1.5){
        // Near blue alliance wall, start spinning the launcher wheel
        launcherSpinCmd = True;
      } else {
        // Far away, no need to run launcher.
        launcherSpinCmd = False;
      }

      // ...
```

### nab

baS q'ommon, ’a ghap qom'plex maH chap baS chIch noH bel beq jIH baH baS pat'h-tlha’ pagh. Hoch, ghaH chIch noH bel lo’ baH lugh cha’Hu’ ghaH qoq tIH DoH chap ghaH bot-jIH pa'th.

legh ghaH {lulIgh}`chIch tat <Qel/examplet'lh/legh:DaH bIp luch Nee'ded>` exampl'e cha’Hu’ jIH batlh yu’ jIH.
