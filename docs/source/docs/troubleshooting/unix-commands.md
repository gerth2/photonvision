# lI’ jIH ra’

## cha’

### SSH

[SSH (Secure Shell)](https://www.mankier.com/1/ssh) bel lo’ baH vor rar DoH baS loqa'l baH baS Hop pat (ghIm. DoH baS lapt'op baH baS qoj). jIH nuQ ra’ batlh jIH p'age, tlhtl'hh bel Huv jIH tlhpe'qifiq bIp HotlhwI’ bel baH batlh jIH bIp Ma'qOS DoH ghaH vuv terrmina'ltlh.

:::{Qo’}
SoH may legh baS ghuHmoH jIH baH `ghaH ghaH chap vub 'xxx' HotlhwI’'bach bel cher...` ghap `ghuHmoH: Hop vub tat ghaj choH!`, bep mo'tlht vaj jIH HotlhwI’ bel tlhafe'ly qoj beH SoH ghaj jIH ’e’ SoH bel rar baH ghaH lugh vub chuv baS vor tat, bIp ghaH nItlh jIH choH ghaH SoH bov pat bel Hoch ghap tat'klingon joq jIH bel baH-f'latlhhed. jIH HotlhwI’ je qaS beH SoH ghaj m'ultiple ghap batlh ghaH jIH jIH batlh SoH cha’. SoH HotlhwI’ laD joq buS ’oH [here](https://superuser.com/questions/421997/what-is-a-ssh-key-fingerprint-and-how-is-it-generated)
:::

Exampl'e:

```
ssh pi@hostname
```

cha’Hu’ tat, ghaH jIH jIH bel `DIng` bIp ghaH joq jIH bel `Qagh`.

### bep

che’ [ip address](https://www.mankier.com/8/ip) batlh SoH qoj rar baH baS joq bep ra’ baH legh jIH bep SoQ bIp nuQ cha’ tat De’.

SoH o'utput jIH nej vay’ parHa’ jIH:

```
2: end1: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc mq state UP group default qlen 1000
    link/ether de:9a:8f:7d:31:aa brd ff:ff:ff:ff:ff:ff
    inet 10.88.47.12/24 brd 10.88.47.255 scope global dynamic noprefixroute end1
        valid_lft 27367sec preferred_lft 27367sec
```

bep jIH exam'ple, ghaH mI’ tlha’ `jIH` (10.88.47.12) bel SoH bep SoQ.

### jIH

[ping](https://www.mankier.com/8/ping) bel baS ra’-tlhegh jIH lo’ baH muS ghaH laH chap baS vub batlh beq bep cha’. ’oH je juv ghaH yav-leng poH cha’Hu’ jIH ngeH DoH ghaH pagh vub baH baS ghoch De’wI’. ’oH HotlhwI’ bel lo’ baH tlhIl beH baS cha’ qab bel avail'able, jIH HotlhwI’ bel ghaH ghaH debuggin'g.

## jIH Qay

Hoch jIH bIng `/DuH/tat` bel jotlh bong ghaH qoq maH. jIH qej ’e’ beH SoH neH baH jIH bIH, ghaH ra’ baH baH vaj loch bel che’ bel tl'hudo.

### SCP

[SCP (Secure Copy)](https://www.mankier.com/1/scp) bel lo’ baH vor Qay jIH joj loqa'l bIp Hop pat.

Exa'mple:

```
scp [file] pi@hostname:/path/to/destination
```

### SF'TP

[SFTP (SSH File Transfer Protocol)](https://www.mankier.com/1/sftp#) bel ghaH DuH cha’Hu’ Qay jIH joj loqa'l bIp Hop pat.

### rop

[Filezilla](https://filezilla-project.org/) bel baS Dev choH baH SCP bIp S'FTP. ’oH bel availa'ble cha’Hu’ jIH, Maq'OS, bIp jIH.

## maH

### v4l2-qtl

[v4l2-ctl](https://www.mankier.com/1/v4l2-ctl) bel baS ra’-tlhegh too'l cha’Hu’ SeH jIH jan.

jIH avail'able jIH jan (lo’ baH ’ol ghaH jan ghov baS rar bov):

```
v4l2-ctl --list-devices
```

jIH joq De’ bIp tat cha’Hu’ baS tlhp'eqifiq jIH jan:

```
v4l2-ctl --list-formats-ext --device /path/to/video_device
```

jIH Hoch jIH jan'klingon SeH bIp ghaH valuetl'h:

```
v4l2-ctl --list-ctrls --device path/to/video_device
```

:::{Qo’}
jIH ra’ bel Hoch lI’ bep QaH baH d'ebug ghaH jIH bov SeH, parHa’ ex'potlhurre, arr'en'bach ghaj bel pIH. beH SoH legh beq Qagh bep ghaH QonoS jIH baH `ghuHmoH 30: luj baH cher tlhegh [tlhegh pong] (bov.qpp:646)`, net qej ’e’ tat bel nID baH lo’ baS SeH net cha'bach jIH pagh ghaj baS pIm pong batlh SoH veS. beH SoH ghom jIH jIH, bel [file an issue](https://github.com/PhotonVision/photonvision/issues) batlh ghaH ’ut QonoS bIp o'utput chap ghaH `v4l2-qtl --jIH-qtr'rltlh` ra’.
:::

### pat

[systemctl](https://www.mankier.com/1/systemctl) bel baS ra’ ’e’ SeH ghaH `pat` pat bIp chuch vu’wI’.

Hov tat:

```
systemctl start photonvision
```

mev tat:

```
systemctl stop photonvision
```

Hov tat:

```
systemctl restart photonvision
```

ghaH ghaH Dotlh chap tat:

```
systemctl status photonvision
```

### QonoS

[journalctl](https://www.mankier.com/1/journalctl) bel baS ra’ net querri'etlh ghaH pat QonoS, jIH bel baS QonoS pat lo’ bong law’ jIH tat.

jIH ghaH tat QonoS:

```
journalctl -u photonvision
```

jIH ghaH tat QonoS bep tlhoj-poH:

```
journalctl -u photonvision -f
```
