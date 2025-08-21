# bIQtIq bobcho’ bIp tlhegh jIH/wa’maH

cha’leS {lulIgh}`Sop baS bov <Qel/pr'rogrramming/photo'nlib/Suq-DoS-da'ta:ghojmoH baS bov>`, wa’ HotlhwI’ to'ggle bIQtIq bobcho’ bIp choH ghaH tlhegh jIH chap ghaH jIH ghun DoH qoq ngoq.

## T'oggle bIQtIq bobcho’

SoH HotlhwI’ lo’ ghaH `bIQtIq()`/`bIQtIq()` (J'ava bIp baH++ vuv) baH tog'gle bIQtIq bobcho’ DoH SoH qoq ghun. bIQtIq bobcho’ bel beq Doq / pagh jIH chap ghaH bov baH bel lo’ jIH jIH ghaH qoq.

```{eval-rst}
.. tab-set-code::

    .. code-block:: Java

        // Set driver mode to on.
        camera.setDriverMode(true);

    .. code-block:: C++

        // Set driver mode to on.
        camera.SetDriverMode(true);

    .. code-block:: Python

        # Coming Soon!
```

## cher ghaH tlhegh jIH

SoH HotlhwI’ lo’ ghaH `tlhegh()`/`tlhegh()` (J'ava bIp baH++ vuv) baH Hoch choH ghaH jIH tlhegh DoH SoH qoq ghun.

```{eval-rst}
.. tab-set-code::

    .. code-block:: Java

        // Change pipeline to 2
        camera.setPipelineIndex(2);

    .. code-block:: C++

        // Change pipeline to 2
        camera.SetPipelineIndex(2);

    .. code-block:: Python

        # Coming Soon!
```

## Suq ghaH tlhegh wa’maH

SoH HotlhwI’ je Suq ghaH tlhegh wa’maH DoH baS tlhegh leS lo’ ghaH `rop()`/`Suq()` (J'ava bIp baH++ vuv) jIH batlh baS `tlhegh`.

```{eval-rst}
.. tab-set-code::
   .. code-block:: Java

      // Get the pipeline latency.
      double latencySeconds = result.getLatencyMillis() / 1000.0;

   .. code-block:: C++

      // Get the pipeline latency.
      units::second_t latency = result.GetLatency();

   .. code-block:: Python

        # Coming Soon!
```

:::{Qo’}
ghaH baH++ jIH chap Pho'tonLib chegh ghaH wa’maH bep baS jIH togh. cha’Hu’ pagh De’ batlh ghaH jIH jIH, legh [here](https://docs.wpilib.org/en/stable/docs/software/basic-programming/cpp-units.html).
:::
