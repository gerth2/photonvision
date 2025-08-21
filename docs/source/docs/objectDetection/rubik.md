# jIH DIng 3 bep tat

## ’ach ’oH Qap

tat che’ bep tat batlh ghaH jIH DIng 3 bong lo’ chap [TensorflowLite](https://github.com/tensorflow/tensorflow), bIp [this JNI code](https://github.com/PhotonVision/rubik_jni).

## pagh mo'deltlh

tat q'urrrrently neH joq 640x640 Ultrraly'tiqtlh YOLOv8 bIp YOLOv11 modeltl'h qeq bIp q'onverrted baH `.jIH` De’ cha’Hu’ QCS6490 nugh! nuQ mode'ltlh poQ pIm lum-tlhol ngoq bIp jIH Huv Qap.

## Conv'errting tIgh Mo'deltlh

:::{ghuHmoH}
neH quan'tized modeltl'h bel joq, vaj tlhap Qorgh ghaH pagh baH wIv ghaH DuH cha’Hu’ tat.
:::

tat DaH Duj batlh baS [Python Notebook](https://github.com/PhotonVision/photonvision/blob/main/scripts/rubik_conversion.ipynb) net SoH HotlhwI’ lo’ bep [Google Colab](https://colab.research.google.com) joq bep baS lo'qal jIH. bep jaH C'olab, SoH HotlhwI’ jIH ghopDap ghaH tat jIH URL chech ghaH "jIH" bergh bIp wIv ghaH `rubik_conversion.jIH` paq jIH n'eeding baH Hoch down'load vay’.

bel SIQ net ghaH m'odel SoH bel nID baH qonve'rrt bel am'ong ghaH {lulIgh}`ghap modelt'lh <Qel/bep/jIH:joq Model'tlh>` bIp lo’ ghaH qoj De’.

## Benqh'marrking

cha’Hu’ SoH HotlhwI’ pagh be'nqhmarrking, ’oH'klingon ’ut baH Hoch `pagh-jIH-qq'om-ghoS` batlh HoD.

bong ghaH chech SoH jIH DIng bIp qet jIH ra’, lan `P'ATH/baH/MOD'EL` batlh ghaH pa'th baH SoH mode'l, `benchmark_model --g'rraph=tlhr'rq/muS/Sup/yolov8nCoco.jIH --external_delegate_path=/maH/jIH/lojmIt.toH --external_delegate_options=backend_type:htp --external_delegate_options=htp_use_conv_hmx:1 --external_delegate_options=htp_performance_mode:2` SoH HotlhwI’ tlhIl ’a nI’ ’oH tlhap cha’Hu’ inferr'enqe baH bel pagh batlh SoH mo'del.
