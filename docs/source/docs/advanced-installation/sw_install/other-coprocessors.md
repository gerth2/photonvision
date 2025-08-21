# nuQ jIH-waw’ bep-qoj Hoch

:::{ghuHmoH}
vum batlh ghap ghap poQ je’ l'evel chap "Sov ’a" chap SoH pat. ghaH Hoch ghItIh ghaj neH bel muS batlh jIH/Qagh DIng chep maH bIp Ub'untu jIH. beH law’ jIH jIH batlh SoH tl'hpeqifiq chep, bel poSmoH beq jIH batlh bo’DIj [issues page](https://github.com/PhotonVision/photonvision/issues).
:::

:::{Qo’}
maH'batlh bang baH ghaj SoH jIH! beH SoH Suq tat Qap batlh ghaH qoj, Dop jIH SoH gho’ bIp jIH baS [docs issue](https://github.com/PhotonVision/photonvision-docs/issues)., [pull request](https://github.com/PhotonVision/photonvision-docs/pulls) , pagh [ping us on Discord](https://discord.com/invite/wYxTwym). cha’Hu’ ex'ample, jIH bIp jIH Hoch tat ghoS buS lo’ je’ ngeH ghaH poH baH jIH ’oH buS, bIp baH baS jIH.
:::

## jIH tat

maH jIH beq [install script](https://git.io/JJrEP) cha’Hu’ nuQ jIH-waw’ pat (batlh `HoD`) ’e’ jIH Hoch Hoch tat bIp Qagh bel net ’oH qet batlh Hov.

```bash
$ wget https://git.io/JJrEP -O install.sh
$ sudo chmod +x install.sh
$ sudo ./install.sh
$ sudo reboot now
```

:::{Qo’}
SoH bep-ghap jIH poQ beq Interrne't tat cha’Hu’ jIH tlhol baH vum qoj.
:::

cha’Hu’ Hoch batlh law’ nuQ bep-qoj, maH chup laD ghaH {lulIgh}`Duv ra’ tlhegh jIH <Qel/Duv-Hoch/sw_install/Duv-qmd:Duv ra’ tlhegh maH>`.

## Updati'ng tat

tat HotlhwI’ bel upd'ated bong down'loading ghaH Hoy’ jar'r jIH, HeQ ’oH o'nto ghaH pagh, bIp Hov ghaH chuch.

cha’Hu’ ex'ample, DoH ghaH De’wI’, qet ghaH tlha’ ra’. tam ghaH lugh jIH cha’Hu’ "\[maH\]" ( jIH jIH lo’ jIH "DIng")

```bash
$ scp [jar name].jar [user]@photonvision.local:~/
$ ssh [user]@photonvision.local
$ sudo mv [jar name].jar /opt/photonvision/photonvision.jar
$ sudo systemctl restart photonvision.service
```
