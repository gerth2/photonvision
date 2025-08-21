# Deployin'g batlh tIgh veS

## tat

bong pIch, tat nID baH Qagh jIH tat chap ghaH veS ’oH che’ batlh. ’ach, ’oH may bel qonfigur'red baH enab'le tIgh Dev SeH, yab, bIp nuQ Qap.

`veS.vaj` bel ghaH tat cha’Hu’ jIH tat. ’oH bel jIH ghaH jIH bel qoj, bIp HotlhwI’ bel u'ploaded bel jeS chap baS .jIH, joq batlh jIH jotlh.

## Dev joq

cha’Hu’ Qagh-DIng waw’ veS, tat HotlhwI’ lo’ [PiGPIO](https://abyz.me.uk/rpi/pigpio/) baH SeH buv jIH. ghaH jIH chap jIH jIH SeH jIH Dev'klingon bel jeS chap ghaH veS jIH. ghaH jIH bel jIH-jen: cher jen ghaH Dev'klingon bel ra’ batlh, bIp cher bIng ghaH ra’ DoH.

```{eval-rst}
.. tab-set-code::
   .. code-block:: json

      {
        "ledPins" : [ 13 ],
        "ledSetCommand" : "",
        "ledsCanDim" : true,
        "ledPWMRange" : [ 0, 100 ],
        "ledPWMSetRange" : "",
        "ledPWMFrequency" : 0,
        "ledDimCommand" : "",
        "ledBlinkCommand" : "",
        "statusRGBPins" : [ ],
      }
```

:::{Qo’}
Qo’ veS tIj batlh Dotlh RGB Dev jIH pagh Dap-jIH Dev'klingon ghaj bel muS wej. bel SIch buS baH ghaH jIH SeS beH ghaH Sop bel jIH, bIH HotlhwI’ boQ batlh tat bIp jIH.
:::

## veS bov ra’

cha’Hu’ Dap-Qagh-DIng veS, maH loch jIH jIH veS-tlhpe'qifiq ra’ cha’Hu’ je’ jeS chap ghaH bup bov (jIH joq jIH, bIp muH pat Hov).

leSpoH baS ra’ bl'ank jIH Qotlh ghaH toH Qap.

```{eval-rst}
.. tab-set-code::
   .. code-block::  json

      {
        "cpuTempCommand" : "",
        "cpuMemoryCommand" : "",
        "cpuUtilCommand" : "",
        "gpuMemoryCommand" : "",
        "gpuTempCommand" : "",
        "ramUtilCommand" : "",
        "restartHardwareCommand" : "",
      }
```

:::{Qo’}
ghaH jIH ghaj Qo’ cheH beH tat cheH ’oH bel che’ batlh baS Qagh DIng. legh [the MetricsBase class](https://github.com/PhotonVision/photonvision/blob/dbd631da61b7c86b70fa6574c2565ad57d80a91a/photon-core/src/main/java/org/photonvision/common/hardware/metrics/MetricsBase.java) cha’Hu’ ghaH ra’ jIH.
:::

## Sov bov FOV

beH SoH veS jIH baS bov batlh baS Sov HoSchem chap jIH, ’oH HotlhwI’ bel ’el chech ghaH veS tat. jIH jIH bot maH DoH Hoq ’oH bep ghaH Dev.

```{eval-rst}
.. tab-set-code::
   .. code-block:: json

      {
        "vendorFOV" : 98.9
      }
```

## jIH & yab

baH QaH differrentia'te SoH veS DoH nuQ taS, je’ maH bel chaw’.

```{eval-rst}
.. tab-set-code::
   .. code-block:: json

      {
        "deviceName" : "Super Cool Custom Hardware",
        "deviceLogoPath" : "",
        "supportURL" : "https://cat-bounce.com/",
      }
```

:::{Qo’}
Huv Hoch tat bel qurrr'rently much bep ghaH maH qab. chel jIH uploadtl'h may bel nee'ded baH pagh tIgh jIH.
:::

## Ex'ample

naDev bel baS q'omplete exampl'e `veS.toH`:

```{eval-rst}
.. tab-set-code::
   .. code-block:: json

      {
        "deviceName" : "Blinky McBlinkface",
        "deviceLogoPath" : "",
        "supportURL" : "https://www.youtube.com/watch?v=b-CvLWbfZhU",
        "ledPins" : [2, 13],
        "ledSetCommand" : "",
        "ledsCanDim" : true,
        "ledPWMRange" : [ 0, 100 ],
        "ledPWMSetRange" : "",
        "ledPWMFrequency" : 0,
        "ledDimCommand" : "",
        "ledBlinkCommand" : "",
        "statusRGBPins" : [ ],
        "cpuTempCommand" : "",
        "cpuMemoryCommand" : "",
        "cpuUtilCommand" : "",
        "gpuMemoryCommand" : "",
        "gpuTempCommand" : "",
        "ramUtilCommand" : "",
        "restartHardwareCommand" : "",
        "vendorFOV" : 72.5
      }
```
