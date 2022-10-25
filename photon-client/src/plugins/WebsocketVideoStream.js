

export class WebsocketVideoStream{


    constructor(drawDiv, streamPort) {

        this.drawDiv = drawDiv;
        this.image = document.getElementById(this.drawDiv);
        this.streamPort = streamPort;
        this.serverAddr = "ws://" + window.location.host + "/websocket_cameras";
        this.setNoStream();
        this.ws_connect();
        this.imgData = null;
        this.imgDataTime = -1;
        requestAnimationFrame(()=>this.animationLoop());
        this.frameRxCount = 0;
        this.noStream = true;
    }

    animationLoop(){
        var now = window.performance.now();

        if((now - this.imgDataTime) > 2500 && this.imgData != null){
            //Handle websocket send timeouts by restarting?
            this.stopStream();
            this.startStream();
            this.image.src = require("../assets/noStream.jpg");
        } else {
            if(this.streamPort == null || this.noStream){
                this.image.src = require("../assets/noStream.jpg");
            } else if (this.imgData != null) {
                //From https://stackoverflow.com/a/28498608
                var a = new Uint8Array(this.imgData);
                var nb = a.length;

                //Confirm we have enough byes coming in
                if (nb < 4){
                    // Case - not enough bytes recieved
                    this.image.src = require("../assets/noStream.jpg");
                    return;
                }

                //Look up MIME type
                var mime;
                if (a[0] == 0x89 && a[1] == 0x50 && a[2] == 0x4E && a[3] == 0x47) {
                    mime = 'image/png';
                } else if (a[0] == 0xff && a[1] == 0xd8) {
                    mime = 'image/jpeg';
                } else if (a[0] == 0x47 && a[1] == 0x49 && a[2] == 0x46) {
                    mime = 'image/gif';
                } else {
                    // Case - unknown mime type
                    this.image.src = require("../assets/noStream.jpg");
                    return;
                }

                // Convert bytes to base64 representation
                var binary = "";
                for (var i = 0; i < nb; i++)
                    binary += String.fromCharCode(a[i]);
                var base64 = window.btoa(binary);

                //Update the image with the new mimetype and image
                this.image.src = 'data:' + mime + ';base64,' + base64;
               
            } else {
                //Nothing, hold previous image while waiting for next frame
            }
        }


        requestAnimationFrame(()=>this.animationLoop());
    }

    setNoStream() {
        this.noStream = true;
    }

    startStream() {
        if(this.serverConnectionActive == true && this.streamPort > 0){
            this.ws.send(JSON.stringify({"cmd": "subscribe", "port":this.streamPort}));
            this.noStream = false;
        }
    }

    stopStream() {
        if(this.serverConnectionActive == true && this.streamPort > 0){
            this.ws.send(JSON.stringify({"cmd": "unsubscribe"}));
            this.noStream = true;
        }
    }

    setPort(streamPort){
        this.stopStream();
        this.frameRxCount = 0;
        this.streamPort = streamPort;
        this.startStream();
    }

    ws_onOpen() {
        // Set the flag allowing general server communication
        this.serverConnectionActive = true;
        console.log("Connected!");
        this.startStream();
    }

    ws_onClose(e) {
        this.setNoStream();

        //Clear flags to stop server communication
        this.ws = null;
        this.serverConnectionActive = false;

        console.log('Camera Socket is closed. Reconnect will be attempted in 0.5 second.', e.reason);
        setTimeout(this.ws_connect.bind(this), 500);

        if(!e.wasClean){
            console.error('Socket encountered error!');
        }

    }

    ws_onError(e){
        e; //prevent unused failure
        this.ws.close();
    }

    ws_onMessage(e){
        if(typeof e.data === 'string'){
            //string data from host
            //TODO - anything to recieve info here? Maybe "avaialble streams?"
        } else {
            //binary data - a frame
            this.imgData = new Uint8Array(e.data);
        }
        this.imgDataTime = window.performance.now();
        this.frameRxCount++;
    }

    ws_connect() {
        this.ws = new WebSocket(this.serverAddr);
        this.ws.binaryType = "arraybuffer";
        this.ws.onopen = this.ws_onOpen.bind(this);
        this.ws.onmessage = this.ws_onMessage.bind(this);
        this.ws.onclose = this.ws_onClose.bind(this);
        this.ws.onerror = this.ws_onError.bind(this);
        console.log("Connecting to server " + this.serverAddr);
    }

    ws_close(){
        this.ws.close();
    }

}


export default {WebsocketVideoStream}
