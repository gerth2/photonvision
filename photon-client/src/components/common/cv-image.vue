<template>
  <img
    :id="id"
    crossOrigin="anonymous"
    :style="styleObject"
    :src="src"
    alt=""
    @click="e => {this.switchFullscreen(e)}"
  >
</template>

<script>
    export default {
        name: "CvImage",
        // eslint-disable-next-line vue/require-prop-types
        props: {idx:Number, scale:Number, maxHeight:Number, maxHeightMd:Number, maxHeightLg:Number, maxHeightXl:Number, colorPicking:Boolean, id:Number, disconnected:Boolean, isFullscreen: {type: Boolean, default: false}},
        data() {
            return {
                seed: 1.0,
            }
        },
        computed: {
            styleObject: {
                get() {
                    let ret = {
                      "border-radius": (this.isFullscreen ? "0px": "3px"),
                      "position": (this.isFullscreen? "fixed": "auto"),
                      "display": (this.isFullscreen ? "block": "block"),
                      "z-index": (this.isFullscreen ? "99999": "auto"),
                      "object-fit": (this.isFullscreen ? "contain": "contain"),
                      "object-position": (this.isFullscreen ? "50% 50%" : "50% 50%"),
                      "max-width": (this.isFullscreen ? "100vw":"100%"),
                      "width": (this.isFullscreen ? "100vw":"auto"),
                      "margin-left": (this.isFullscreen ? "0": "auto"),
                      "margin-right": (this.isFullscreen ? "0": "auto"),
                      "max-height": (this.isFullscreen ? "100vh": this.maxHeight),
                      height: (this.isFullscreen ? "auto": `${this.scale}%`),
                      cursor: (this.colorPicking ? `url(${require("../../assets/eyedropper.svg")}),` : "") + "default",
                    };

                    if(this.isFullscreen == false){
                      if (this.$vuetify.breakpoint.xl) {
                        ret["max-height"] = this.maxHeightXl;
                      } else if (this.$vuetify.breakpoint.lg) {
                        ret["max-height"] = this.maxHeightLg;
                      } else if (this.$vuetify.breakpoint.md) {
                        ret["max-height"] = this.maxHeightMd;
                      }
                    }

                    return ret;
                }
            },
            port: {
              get() {
                if(this.idx == 0){
                  return this.$store.state.cameraSettings[this.$store.state.currentCameraIndex].inputStreamPort;
                } else {
                  return this.$store.state.cameraSettings[this.$store.state.currentCameraIndex].outputStreamPort;
                }
              }
            }
        },
        watch : {
          port(newPort, oldPort){
            newPort;
            oldPort;
            this.reload();
          },
          disconnected(newVal, oldVal){
            oldVal;
            if(newVal){
              this.wsStream.stopStream();
            } else {
              this.wsStream.startStream();
            }
          }
        },
        mounted() {
          var wsvs = require('../../plugins/WebsocketVideoStream');
          this.wsStream = new wsvs.WebsocketVideoStream(this.id, this.port);
        },
        unmounted() {
          this.wsStream.stopStream();
          this.wsStream.ws_close();
        },
        methods: {
            reload() {
              console.log("Reloading " + this.id + " with port " + String(this.port));
              this.wsStream.setPort(this.port);
            },
            switchFullscreen(e) {
              e;
              this.isFullscreen = !this.isFullscreen;
              console.log(this.isFullscreen);
            }
        },
    }
</script>
