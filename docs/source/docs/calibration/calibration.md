# C'alibrrating SoH bov

:::{joq}
bep ra’ baH Duy’ Ap'rrilTagtlh bIp lo’ 3D bobcho’, SoH bov loch bel qalib'rrated bej ghaH jIH tat! Inaqqur'rate tat jIH Dev baH joq joq.
:::

baH qalib'rrate baS bov, jIH chap baS Char'ruqo tIj (qoj ghaH) bel tlhap. bong qomparrin'g nuqDaq ghaH jIH joq volchaH bel bep bep logh (cha’Hu’ examp'le, baS joq wa’logh Hoch jIH bep beq 8x6 jIH) batlh nuqDaq bIH nargh bep ghaH bov jIH, maH HotlhwI’ tu’ baS Qav-tl'hquarretlh noH cha’Hu’ int'rrintlhiq bov tlhegh parHa’ foq'al nI’, botlh jIH, bIp joq qoeffiqientt'lh. cha’Hu’ joq batlh bov tat, bel jIH ghaH [OpenCV documentation](https://docs.opencv.org/4.x/dc/dbb/tutorial_py_calibration.html).

:::{ghuHmoH}
jIH law’ tat HotlhwI’ bel qalibr'rated, ghaH tat may bel Ho’ joq-wa’maH cha’Hu’ je’ joq baH ghop. ghaH, maH chup ngong baH legh nuqneH vum toH cha’Hu’ SoH joq.
:::

:::{Qo’}
ghaH tat dat'a boS jIH tat bel tlhpe'qifiq baH paQDI’norgh Qel bov, bel toH bel paQDI’norgh individua'l tat.
:::

## tat jIH

Aqqurr'ate bov tat bel poQ bep ra’ baH Suq a'qqurrate chIch jIH ghaH lo’ AprrilTa'gtlh bIp 3D bobcho’. ghaH jIH bIng volchaH QaH SIQ Qapla’:

01. SIQ ghaH jIH SoH tlhap ghaj ghaH DoS bep pIm ba’ bIp taH, batlh bel jIH chap baS differre'nqe joj taH bel DuH. ’oH bel ghap baH Qagh bel ghaH DoS over'rlay jIH tlhegh chen batlh ghaH tIj jIH baH jIH. jIH Qo’ pagh t'han 45 degrre'etlh.
02. lo’ bel jIH chap baS tat DoS bel SoH jIH HotlhwI’ jIH.
03. SIQ net SoH jIH patter'rn ghaj Qo’ chIS ra’ yav ’oH.
04. SIQ SoH bov tlhta'ytlh bep wa’ ba’ jIH ghaH nI’ chap ghaH tat.
05. Qagh bel SoH Suq Hoch 12 jIH DoH varryi'ng chuq bIp taH.
06. tlhap bej Qav wa’ jIH ’e’ tu’ ghaH tota'l jIH yoS, bIp bov SIQ net SoH Suq bortaS bov chap ghaH nI’ batlh SoH jIH cher.
07. ghaj jaH Doch, ghaj baS lo’ choS DoS QID bel toH (choS Hoch boch batlh ghaH DoS jIH QIb).
08. SIQ ghaH tat DoS bel HeQ fla't bIp baH Huv SIH pagh fo'ld bep law’ DoH. ’oH volchaH bel HuD/tape'd jotlh baH vay’ fla't bIp vaj lo’ cha’Hu’ tat, baH Huv neH choljaH ’oH chen.
09. jIH ghaj DoS ’e’ bel Don baH ghaH nI’ chap ghaH bov / chorgh batlh veS ghaH bov bel ’ar bel DuH. SoH neH taH bIp tat jIH SoH tat jIH.

tlha’ ghaH qech Dung volchaH QaH bep Suq beq aqq'urrate tat.

## Calibrrati'ng lo’ tat

### 1. chIj baH ghaH tat ’ay’ bep ghaH bup.

ghaH bov bergh chap ghaH bup lo’ tat'klingon bov tat jIH. ’oH boQ maH batlh qal'ibrrating ghaH bov, bel toH bel chaw’ bIH baH jIH maH q'alibrrated tat. maH pagh nuQ qharru'qo bIp ghaH tat.

### 2. jIH buS ghaH tat DoS.

bep ghaH bov tat bergh, maH'bong jIH buS ghaH tat DoS lo’ ghaH "D'ownload" ’ach. jIH volchaH bel jIH batlh 8.5x11 jIH nav. jIH p'age ’ang lo’ beq 8x8 qha'rruqo tIj (joq ghaH tlhab batlh ghaH wIv tat ’er).

:::{ghuHmoH}
SIQ ’e’ pa’ bel Qo’ ghIj Quch jIH jIH (’oH volchaH bel bej 100%) bIp ’e’ ghaH PDF bel jIH bel bel batlh reghuluSngan jIH nav. ghaH ghaH tlhquarr'e jIH batlh jIH ghap beq aqq'urrate juv jan cha’leS jIH baH SIQ tlhquarretl'h bel jIH tlhegh, bIp ’el ghaH teH jIH chap ghaH tl'hquarre bep ghaH bup t'ext box. cha’Hu’ jIH leS, Sar Sup bel av'ailable jIH baH qalibrra'te SoH tlhpeqif'iq jIH beH nee'ded.
:::

### 3. wIv tat tat bIp teb bep app'rroprriate DoS dat'a.

maH'bong retlh wIv baS tat baH qalibrr'ate bIp po'pulate bo’DIj patte'rrn logh, ma'rrkerr jIH, bIp tIj jIH. ghaH jIH ghaH bIp qharru'qo tIj bel beq 8x8 jIH chap 1 jIH tlhqua'rre. ghaH jIH qh'arruqo tIj lo’ ghaH 4x4 mu’ghom batlh baS marr'kerr jIH chap 0.75 jIH (jIH tIj baH Huv ne'ed ghaH bIr poSmoH patt'errn joq wIv). jIH bel Huv pup, bIp SoH nee'd baH juv SoH tat DoS bIp ’el ghaH lugh m'arrkerr jIH (jIH chap ghaH ar'ruqo m'arrkerr) bIp pa'tterrn logh (aka jIH chap ghaH qIj tlhquar're) lo’ jIH ghap jIH. Hoch, wa’logh bo’DIj ’el da'ta bel lugh, maH'bong jIH "Hov tat."

:::{ghuHmoH} bIr poSmoH Pa'tterrn qoj. jIH volchaH bel lo’ bep ghaH vaj ’e’ ghaH tat jIH bel bov DoH baS jIH chap poSmoH cha’Hu’ jIH 4.6.0. jIH QID jIH DoS Sop bong jIH.buv. beH jIH qoj bel Huv cher qoj ghaH tat jIH bel HeQ jIH. cha’Hu’ qoj De’ jIH [this GitHub issue](https://github.com/opencv/opencv_contrib/issues/3291).
:::

:::{Qo’}
beH SoH ghaj baS [calib.io](https://calib.io/) Ch'arruCo DoS SoH jIH ghaj baH ’el ghaH Hap chap SoH DoS. cha’Hu’ e'xample beH SoH DoS tlh'aytlh "9x12 | ghaH jIH: 30 chup | Marrke'rr jIH: 22 chup | mu’ghom: Ar'ruCo HI’ 5x5", SoH QID ghaj baH cher ghaH tIj ’er baH Dict_5x5_1000, ghaH patte'rrn logh baH 1.1811 bep (30 chup qon'verrted baH jIH), ghaH mar'rkerr jIH 0.866142 bep (22 chup qon'verrted baH jIH), ghaH tIj jIH baH 12 bIp ghaH tIj chorgh baH 9. beH SoH wIv ghaH muj Sorgh qorDu’ ghaH tIj jIH bel cheH jIH tat. beH SoH t'lhwap ghaH jIH bIp chorgh SoH tat jIH ghaj baS Hoch jen Qagh.
:::

### 4. tlhap bej tat jIH DoH Sar taH.

DaH, maH'bong jon jIH chap bo’DIj tIj DoH Sar taH. ’oH'klingon ghap baH ghaH ’e’ ghaH tIj ov'errlay bej ghaH tIj bep SoH jIH. ghaH Hop ghaH ove'rrdrrawn jIH bel DoH ghaH teH ba’ chap ghaH ghaH ghap, ghaH lo’laHbe’ aqqur'rate ghaH jIH tat jIH bel. maH'bong neH baH jon Qo’ jIH baH tu’ ghaH whol'e bov'klingon FOV (batlh baS jIH chap 12). wa’logh maH'bang Suq bo’DIj jIH, maH'bong jIH "jIH tat" bIp jIH cha’Hu’ ghaH tat tlhol baH qomple'te. beH Hoch jaH toH, ghaH qej Qagh bIp F'OVtlh jIH bel ’ang bep ghaH bergh batlh ghaH wov. ghaH FOV volchaH bel SoQmoH baH ghaH bov'klingon jIH FOV (Hoch tu’ bep baS De’) Hoch jIH + qoj - 10 de'grreetlh. ghaH qej Qagh volchaH je bel bIng, Hoch lo’laHbe’ tha'n 1 jIH.

```{raw} html
<video width="85%" controls>
    <source src="../../_static/assets/calibration_small.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>
```

## naw’ tat jIH

jIH buS baS ghom tat HotlhwI’ bel jIH bong jIH batlh ’e’ tat bep ghaH tat bergh. jIH bergh chaw’ SoH baH do'wnload tlhol tat da'ta, up'load baS maH tat, bIp jIH jIH buS SIm bov int'rrintlhiq.

```{image} images/cal-details.png
:alt: Captured calibration images
:width: 600
```

:::{Qo’}
pagh De’ batlh nuqneH ghaH jIH qej HotlhwI’ bel tu’ bep [OpenCV's docs](https://docs.opencv.org/4.8.0/d4/d94/tutorial_camera_calibration.html)
:::

- tI’/buv: noH bov f'oqal nI’, bep chup
- tI’/chach: noH bov jIH botlh, bep jIH. jIH volchaH bel bej buS ghaH botlh chap ghaH jIH
- pagh: poSmoH bov mode'l qoj qoeffi'qienttlh
- FOV: SIm lo’ noH f'oqal nI’ bIp jIH jIH. lI’ cha’Hu’ gut-ghaH tat leS
- qej Qagh: qej jInmol Qagh, pagh chuq joj pIH bIp tu’ ghaH bov cha’Hu’ ghaH f'ull tat De’

bIng ghaH o'utputtlh bel ghaH bach boS cha’Hu’ tat, alon'g batlh baS chaq-bach qej jInmol Qagh. baS bach batlh baS ghoH Hotlh Qagh jIH in'diqate baS qab bach, Hay’ baH cheH tlh'uqh bel jIH blur'r joq Dop ghaH ghap.

tat jIH HotlhwI’ je bel vang DoH ghaH down'loaded vaj jIH lo’ [this Python script](https://raw.githubusercontent.com/PhotonVision/photonvision/main/devTools/calibrationUtils.py). jIH ghItIh jIH unpa'qk tat jIH, bIp je bov baS VNL jIH cha’Hu’ lo’ [with mrcal](https://mrcal.secretsauce.net/).

```
python3 /path/to/calibrationUtils.py path/to/photon_calibration.json /path/to/output/folder
```

```{image} images/unpacked-json.png
:alt: Captured calibration images
:width: 600
```

## lojmIt tat Da'ta batlh mrrqa'l

[mrcal](https://mrcal.secretsauce.net/tour.html) bel baS ra’-tlhegh to'ol cha’Hu’ bov tat bIp tat. tat ghaj ghaH DuH baH lo’ ghaH m'rrqal ba'qkend jIH bov tat baH noH intrrintlhi'qtlh. m'rrqal HotlhwI’ je bel lo’ lum-tat baH jIH bach bIp jIH feedbaq'k. ghaH gho’ jIH SoQmoH tlha’ ghaH [mrcal tour](https://mrcal.secretsauce.net/tour-initial-calibration.html) -- I'baS lojmIt ra’ bIp Qo’ naDev, ’ach ghaH mrrq'al jIH bel ’ar ghap pagh.

Hov bong [Installing mrcal](https://mrcal.secretsauce.net/install.html). Qo’ net jIH mrrq'al *tat* lo’ tat bel joq batlh Hoch ghap, ’a tat wov DaH neH Qap batlh jIH. je’ maH ghaj je ja’ Do’ lo’ [WSL 2 on Windows](https://learn.microsoft.com/en-us/windows/wsl/tutorials/gui-apps) bel toH. SoH may je nee'd baH Hoch `feedgnu'plot`. batlh Ub'untu pat, ghaH ra’ volchaH bel qet DoH baS Qam terrm'inal bIp *Huv* ghaH wa’ [built into vscode](https://github.com/ros2/ros2/issues/1406).

Ha’'klingon che’ `tat.ghIH` bel detlhqr'ribed Dung, bIp vaj qd chech ghaH ou'tput choljaH. DoH naDev, SoH HotlhwI’ tlha’ ghaH mrrqa'l to'urr, neH lan ghaH VNL jIH bIp bov jIH jIH bel ’ut. jagh bov tat bel bej 1280x720, toH I'bang cher ghaH qIb vuS baH net bIng.

```
$ cd /path/to/output/folder
$ ls
matt@photonvision:~/Documents/Downloads/2024-01-02_lifecam_1280$ ls
  corners.vnl  img0.png  img10.png  img11.png  img12.png  img13.png  img1.png
  img2.png  img3.png  img4.png  img5.png  img6.png  img7.png  img8.png
  img9.png  cameramodel_0.cameramodel

$ < corners.vnl       \
  vnl-filter -p x,y | \
  feedgnuplot --domain --square --set 'xrange [0:1280] noextend' --set 'yrange [720:0] noextend'
```

```{image} images/mrcal-coverage.svg
:alt: A diagram showing the locations of all detected chessboard corners.
```

bel SoH HotlhwI’ legh, maH jIH'bach baH baS fan'tatlhtiq job chap tu’ bo’DIj who'le bov noch -- pa’'klingon baS jIH gap aqr'rotlhtlh ghaH w'hole wov Dop, cha’Hu’ exa'mple. maH je neH ghaj 14 tat jIH. maH'bang je Suq bo’DIj "bov" jIH, jIH HotlhwI’ bel lo’ bong mrr'qal baH cha’ chel debu'g De’.

Ha’'klingon jIH bo’DIj jInmol Qagh rretlhi'dualtlh. maH pIH ghaH ’oH bIp tat baH bel voHDajbo’ -- beH pa’'klingon patterrnt'lh bep ghaH pagh cha’, vaj bo’DIj tat Hej cha'bach ful'ly QIj bo’DIj Qel bov noch.

```
$ mrcal-show-residuals --magnitudes --set 'cbrange [0:1.5]' ./camera-0.cameramodel
$ mrcal-show-residuals --directions --unset key ./camera-0.cameramodel
```

```{image} images/residual-magnitudes.svg
:alt: A diagram showing residual magnitudes
```

```{image} images/residual-directions.svg
:alt: A diagram showing residual directions
```

Cle'arrly maH Ion'bach ghaj ghaH chol Qo’ da'ta baH drra'w law’ jIH maH (wej). ’ach cha’Hu’ nol, Ha’'klingon jIH chech [camera uncertainty estimation](https://mrcal.secretsauce.net/tour-uncertainty.html). jIH jIH ’ang ’ach pIH tat Qagh choH Hay’ baH jIH bep tat jIH. maH tat Qagh aqr'rotlhtlh baS ghoH yoS chap ghaH noch jIH baS toH tat ’e’ qoj ful'ly tu’ ghaH who'le noch. cha’Hu’ jagh tat d'ata, SoH HotlhwI’ ja’ ghaH tat Qagh jIH (tlhegh chap ghIb pIH tat Qagh) bel tlh'kewed baH ghaH leSpoH, tlha’ jagh De’ (jIH bel je tlh'kewed leSpoH).

```
$ mrcal-show-projection-uncertainty --unset key ./cameramodel_0.cameramodel
```

```{image} images/camera-uncertainty.svg
:alt: A diagram showing camera uncertainty
```
