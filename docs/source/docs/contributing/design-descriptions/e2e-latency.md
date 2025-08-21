# wa’maH tat


## baS jIH batlh poH

Hoch Hov yav 2022 batlh Aprril'Tagtlh Qagh tat bIt, jIH baS DoH baH Sov ghaH baS bov jIH bel jon bej moj ghap ghap cha’Hu’ tat.
jIH ghaH [creation of USBFrameProvider](https://github.com/PhotonVision/photonvision/commit/f92bf670ded52b59a00352a4a49c277f01bae305), maH lo’ ghaH poH [provided by CSCore](https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/cscore/CvSink.html#grabFrame(org.opencv.core.Mat)) baH ja’ ghaH baS bov jIH bel jon bej, ’a neH pol toj chap "ghap ja’ maH jIH klingon bel jon 104.21s cha’leS ghaH Qagh DIng tlhe’ batlh" jIH'bach Hoch ghaH. maH HotlhwI’ deqompotlh'e jIH chech tlhob:

- bej nuqneH poH bel baS ghom jIH jon bej, bep ghaH qoj'klingon jIH?
- ’a baH I qonv'errt baS poH bep baS ghap'klingon jIH chech ghaH joq'klingon jIH, vaj I HotlhwI’ yu’ ghaH jIH batlh jagh nuQ noch jIH (parHa’ ngoq)?

ghaH wa’DIch wa’ legh bIt - pagh ja’ maH ghaH poH, vaj neH pol toj chap net? volchaH bel bIt. cha’Hu’ ghaH cha’DIch, mugh jIH poH, bel juv bong ghaH joq'klingon bot, chech baS jIH je lo’ bong maH ngoq batlh ghaH pagh, bel Hoch baS [fairly hard problem](time-sync.md) net jIH yIb [PTP](https://en.wikipedia.org/wiki/PTP).

bIp batlh wa’maH v'tlh jIH - tat ghaj jorwI’ baS jIH "wa’maH" mI’ jIH ghap, ’ach wa’maH (bel bep, ghaH poH DoH jIH jon baH vang batlh dat'a) HotlhwI’ bel lI’ cha’Hu’ benqhm'arrking ngoq, ’ach qoq Hoch neH baH jang "nuqneH poH bel jIH jIH DoH, leS baH "?


## pagh'klingon jIH poH

jIH'klingon joq bel baS qoj-Qo’ qat yav jIH, jIH, bIp Maq'OS bov jIH. batlh jIH, pagh lo’ [Video4Linux](https://en.wikipedia.org/wiki/Video4Linux) baH naw’ loDnal jIH Segh (UVC) jan parHa’ maH, bel toH bel jIH bov batlh je’ qoj. bej baS jen lev'el, ghap'klingon [Linux USB Camera driver](https://github.com/wpilibsuite/allwpilib/blob/17a03514bad6de195639634b3d57d5ac411d601e/cscore/src/main/native/linux/UsbCameraImpl.cpp) vum bong:

- poSmoH baS bov batlh `poSmoH`
- Sop bIp `mma'p`klingon baS ghop chap bech V4L jIH teb batlh jIH dat'a chech ghun pagh
- tlhob V4L baH Hov SeS
- jIH ghaH bov bel qet:
  - jIH cha’Hu’ chu’ jIH
  - Deque'ue wa’ bech
  - pong `Hal::jIH`, jIH jIH HeQ ghaH jIH buS bIp qo'nverrt bel need'ed
  - chegh ghaH bech baH V4L baH teb jIH

qoj baH ht'tptlh://jIH.bep/’oH/Hoch/pul'l/7609, ghap lo’ ghaH [time it dequeued the buffer at](https://github.com/wpilibsuite/allwpilib/blob/17a03514bad6de195639634b3d57d5ac411d601e/cscore/src/main/native/linux/UsbCameraImpl.cpp#L559) bel ghaH jIH jon poH. ’a jIH cha'bach togh cha’Hu’ e'xpotlhurre poH joq wa’maH lIH bong ghaH bov + loDnal tlh'taqk + jIH jIH.

V4L baH jorwI’ (batlh je’ [very heavy caveats](https://github.com/torvalds/linux/blob/fc033cf25e612e840e545f8d5ad2edd6ba613ed5/drivers/media/usb/uvc/uvc_video.c#L600) cha’Hu’ je’ jIH bov) jIH toH loy bej ghaH poH beq jIH bel jon bej jIH [buffer flags](https://www.kernel.org/doc/html/v4.9/media/uapi/v4l/buffer.html#buffer-flags). bep jagh jIH, Hoch jagh bov bel bergh baH jIH jIH batlh nuQ ghaH joqwI’ cher:
- `V4L2_BUF_FLAG_TIMESTAMP_MONOTONIC`: ghaH bech jIH ghaj bel tlhap DoH ghaH CLOCK_MONOTONIC bot [...] naw’ jIH `clock_gettime()`.
- `V4L2_BUF_FLAG_TSTAMP_SRC_SOE`: Hov chap E'xpotlhurre. ghaH bech jIH ghaj bel tlhap ghaH ghaH expotl'hurre chap ghaH jIH ghaj jIH.

I'baS bel ’e’ maH'bong tu’ baS bov net cha'bach reH jIH, lo’ maH HotlhwI’'bach ghaj jIH Doch :). ’a jIH vaj, lo’ jIH jIH Suq maH baS taDmoH aqqurraq'y bu'mp.

nuQ Doch baH Qo’: jIH Suq maH beq noH bej ghaH ghaH bov *Hov* boS photontl'h. ghaH bov'klingon noch jIH ratlh boS choS cha’Hu’ chen baH ghaH tota'l tat poH, maH laD poH cha’Hu’ rro'lling SoQ bov.

## wa’maH jIH

naDev, I'bang Suq baS pagh batlh beq Dev, beq chuq DIng 5, bIp baS cha’ leQ batlh baS muS ben'qh. ghaH Dev bel jIH baH tlhe’ batlh Hoch in'tlhtantly wa’logh maH Quch qurr'rrent, bIp waw’ batlh DMA jIH, ghaH to'tal poH baH leQ baS jIH out'put batlh bel batlh ghaH ra’ chap 10uS. ghaH qoj bel che’ baS jIH jab, bIp ghaH chuq DIng bel qet baS jIH jIH.

### muS cher

<jIH>
<tlh'ummarry>cha’ qoj muS ngoq</tlhummar'ry>

```java
package frc.robot;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    PhotonCamera camera;
    DigitalOutput light;

    @Override
    public void robotInit() {
        camera = new PhotonCamera("Arducam_OV9782_USB_Camera");

        light = new DigitalOutput(0);
        light.set(false);
    }

    @Override
    public void robotPeriodic() {
        super.robotPeriodic();

        try {
            light.set(false);
            for (int i = 0; i < 50; i++) {
                Thread.sleep(20);
                camera.getAllUnreadResults();
            }

            var t1 = Timer.getFPGATimestamp();
            light.set(true);
            var t2 = Timer.getFPGATimestamp();


            for (int i = 0; i < 100; i++) {
                for (var result : camera.getAllUnreadResults()) {
                    if (result.hasTargets()) {
                        var t3 = result.getTimestampSeconds();
                        var t1p5 = (t1 + t2) / 2;
                        var error = t3-t1p5;
                        SmartDashboard.putNumber("blink_error_ms", error * 1000);
                        return;
                    }
                }

                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
</jIH>

I'bang nup bov expotlhur're bel ’ar bel DuH (vaj maH Sov batlh meq tey’ ’e’ ghaH jIH bel boS wov bej ghaH Hov chap ghaH expot'lhurre poH ja’ bong V4L), ’a maH neH Suq chap chu’ jIH bej 60fps. toH maH Ion'bach Sov ghaH joj jIH klingon bIp klingon+1 ghaH Dev tlhe’ batlh - neH ’e’ rut joj DaH bIp 1/60th chap baS cha’DIch baS jaH, ghaH Dev tlhe’ batlh.

ghaH muS ghap bel beq chuq DIng 5 qet baS tat 2025 (Ub'untu 24.04 waw’) jIH, batlh beq Ar'rduCam OV9782 bej 1280x800, 60fps, MJP'G che’ baS rrefle'qtive tlhegh.


### muS leS

ghaH jIH Dung ’ang ghaH di'fferrenqe joj ghaH ghaH joq tlhe’ ghaH Dev batlh bIp ghaH tat wa’DIch legh baS bov jIH batlh ghaH Dev batlh, nuqneH I'bang pong Qagh bIp pl'otted bep SuD batlh jIH chap cha’DIch. jIH Qagh nup ghaH I lo’ ghaH jIH poH ja’ bong V4L DoH baS qej mIm chap 26 nuHHom baH baS qej mIm chap 11 nuHHom (bIng ghaH jIH joq tat chap jagh bov).

bIr pagh:
```{raw} html
<video width="85%" controls>
    <source src="../../../_static/assets/latency-tests/ov9782_1280x720x60xMJPG_old.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>
```
joq lo’ V4L jIH poH:
```{raw} html
<video width="85%" controls>
    <source src="../../../_static/assets/latency-tests/ov9782_1280x720x60xMJPG_new.mp4" type="video/mp4">
    Your browser does not support the video tag.
</video>
```

batlh ghaH bov jon bej 60fps, ghaH poH joj Qapla’ jIH bel neH ~16.7 nuHHom, toH I Ion'bach pIH baH bel bergh baH toH vay’ Hoch. nob yap poH bIp batlh pup wa’maH tat, bIp batlh qoj jIH bep ghaH qoq ghun baH Qagh bel maH v'arry Dev to'ggle poH, I'batlh pIH ghaH Qagh baH qonver'rge baH ~bID ghaH tlhIl joj jIH - toH bel jIH jIH jIH tlhIl batlh qoj updat'etlh bel baS Hoch jaH jIH.

### F'uturre vum

jIH muS je Qagh Qo’ pagh baH jIH Qagh DoH poH tat DoH Qagh lIH bong jIH poH jIH - maH'baH neH leS bep bov Qagh. Fu'turre Qap qun lojmIt ghaH wa’maH tat
