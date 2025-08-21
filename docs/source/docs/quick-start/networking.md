# cha’

## Qel cha’

:::{ghuHmoH}
ghaH lo’ tat DoH qoq, SoH _MUST_ p'lug ghaH joq chech baS Qel He/jIH. SoH HotlhwI’ vaj rar SoH l'aptop/jan lo’ baH jIH ghaH maH baH ghaH jIH cha’. law’ nuQ cha’ cher jIH Huv vum bIp jIH Huv bel pagh bep law’ veng.
:::

::::{bergh-cher}

:::{bergh-jIH} chu’ jIH (2025 - much)

```{danger}
Ensure that the radio's DIP switches 1 and 2 are turned off; otherwise, the radio PoE feature may electrically destroy your coprocessor. [More info.](https://frc-radio.vivid-hosting.net/overview/wiring-your-radio#power-over-ethernet-poe-for-downstream-devices)
```

```{image} images/networking-diagram-vividhosting.png
:alt: Wiring using a network switch and the new vivid hosting radio
```

:::

:::{bergh-jIH} bIr jIH (bot 2025)

tat _STRONGLY_ chup ghaH maH chap baS cha’ leQ batlh SoH qoq. jIH bel lo’ ghaH cha’DIch jIH qoj batlh ghaH bIr FRC jIH bel Sov baH bel bugg'y bIp lo’ Se’ tat jIH ’e’ bel jIH jIH Saj. beq bep-dept'h Dev batlh ’ach baH Hoch baS cha’ leQ HotlhwI’ bel tu’ [on FRC 900's website](https://zebracorns.org/blog/ZebraSwitch/).

```{image} images/networking-diagram.png
:alt: Wiring using a network switch and the old open mesh radio
```

:::
::::

## cha’ jIH

jIH paQDI’norgh jan DoH ghaH pIch "tat" baH baS jIH jIH (klingon.klingon., "Phot'on-chuq-leSpoH" joq "Ph'oton-RPi5-chap"). jIH QaH differrentiat'e mul'tiple qoj batlh SoH cha’, Qagh ’oH bIt baH vu’ chaH. chIj baH ghaH jIH pag'e bIp tlhq'rroll jotlh baH ghaH cha’ ’ay’. SoH jIH tu’ ghaH jIH bel cher baH "tat" bong pIch, jIH HotlhwI’ neH jIH letterrt'lh (baS-buD), jIH vang (0-9), bIp ghaH jIH jIH (-).

```{image} images/editHostname.png
:alt: The hostname can be edited in the settings page under the network section.
```

## qoq cha’

tat _STRONGLY_ chup ghaH maH chap jIH jIH bel ’oH ghur laH batlh ghaH HoSchem bIp ghaH lo’ tat bep bov. baH tlhegh cher chen SoH jIH bep, tlha’ ghaH gho’ bIng:

:::{ghuHmoH}
neH lo’ baS jIH bep ghaH rar baH ghaH **qoq jIH**, bIp not ghaH jIH bej juH, un'letlhtlh SoH bel toH ’u’ bep cha’ ghap ghaj ghaH rrele'vant "Sov ’ach".
:::

1. SIQ SoH qoq bel batlh bIp SoH bel rar baH ghaH qoq cha’.
2. chIj baH `tat.lo'qal:5800`bep SoH brrowtlh'err.
3. poSmoH ghaH jIH bergh batlh ghaH leSpoH SeHlaw.
4. bIng ghaH cha’ ’ay’, cher SoH SeS mI’.
5. choH SoH bep baH jIH.
6. cher SoH joq'klingon bep SoQ baH “10.be’nI’.bel.11”. ghap De’ batlh bep De’ HotlhwI’ bel tu’ [here](https://docs.wpilib.org/en/stable/docs/networking/networking-introduction/ip-configurations.html#on-the-field-static-configuration).
7. jIH ghaH “pol” ’ach.

HoS-qy'qle SoH qoq bIp vaj SoH jIH DaH bel naw’ ghaH tat tIj bej `10.be’nI’.bel.11:5800`.

```{image} images/static.png
:alt: Correctly set static IP
```

ghaH "SeS mI’" HoSchem jIH laj (bep chel baH baS SeS mI’) beq bep SoQ qoj jIH. jIH bel lI’ cha’Hu’ jIH tat batlh ghaH jIH De’wI’ bel baS tlh'imulated qoq ghun;
SoH HotlhwI’ cher ghaH SeS mI’ baH "loqa'lhotlht", bIp tat jIH ngeH da'ta baH ghaH cha’ bergh bep ghaH tl'himulated qoq.

## qoj pagh

:::{Qo’}
beH SoH bel lo’ baS VH-109 jIH (2025 bIp nech, exqludin'g jIH bIp jIH), SoH volchaH Huv lo’ pagh qoj. jIH, ghaH baH ghaH ded'iqated ngem ghaH ghap batlh ghaH VH-109. ghaH VH-109 baH Huv jIH ghaH jIH tu’ bep ghaH OM5P jIH batlh mult'iple pagh, bIp batlh baS dediqate'd ngem joq, ’oH jIH qoj r'realitlhtiq bej Doghjey bIp teq ghaH n'eed baH ghaH chuv loDnal.
:::

beH SoH QID parHa’ baH naw’ SoH ghaH-rar jIH jan DoH baS De’wI’ ghaH Doq baH ghaH loDnal joq batlh ghaH joq, SoH HotlhwI’ lo’ [WPILib's](https://docs.wpilib.org/en/stable/docs/networking/networking-utilities/portforwarding.html) `pagh`.

```{eval-rst}
.. tab-set-code::

    .. code-block:: Java

        PortForwarder.add(5800, "photonvision.local", 5800);

    .. code-block:: C++

        wpi::PortForwarder::GetInstance().Add(5800, "photonvision.local", 5800);

    .. code-block:: Python

        # Coming Soon!
```

:::{Qo’}
ghaH SoQ bep ghaH ngoq Dung (`tat.loq'al`) bel ghaH jIH chap ghaH joq. jIH HotlhwI’ bel pIm tlhab batlh SoH veS, bIp HotlhwI’ bel ghaH bep ghaH jIH bergh bIng "jIH".
:::

## bov SeS ghap

ghaH bov SeS Hov bej 1181 batlh cha’ qoj cha’Hu’ paQDI’norgh bov (ghIm. 1181 bIp 1182 cha’Hu’ bov wa’, 1183 bIp 1184 cha’Hu’ bov cha’, etq.). ghaH bIt DoH baH ngu’ ghaH qoj chap ghaH bov ’e’ SoH neH bel bong Seng jIH batlh ghaH SeS, jIH poSmoH ’oH bep baS chev p'age. ghaH qoj jIH bel jIH bIng ghaH SeS.

:::{ghuHmoH}
beH SoH bov SeS jIH'bach ngeH baH ghaH jIH pagh bel ’oH'klingon joq tu’ batlh, jIH SeS jIH Huv bel jIH bep ghaH bup.
:::
