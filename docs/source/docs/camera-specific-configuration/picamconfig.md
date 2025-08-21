# DIng bov tat

jIH pag'e tu’ tlhpeqifiq'tlh buS ghaH _Raspberry Pi_ jIH bov tat.

## yav

ghaH Qagh DIng jIH bov qoj bel He thrro'ugh bIp tlhol bong ghaH GPU. jIH ghaH GPU boottl'h cha’Hu’ ghaH CPU, ’oH loch bel qonf'igurred tlhegh cha’Hu’ ghaH HIv bov. chel, jIH tat HotlhwI’ bel choH jIH rrebo'oting.

ghaH GPU bel Huv reH bIH chap Duy’ nuQ bov Hoch. ghaH jIH `/bo'ot/jIH.txt` bel yev bong ghaH GPU bej b'oot poH baH tlhIl nuqneH bov, beH law’, bel pIH baH bel HIv. jIH jIH loch bel u'pdated cha’Hu’ je’ bov.

:::{ghuHmoH}
ghap bov tat jIH lo’ ghaH bov baH Huv bel Duy’. ’oH nej vang ghaH jIH bel beH ghaH bov bel unplu'gged.
:::

## U'pdating `jIH.txt`

cha’leS flatlhh'ing ghaH DIng jIH o'nto beq Daq nuch, poSmoH ghaH `b'oot` jIH bep baS jIH brrowtlh'err.

:::{Qo’}
jIH may ja’ "pa’ bel baS Hej batlh jIH jIH". jIH volchaH bel pagh.
:::

Loqa'te `jIH.txt` bep ghaH choljaH, bIp poSmoH ’oH batlh SoH ghap te'xt qoj.

```{image} images/bootConfigTxt.png

```

jIH ghaH jIH, tu’ jIH bot chap tex't:

```
##############################################################
### PHOTONVISION CAM CONFIG
### Comment/Uncomment to change which camera is supported
### Picam V1, V2 or HQ: uncomment (remove leading # ) from camera_auto_detect=1,
### and comment out all following lines
### IMX290/327/OV9281/Any other cameras that require additional overlays:
### Comment out (add a # ) to camera_auto_detect=1, and uncomment the line for
### the sensor you're trying to user

cameraAutoDetect=1

# dtoverlay=imx290,clock-frequency=74250000
# dtoverlay=imx290,clock-frequency=37125000
# dtoverlay=imx378
# dtoverlay=ov9281

##############################################################
```

teq ghaH Dev `#` vang baH jIH ghaH tlhegh toH batlh SoH bov. chel baS `#` bep frro'nt chap nuQ bov.

:::{ghuHmoH}
leSpoH tlhegh Hur ghaH tat bov jIH bot ghaH. bIH bel ’ut cha’Hu’ chep Qagh DIng Qap.
:::

toD ghaH jIH, SoQmoH ghaH joq, bIp ej'eqt ghaH jIH. ghaH b'oot tat volchaH DaH bel Su’ cha’Hu’ SoH wIv bov.

## chel De’

legh [the libcamera documentation](https://github.com/raspberrypi/documentation/blob/679fab721855a3e8f17aa51819e5c2a7c447e98d/documentation/asciidoc/computers/camera/rpicam_configuration.adoc) cha’Hu’ ghap jIH batlh qonfigurrin'g bov.
