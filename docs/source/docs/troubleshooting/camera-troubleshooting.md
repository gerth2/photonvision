# bov bach

## DIng bov

beH SoH ghaj'bach wej, bel maS baH {lulIgh}`ghaH DIng jIH bov tat pag'e <Qel/bov-tlh'peqifiq-tat/piqa'mqonfig:DIng bov tat>` cha’Hu’ De’ batlh u'pdating {ngoq}`jIH.txt` cha’Hu’ SoH lo’ vaj. beH SoH'bang nID net, bIp Doch jIH a'rren'bach Qap, Hov tat lo’ ghaH Hov ’a bep ghaH jIH bergh, bIp Doj jIH (\`) bep ghaH maH bup wa’logh tat bel joq. jIH volchaH cha’ ghaH m'otlht qeH bo'ot QonoS.

|                                 | pIH ou'tput                                       | qab                                |
| ------------------------------- | ----------------------------------------------------- | ---------------------------------- |
| bov bIQtIq tat | Qapla’ loade'd libpiq'am ghIj bep            | luj baH lo'ad Sung jIH!   |
| bov Duy’                 | chel lo'qal jIH jan - "jIH" bej "/chu’/video0" | Qo’ outpu't DoH boj |
| Hal Sop            | chel 1 jIH baH VMM.                              | Qo’ out'put DoH boj |

beH ghaH bIQtIq jIH'bach l'oaded, SoH may bel lo’ baS Dap-offiqi'al DIng jIH, qoj beq jIH Huv chu’ Qo’. nID up'dating baH ghaH m'otlht qeH jIH avail'able (wa’ rr'eleatlhed cha’Hu’ 2023) -- beH ’e’ cha'bach vaj ghaH Hej, {lulIgh}`vang maH<jIH:vang maH>` batlh SoH jIH jIH jIH bIp DIng jIH/bov jIH/jIH.txt jIH lo’.

beH ghaH bov bel Huv Duy’, ghaH mot'lht jIH lo’ bel ghaH baS jIH.txt jIH pagh cher-chen, joq baS jIH bergh HIv veS. jIH ghaH {lulIgh}`jIH tat pa'ge <Qel/bov-tlh'peqifiq-tat/piqa'mqonfig:DIng bov tat>`, bIp ’ol ghaH jIH bergh bel tlhegh joq bej nuQ chom, bIp net ’oH bel _fully_ jIH chech ghaH FFC ghap. vaj, {lulIgh}`vang maH<jIH:vang maH>` batlh SoH jIH jIH jIH bIp DIng jIH/bov jIH/jIH.txt jIH lo’.

## loDnal bov

loDnal bov joq bong qoj poQ Qo’ bov bIQtIq tat baH Qap -- ’a, jIH bach gho’ Quch. Hov tat lo’ ghaH Hov ’ach bep ghaH jIH bergh, bIp Doj jIH batlh SoH tIj (\`) ghaH SoH'baH bep ghaH maH bup wa’logh tat bel qoj. maH pIH baH legh ghaH tlha’ outpu't:

|                      | pIH out'put                                       | qab                                |
| -------------------- | ----------------------------------------------------- | ---------------------------------- |
| bov cheH      | chel loqa'l jIH jan - "tach" bej "/chu’/tach" | Qo’ ou'tput DoH boj |
| Hal Sop | chel 1 jIH baH VMM.                              | Qo’ outpu't DoH boj |

## tlhIl cheH bov bep Video4Linux (v4l2)

batlh jIH jan (jIH Qagh DIng), tat lo’ jIH'klingon ghap baH bov batlh jIH jan, jIH Hoch lo’ Video4Linux (v4l2). joq, bIp ghaH Photo'n, poQ net bov HIv ghaj jaH v4l bIQtIq cha’Hu’ chep Qap. ghaH volchaH bel chen chech ghaH jIH kerr'nel, bIp baH Huv n'eed baH bel jIH Hoch. jIH bov cher (DoH /bo'ot/jIH.txt) HotlhwI’ je bel tlhIl lo’ ghaH gho’. ghaH jIH-jan ra’ jIH cha’ Hoch jIH jIH jan cheH, bIp jIH-De’ ghaH jIH chap "jIH bobcho’" paQDI’norgh bov HotlhwI’ bel bep.

- cha’Hu’ jIH: Hoq ghaH jIH.txt jIH bel detlhqr'ribed bep ghaH {lulIgh}`jIH tat p'age <Qel/bov-tlhpeqifi'q-tat/piqamqonf'ig:DIng bov tat>`
- SSH chech SoH DIng: {ngoq}`tl'htlhh DIng@tat.loq'al` bIp ’el ghaH jIH "DIng" & joq "Qagh"
- che’ {ngoq}`v4l2-qtl --jIH-jan` bIp {ngoq}`v4l2-qtl --jIH-De’`

maH pIH beq outp'ut jIH baH ghaH tlha’. cha’Hu’ bov, Qo’ ghaH "jIH" nID batlh pa'th {ngoq}`pagh:3f801000.jIH` (beH maH Ion'bach legh jIH, net'klingon qab), bIp baS hug'e jIH chap jIH jIH De’. loDnal bov volchaH ’ang chen tlhimila'rrly bep ghaH out'put chap ghaH ra’.

```{eval-rst}
.. tab-set::
  .. tab-item:: Working

        .. code-block::

            pi@photonvision:~ $ v4l2-ctl --list-devices
            unicam (platform:3f801000.csi):
                /dev/video0
                /dev/media3

            bcm2835-codec-decode (platform:bcm2835-codec):
                /dev/video10
                /dev/video11
                /dev/video12
                /dev/video18
                /dev/video31
                /dev/media2

            bcm2835-isp (platform:bcm2835-isp):
                /dev/video13
                /dev/video14
                /dev/video15
                /dev/video16
                /dev/video20
                /dev/video21
                /dev/video22
                /dev/video23
                /dev/media0
                /dev/media1

            pi@photonvision:~ $ v4l2-ctl --list-formats
            ioctl: VIDIOC_ENUM_FMT
            Type: Video Capture

            [0]: 'YUYV' (YUYV 4:2:2)
            [1]: 'UYVY' (UYVY 4:2:2)
            [2]: 'YVYU' (YVYU 4:2:2)
            [3]: 'VYUY' (VYUY 4:2:2)
            <snip>
            [42]: 'Y12P' (12-bit Greyscale (MIPI Packed))
            [43]: 'Y12 ' (12-bit Greyscale)
            [44]: 'Y14P' (14-bit Greyscale (MIPI Packed))
            [45]: 'Y14 ' (14-bit Greyscale)

  .. tab-item:: Not Working

        .. code-block::

            pi@photonvision:~ $ v4l2-ctl --list-devices
            bcm2835-codec-decode (platform:bcm2835-codec):
                /dev/video10
                /dev/video11
                /dev/video12
                /dev/video18
                /dev/video31
                /dev/media3
             bcm2835-isp (platform:bcm2835-isp):
                /dev/video13
                /dev/video14
                /dev/video15
                /dev/video16
                /dev/video20
                /dev/video21
                /dev/video22
                /dev/video23
                /dev/media0
                /dev/media1
            rpivid (platform:rpivid):
                /dev/video19
                /dev/media2
            Cannot open device /dev/video0, exiting.
```

## voHDajbo’ rar

jIH bel baS qo'mmon jIH batlh Ar'rduqam bov, pagh nuQ bov batlh jorwI’ tIj, jIH baH Arrduqamtl'h. maH qurrr'rently Har ’oH qaS Hay’ baH wIv ghoH (Daq). ghaH chup taS bel full'y SoQmoH ghaH bov Dop chap baS vaj, jIH HotlhwI’ bel 3D-jIH qoj Hal DoH baS r'reputable ghap. lo’ beq jIH-jIH tIH batlh ghaH vaj HotlhwI’ je bel ghaH bep Doq Daq. beH ghaH bov bel maH QIH, Hay’ baH Daq qoj je’ nuQ meq, jIH bel Huv ’avwI’ baH vaj ghaH Hej.

baH SIQ ’e’ ghaH bov ratlh t'lhafe DoH Daq ghaH Huv bep ghaH vaj, ’oH bel chup net ghaH ghop, bov bel neH choljaH bong ghaH qoj. chel, bov volchaH bel ghap bep Daq tlh'afe veQ jIH chaH bel neH Duj bep.
