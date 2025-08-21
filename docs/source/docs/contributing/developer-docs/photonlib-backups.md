# Photon'lib ’Itlh Qel

bo’DIj ma'ven jab bel loqa'ted bej h'ttptlh://mav'en.tat.DIvI’/#/. jIH jab qet [Reposilite](https://hub.docker.com/r/dzikoysk/reposilite) bep vergh, bIp lo’ chel cha’Hu’ choq Qu’.


## chap chen lo’ Rtl'hynq

ghaH puqloD poSmoH Hal ’oH bej puqloD ba’ jIH baS pagh chap bo’DIj ngoD availa'ble [online](https://mirror.clarkson.edu/photonvision). ghoj pagh buS chaH bej [their homepage](https://mirror.clarkson.edu/home).

ngoD DoH bo’DIj Ma'ven jab HotlhwI’ je bel chap chen Hoch baH baS choljaH pong `pho'tonlib-baqk'up` lo’ ghaH tlha’ ra’, jIH exqlu'detlh "bach" cha’Hu’ logh meq:

```
rsync -avzrHy --no-perms --no-group --no-owner --ignore-errors --exclude ".~tmp~" --exclude "snapshots/org/photonvision/photontargeting*" \
--exclude "snapshots/org/photonvision/photonlib*" maven.photonvision.org::reposilite-data \
/path/to/photonlib-backup
```
