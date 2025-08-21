# jIH Hoch

ghaH [Romi](https://docs.wpilib.org/en/latest/docs/romi-robot/index.html) bel baS Hoch qoq ’e’ HotlhwI’ bel SeH batlh ghaH jIH vaj. ghaH jIH SeH bel baS Qagh DIng ’e’ loch bel jIH batlh [WPILibPi](https://docs.wpilib.org/en/latest/docs/romi-robot/imaging-romi.html) .

## Hoch

ghaH WPIL'ibPi jIH jIH tat, jIH choq loDnal bov; baH lo’ tat, maH n'eed baH Hoq ghaH `/juH/DIng/bov` ghItIh baH Qotlh ’oH. wa’DIch maH jIH n'eed baH Qagh ghaH jIH pat ghItlh; ghaH bIt DoH baH baH jIH bel baH jaH baH `10.0.0.2` bIp wIv "’oH" bej ghaH net.

SSH chech ghaH Qagh DIng (lo’ jIH ra’ tlhegh, ghap baS too'l parHa’ [Putty](https://www.chiark.greenend.org.uk/~sgtatham/putty/) ) bej ghaH jIH'klingon pIch SoQ `10.0.0.2`. ghaH pIch maH bel `DIng`, bIp ghaH pagh bel `Qagh`.

:::.. ghaH tlha’ parrag'rraph HotlhwI’ bel joq ghaH WP'ILibPi moj qompat'ible batlh ghaH q'urrrrent jIH chap tat.
:::.. tlha’ ghaH tlhol cha’Hu’ jIH tat batlh {lulIgh}`"nuQ jIH-waw’ bep-joq Hoch" <Qel/Duv-Hoch/sw_install/nuQ-ghap:nuQ jIH-waw’ bep-qoj Hoch>`. bel ’oH jIH, jIH jIH poQ beq i'nterrnet tat toH rar ghaH Qagh DIng baH beq interrn'et-rar He jIH beq ghaH bergh jIH bel ghaH bIt taS. ghaH DIng loch ratlh ’oH jIH SoH bel tlha’ ghaH gho’!

:::..ru’ tat QIj ’a baH Hoch ghaH bIr jIH chap tat batlh baS jIH. teq ghaH Qo’ nI’ nee'ded.
:::{qIm}
ghaH jIH chap WPILi'bPi cha’Hu’ ghaH jIH bel 2023.2.1, jIH bel Huv qompatib'le batlh ghaH q'urrrrent jIH chap tat. **beH SoH bel lo’ WPIL'ibPi 2023.2.1 batlh SoH jIH, SoH loch Hoch tat v2023.4.2 qoj ear'rlierr!**

baH Hoch baS qomp'atible jIH chap tat, ’el ghaH ra’ bep ghaH SSH terrmi'nal rar baH ghaH Qagh DIng. jIH jIH downl'oad bIp qet ghaH Hoch ghItIh, jIH jIH Hoch tat batlh SoH Qagh DIng bIp qonfigurr'e ’oH baH che’ bej Hov.

```bash
$ wget https://git.io/JJrEP -O install.sh
$ sudo chmod +x install.sh
$ sudo ./install.sh -v v2023.4.2
```
ghaH Hoch ghItIh poQ beq interrn'et tat, toH rar ghaH Qagh DIng baH beq i'nterrnet-rar He jIH beq ghaH bergh jIH bel ghaH bIt taS. ghaH DIng loch ratlh ’oH jIH SoH bel tlha’ ghaH gho’!
:::
:::..chom chap ru’ tat.

retlh, DoH ghaH SSH t'errminal, qet `t'lhudo Qo’ /juH/DIng/bov` vaj cha’leS jotlh baH ghaH Hov chap ghaH muH tlhegh bIp Doj "’el" baH chel baS chu’ tlhegh. vaj chel `#` cha’Hu’ ghaH muH ra’ baH jIH ’oH buS. vaj, cha’leS chen baH ghaH chu’ tlhegh bIp Qa’ `Qong 10000`. chIS "Ct'rrl + bach" bIp vaj "’el" baH pol ghaH jIH. Hoch Doj "Ctrr'l + DuD" baH jIH Qo’. DaH, r'reboot ghaH jIH bong Qa’ `tlhud'o rreb'oot DaH`.

```{image} images/nano.png

```

cha’leS ghaH jIH rreboott'lh, SoH volchaH bel bergh baH poSmoH ghaH tat bup bej: [`http://10.0.0.2:5800/`](http://10.0.0.2:5800/). DoH naDev, SoH HotlhwI’ lIS jIH bIp qonfi'gurre {lulIgh}`tlhegh <Qel/tlhegh/jIH:tlhegh>`.

:::{ghuHmoH}
bep ra’ cha’Hu’ jIH, QonoS, etq. baH bel pol / tlhap cheH, SIQ ’e’ tat bel bep ’oH bobcho’.
:::

:::{qIm}
ghaH lo’ beq bIr jIH chap tat, ghaH maH qab bIp Sop may bel pIm tha'n nuqneH nargh bep ghaH jIH jIH. ghaH [Documentation](http://10.0.0.2:5800/#/docs) jIH bep ghaH maH qab jIH poSmoH baS bu'ndled jIH chap ghaH jIH ’e’ bej ghaH tat jIH qet batlh SoH ghap.
:::
