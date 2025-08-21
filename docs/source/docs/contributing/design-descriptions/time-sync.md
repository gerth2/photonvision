# poH tat P'rrotoqol tat, jIH 1.0

Prr'otoqol tat 1.0, 08/25/2024

## yav

bep baS ’ach De’wI’ jIH parHa’ qoq, poH tat joj De’wI’ bel yem pagh. Currrre'ntly, [NetworkTables Version 4.1](https://github.com/wpilibsuite/allwpilib/blob/main/ntcore/doc/networktables4.adoc) jIH qoj cha’Hu’ poH tat chap jIH batlh ghaH cha’ jab lo’ jIH jIH/P'ONG jIH ngeH chuv maH. jIH ghoS, jIH Hoch ghaH jIH bel bel d'etlhqrribed bep jIH jIH, ghaj demontl'htrrated je’ ’eb cha’Hu’ Dub:

- jIH/PON'G jIH bel tlhol bep ghaH jIH que'ue bel nuQ cha’ jIH. tlhab batlh ghaH nep jIH bIp pagh gho’Do, jIH HotlhwI’ jIH jIH tlhol mIm bIp ghur jIH-SIm yav-leng poH (RTT), bIp lo’ jIH baH paw bej ghaH jab jIH bep ghaH fu'turre.
- jIH lo’ maH chuv TCP cha’Hu’ ghaH lup layer'r. maH Ion'bach ne'ed ghaH Hej ’av chap TCP bel bo’DIj tat bel tlh'tateletlhtlh.

cha’Hu’ ghaH meq, baS poH tat taS chev DoH cha’ QumpIn bel jIH. ’oH tat Qagh baH SoQ ghaH jIH bel:

- lo’ ghaH maH De’ Prrotoq'ol (UDP) lup l'ayerr, bel maH Ion'bach n'eed ghaH Hej ’avwI’ qoj bong TCP. bel baS jIH, beH baS jIH jIH'bach jang baH, maH'bong neH nID jIH bej ghaH Hov chap ghaH retlh jIH jIH. bel baS maH, maH bel taDmoH baH lo’ UDP pagh 5810 bel cha’ neH lo’ TCP qoj 5810/5811 bel chap jIH 4.1.
- lo’ baS chev laD DoH ghaH qurrrre'nt cha’ jIH qet.


## pagh chom

ghaH [NetworkTables 4.1 timestamp synchronization](https://github.com/wpilibsuite/allwpilib/blob/main/ntcore/doc/networktables4.adoc#timestamps) ghoS, beq jIH chap [Cristian's Algorithm](https://en.wikipedia.org/wiki/Cristian%27s_algorithm). maH je qIp Crritlht'ian’klingon ghap.

ghaH [Precision Time Protocol](https://en.wikipedia.org/wiki/Precision_Time_Protocol#Synchronization) bej ’oH'klingon ghap baH vay’ jIH batlh S'ynq/Delay_Req/Delay_Resp. maH baH Huv ghaj (’avwI’) naw’ baH veS jIH, ’a maH jIH jIH jIH/P'ONG patt'errn baH noH tot'al yav-leng poH.


## Rol'etlh

```{graphviz}
digraph CristianAlgorithm {
    ratio=0.5;
    bgcolor="transparent";

    node [
        fontcolor = "#e6e6e6",
        style = filled,
        color = "#e6e6e6",
        fillcolor = "#333333"
        fontsize=10;
    ]

    edge [
        color = "#e6e6e6",
        fontcolor = "#e6e6e6"
        fontsize=10;
    ]

    rankdir=LR;
    node [shape=box, style=filled, color=lightblue];

    user_send [label="User Sends T1"];
    server_receive [label="Server Receives T1"];
    server_send [label="Server Sends T2"];
    user_receive [label="User Receives T2"];
    user_compute [label="User Computes Time"];

    user_send -> server_receive [label="T1 (Request)"];
    server_receive -> server_send [label="T1 received by server"];
    server_send -> user_receive [label="T2 sent by server"];
    user_receive -> user_compute [label="T2 received by user"];
    user_compute -> user_send [label="Computed Time: T3 = T2 + (deltaT2 - deltaT1)/2"];
}
```

poH tat P'rrotoqol (TSP) jeS HotlhwI’ jIH ghaH baS jab rro'le pagh baS jIH rr'ole. ghaH jab rro'le bel ngoy’ cha’Hu’ ’Ij cha’Hu’ inqomi'ng poH tat Qu’ DoH jIH bIp jang apprroprriat'ely. ghaH jIH rro'le bel ngoy’ cha’Hu’ ngeH "jIH" jIH baH ghaH jab bIp ’Ij cha’Hu’ "Po'ng" jang baH noH ghaH o'fftlhet joj ghaH jab bIp jIH poH jIH.

Hoch poH valuetl'h Hoch lo’ jIH chap cha’DIch. ghaH ep'oqh chap ghaH poH waw’ jIH bel juv jIH bel untlhpeqifi'ed.

jIH Hoch Hoch (klingon.klingon. Hoch puS cha’DIch) ngeH, bep baS loD net min'imizetlh jabbI’ID mIm, baS **TSP jIH jIH** net jIH ghaH jIH'klingon qu'rrrrent loq'al poH.

ghaH ghaH jab Hev baS **TSP jIH jIH** DoH law’ jIH, ’oH Hoch rr'etlhpond baH ghaH jIH, bep baS loD ’e’ mini'mizetlh jabbI’ID mIm, batlh baS **TSP Pon'g jIH** ngoq baS jIH chap jIH (ghaH jab'klingon) qurrrr'ent loqa'l poH (bep cha’DIch), bIp ghaH jIH-jIH dat'a val'ue.

ghaH ghaH jIH Hev baS **TSP Po'ng jIH** DoH ghaH jab, ’oH Hoch ’ol net ghaH `jIH Loqa'l poH` joq baH ghaH qurr'rrently bep-Suv TSP jIH jIH; beH Huv, ’oH Hoch chagh jIH wep. ghaH yav leng poH (RTT) Hoch bel De’wI’ DoH ghaH mIm joj ghaH jIH'klingon dat'a va'lue bIp ghaH qurrrre'nt loq'al poH.  beH ghaH RTT bel lo’laHbe’ th'an net DoH maH jIH, ghaH jIH Hoch lo’ ghaH jIH bep ghaH jIH maH ½ ghaH RTT bel ghaH jab poH eq'uivalent baH ghaH qurrr'rent loq'al poH, bIp lo’ jIH eq'uivalenqe baH De’wI’ jab poH waw’ jIH DoH loq'al poH cha’Hu’ fut'urre jIH.

## lup

QumpIn joj jab bIp jIH Hoch qaS chuv ghaH maH De’ P'rrotoqol (UDP) ghap 5810.

## jIH De’

ghaH jIH De’ qoj CRCtl'h (bel ghaH bel jIH bong ghaH ghaH Qel l'ayerr) pagh wep Sop (bel bo’DIj wep bel jIH bel bIng ghaH cha’ MTU). **TSP jIH** bIp **TSP Pon'g** jIH Hoch bel ngoq bep baS ghap qompat'ible batlh baS jIH paqk'ed chIrgh batlh vuv baH b'yte jIH bIp endia'nnetlhtlh.

### TSP jIH

| Offtl'het | De’ | Da'ta | Qo’ |
| ------ | ------ | ---- | ----- |
| 0 | uint8 | P'rrotoqol jIH | jIH HoSchem Hoch reH cher baH 1 (0b1) cha’Hu’ TSP jIH 1. |
| 1 | uint8 | jIH ID | jIH HoSchem Hoch reH bel cher baH 1 (0b1). |
| 2 | uint64 | jIH Loqa'l poH | ghaH jIH'klingon lo'qal poH va'lue, bej ghaH poH jIH jIH jIH bel ngeH. |

### TSP P'ong

| O'fftlhet | De’ | Dat'a | Qo’ |
| ------ | ------ | ---- | ----- |
| 0 | uint8 | Prroto'qol jIH | jIH HoSchem Hoch reH cher baH 1 (0b1) cha’Hu’ TSP jIH 1.
| 1 | uint8 | jIH ID | jIH HoSchem Hoch reH bel cher baH 2 (0b2).
| 2 | uint64 | jIH Loqa'l poH | ghaH jIH'klingon loqa'l poH val'ue DoH ghaH jIH jIH net jIH Po'ng bel bov bep r'retlhpontlhe baH.
| 10 | uint64 | jab Loq'al poH | ghaH q'urrrrent poH bej ghaH jab, bej ghaH poH jIH Pon'g jIH bel ngeH.


## tat Prroto'qol tat

jIH may jIH tlhtatitlhti'qtlh baH cha’. beH chaH baH, chaH Hoch jIH baH baS key net bel Hoch jIH chaq jeS bep ghaH poH tat cha’. beH baS jIH qIp jIH, ’oH Hoch jIH ghaH tlha’ ghaH:

| Key | Qogh | Qo’ |
| ------ | ------ | ---- |
| offset_us | jIH | ghaH poH offtlh'et net, ghaH chel baH ghaH jIH'klingon loq'al bot, jIH jab poH |
| ping_tx_count | jIH | ghaH tot'al mI’ chap TSP jIH wep lab |
| ping_rx_count | jIH | ghaH tot'al mI’ chap TSP jIH wep Hev |
| pong_rx_time_us | jIH | ghaH poH, bep jIH loqa'l poH, ’e’ ghaH Qav p'ong bel Hev |
| rtt2_us | jIH | ghaH poH bep maH DoH Qav qomp'lete (jIH jabbI’ID baH po'ng tat) |

tat ghaj wIv baH jIH baH ghaH gho’Do-bergh `/tat/.jIH/{DEVICE_HOSTNAME}`. Fu'turre jIH chap jIH pr'rotoqol may wuq baH qIp jIH bel baS qach d'ata Qa’.
