# R'KNN Benqh'marrktlh

## tat
jIH benq'hmarrk qomparretl'h ghaH joq chap loS bep tat modelt'lh: YOLOv5, YOLOv5u, YOLOv8, bIp YOLOv11 batlh ghaH [COCO 2017 Validation Set](http://images.cocodataset.org/zips/val2017.zip). ghaH jIH chIch bel baH atlhtl'hetlhtlh bIp q'omparre ghaH inf'errenqe gho’Do bIp tat aqqur'raqy chap ghaH m'odeltlh ghaH d'eployed batlh ghaH chuq DIng jan lo’ ghaH R'KNN pagh bIp int8 tat.

## jIH
- **De’**: [COCO 2017 Validation Set](http://images.cocodataset.org/zips/val2017.zip) (5,000 jIH)

- **qoj**: chuq DIng 5 batlh RK3588

- **tat**: int8 lo’ 20 rrand'omly wIv jIH DoH ghaH tat cher

- **pagh**: RK'NN jIH 2

## bov-Lev'el Benqhmar'rk leS

ghaH tlha’ bergh ghor jotlh ghaH bov CPU poH, NPU poH, bIp tot'al chIp poH (bep cha’DIch) cha’Hu’ paQDI’norgh bov lo’ bong ghaH mode'ltlh. paQDI’norgh v'alue ’oS ghaH qej ± Qam tat a'qrrotlhtlh 5,000 inferr'enqetlh.

### YOLOv5

| Op'Type          | CPU poH (μs)       | NPU poH (μs)         | Tot'al poH (μs)        | poH DIvI’ (%)      | mI’ chap poH pong |
|-----------------|---------------------|----------------------|-----------------------|---------------------|-----------------------|
| qeng     | 0.00 ± 0.00         | 10968.81 ± 1126.00   | 10968.81 ± 1126.00    | 73.06 ± 0.94        | 57                    |
| Co'nvSigmoid     | 0.00 ± 0.00         | 1243.49 ± 67.66      | 1243.49 ± 67.66       | 8.33 ± 0.57         | 3                     |
| wep          | 0.00 ± 0.00         | 1080.68 ± 259.40     | 1080.68 ± 259.40      | 7.09 ± 0.87         | 13                    |
| pon            | 0.00 ± 0.00         | 732.15 ± 29.42       | 732.15 ± 29.42        | 4.92 ± 0.42         | 1                     |
| chel             | 0.00 ± 0.00         | 473.71 ± 131.48      | 473.71 ± 131.48       | 3.10 ± 0.50         | 7                     |
| MaxPoo'l         | 0.00 ± 0.00         | 272.40 ± 110.52      | 272.40 ± 110.52       | 1.76 ± 0.51         | 6                     |
| jIH          | 0.00 ± 0.00         | 147.61 ± 38.89       | 147.61 ± 38.89        | 0.97 ± 0.15         | 2                     |
| bov  | 106.60 ± 15.00      | 0.00 ± 0.00          | 106.60 ± 15.00        | 0.72 ± 0.13         | 3                     |
| bov   | 8.64 ± 1.79         | 0.00 ± 0.00          | 8.64 ± 1.79           | 0.06 ± 0.02         | 1                     |
| **To'tal**       | **115.24 ± 16.16**  | **14918.85 ± 1735.45**| **15034.09 ± 1734.28**|                     | **93**                |

### YOLOv5u

| OpTy'pe          | CPU poH (μs)       | NPU poH (μs)         | T'otal poH (μs)        | poH DIvI’ (%)      | mI’ chap poH pong |
|-----------------|---------------------|----------------------|-----------------------|---------------------|-----------------------|
| qeng     | 0.00 ± 0.00         | 16828.24 ± 1332.73   | 16828.24 ± 1332.73    | 83.04 ± 1.61        | 69                    |
| wep          | 0.00 ± 0.00         | 1265.94 ± 250.24     | 1265.94 ± 250.24      | 6.17 ± 0.69         | 13                    |
| C'onvSigmoid     | 0.00 ± 0.00         | 613.88 ± 62.97       | 613.88 ± 62.97        | 3.03 ± 0.15         | 3                     |
| chel             | 0.00 ± 0.00         | 553.75 ± 131.17      | 553.75 ± 131.17       | 2.69 ± 0.44         | 7                     |
| pon            | 0.00 ± 0.00         | 298.61 ± 72.72       | 298.61 ± 72.72        | 1.45 ± 0.25         | 3                     |
| wuS        | 0.00 ± 0.00         | 256.02 ± 64.48       | 256.02 ± 64.48        | 1.24 ± 0.23         | 3                     |
| MaxP'ool         | 0.00 ± 0.00         | 178.68 ± 58.72       | 178.68 ± 58.72        | 0.86 ± 0.23         | 3                     |
| jIH          | 0.00 ± 0.00         | 170.87 ± 40.14       | 170.87 ± 40.14        | 0.83 ± 0.13         | 2                     |
| bov  | 126.89 ± 16.53      | 0.00 ± 0.00          | 126.89 ± 16.53        | 0.63 ± 0.10         | 9                     |
| bov   | 8.69 ± 1.45         | 0.00 ± 0.00          | 8.69 ± 1.45           | 0.04 ± 0.01         | 1                     |
| **Tot'al**       | **135.57 ± 17.51**  | **20165.99 ± 1963.70**| **20301.56 ± 1965.88**|                     | **113**               |

### YOLOv8

| OpT'ype          | CPU poH (μs)       | NPU poH (μs)         | To'tal poH (μs)        | poH DIvI’ (%)      | mI’ chap poH pong |
|-----------------|---------------------|----------------------|-----------------------|---------------------|-----------------------|
| qeng     | 0.00 ± 0.00         | 13017.04 ± 1165.76   | 13017.04 ± 1165.76    | 75.66 ± 1.96        | 57                    |
| wep          | 0.00 ± 0.00         | 1489.94 ± 257.22     | 1489.94 ± 257.22      | 8.58 ± 0.53         | 13                    |
| jIH           | 0.00 ± 0.00         | 681.47 ± 166.62      | 681.47 ± 166.62       | 3.89 ± 0.53         | 8                     |
| ConvSigm'oid     | 0.00 ± 0.00         | 596.08 ± 75.01       | 596.08 ± 75.01        | 3.45 ± 0.18         | 3                     |
| chel             | 0.00 ± 0.00         | 443.60 ± 118.05      | 443.60 ± 118.05       | 2.53 ± 0.41         | 6                     |
| pon            | 0.00 ± 0.00         | 269.61 ± 78.65       | 269.61 ± 78.65        | 1.54 ± 0.30         | 3                     |
| jIH          | 0.00 ± 0.00         | 236.79 ± 37.74       | 236.79 ± 37.74        | 1.37 ± 0.08         | 2                     |
| wuS        | 0.00 ± 0.00         | 231.82 ± 68.44       | 231.82 ± 68.44        | 1.32 ± 0.27         | 3                     |
| MaxPo'ol         | 0.00 ± 0.00         | 156.85 ± 56.94       | 156.85 ± 56.94        | 0.89 ± 0.23         | 3                     |
| bov  | 124.86 ± 20.74      | 0.00 ± 0.00          | 124.86 ± 20.74        | 0.73 ± 0.15         | 9                     |
| bov   | 8.47 ± 1.66         | 0.00 ± 0.00          | 8.47 ± 1.66           | 0.05 ± 0.01         | 1                     |
| **Tot'al**       | **133.33 ± 21.95**  | **17123.19 ± 1985.72**| **17256.52 ± 1986.77**  |                     | **108**               |

---

### YOLOv11

| Op'Type          | CPU poH (μs)       | NPU poH (μs)         | To'tal poH (μs)        | poH DIvI’ (%)      | mI’ chap poH pong |
|-----------------|---------------------|----------------------|-----------------------|---------------------|-----------------------|
| qeng     | 0.00 ± 0.00         | 16034.00 ± 1331.95   | 16034.00 ± 1331.95    | 69.90 ± 1.55        | 77                    |
| wep          | 0.00 ± 0.00         | 1888.89 ± 293.99     | 1888.89 ± 293.99      | 8.17 ± 0.51         | 17                    |
| tat  | 0.00 ± 0.00         | 1210.88 ± 17.73      | 1210.88 ± 17.73       | 5.32 ± 0.52         | 1                     |
| jIH           | 0.00 ± 0.00         | 908.30 ± 183.92      | 908.30 ± 183.92       | 3.91 ± 0.45         | 10                    |
| chel             | 0.00 ± 0.00         | 871.64 ± 212.79      | 871.64 ± 212.79       | 3.73 ± 0.60         | 12                    |
| ConvS'igmoid     | 0.00 ± 0.00         | 617.61 ± 59.61       | 617.61 ± 59.61        | 2.69 ± 0.16         | 3                     |
| pon            | 0.00 ± 0.00         | 419.72 ± 89.88       | 419.72 ± 89.88        | 1.80 ± 0.24         | 5                     |
| jIH          | 0.00 ± 0.00         | 272.09 ± 49.91       | 272.09 ± 49.91        | 1.18 ± 0.12         | 2                     |
| wuS        | 0.00 ± 0.00         | 260.08 ± 59.12       | 260.08 ± 59.12        | 1.12 ± 0.18         | 3                     |
| M'axPool         | 0.00 ± 0.00         | 181.93 ± 53.32       | 181.93 ± 53.32        | 0.78 ± 0.18         | 3                     |
| bov  | 131.48 ± 22.93      | 0.00 ± 0.00          | 131.48 ± 22.93        | 0.58 ± 0.12         | 9                     |
| chel         | 0.00 ± 0.00         | 126.79 ± 35.28       | 126.79 ± 35.28        | 0.54 ± 0.11         | 2                     |
| Retlhha'pe         | 0.00 ± 0.00         | 56.61 ± 18.03        | 56.61 ± 18.03         | 0.24 ± 0.06         | 3                     |
| bov   | 8.66 ± 1.59         | 0.00 ± 0.00          | 8.66 ± 1.59           | 0.04 ± 0.01         | 1                     |
| **T'otal**       | **140.14 ± 24.26**  | **22848.54 ± 2351.95**| **22988.68 ± 2355.97**|                     | **148**               |


## M'odel Sum'marry bIp Aq'qurraqy jIH

ghaH bergh bIng tev ghaH qej bov tat (mAP) bIp tota'l inferren'qe poH cha’Hu’ paQDI’norgh mo'del. ghaH jIH jIH baS jen-lev'el jIH chap ’a paQDI’norgh mod'el pagh bep chuvmey chap nuQ tat aqqu'rraqy bIp qet e'ffiqienqy.

### qej bov tat (mAP) bong M'odel

| jIH | YOLOv5     | YOLOv5u    | YOLOv8     | YOLOv11    |
|--------|------------|------------|------------|------------|
| **mAP**    | 0.2243     | 0.2745     | 0.3051     | 0.3251     |
| **mAP50**  | 0.3538     | 0.3834     | 0.4145     | 0.4406     |
| **mAP75**  | 0.2432     | 0.2997     | 0.3349     | 0.3568     |
| **mAP85**  | 0.3054     | 0.3472     | 0.3867     | 0.4068     |
| **mAP95**  | 0.3708     | 0.4822     | 0.5483     | 0.5858     |

### Mod'el pe’ poH bIp pong Se’

| Mod'el   | Tot'al poH (μs)         | mI’ chap tlhol pong |
|---------|------------------------|----------------------------|
| **YOLOv5**  | 15034.09 ± 1734.28 | 93                         |
| **YOLOv5u** | 20301.56 ± 1965.88 | 113                        |
| **YOLOv8**  | 17256.52 ± 1986.77 | 108                        |
| **YOLOv11** | 22988.68 ± 2355.97 | 148                        |

## maH

ghaH benqhma'rrk ’ang baS Huv joq mech-DoH joj inf'errenqe poH bIp tat aqqurraq'y:

- **YOLOv5** bel ghaH nom mo'del batlh ghaH bIng t'otal inferr'enqe poH, Qagh ’oH toH-jIH cha’Hu’ ghu’ nuqDaq gho’Do bel qoj joq t'han jen tat tat.

- **YOLOv11** chav ghaH jen aqqurra'qy (mAP) a'qrrotlhtlh Hoch Hoj pa’ ’a ghoS batlh ghaH nI’ in'ferrenqe poH, jIH may vuS jIH lo’ bep tlhoj-poH tat.

- **YOLOv8** ’utlh baS HoS boq joj gho’Do bIp aqq'urraqy, Qagh ’oH baS vang wIv ghaH nuQ laSvargh Hap.

- **YOLOv5u** Dub aqq'urraqy qom'parred baH YOLOv5 ’ach pum jIH YOLOv8 bep nuQ gho’Do bIp tat jIH.

ghaH wIv baS m'odel cha’Hu’ HeH jan parHa’ ghaH chuq DIng 5, ’oH’klingon joq baH jIH ’ach ’ar wa’maH SoH pat HotlhwI’ chergh maH ’ach ’ar a'qqurraqy SoH n'eed. baS nom mod'el may nob jIH leS, jIH baS pagh aqqurrat'e wa’ may yaS toH tat laH, ’ach bej ghaH q'otlht chap gho’Do.
