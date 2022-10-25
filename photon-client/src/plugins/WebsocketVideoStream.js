

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
            this.image.setAttribute('src', require("../assets/noStream.jpg"));
        } else {
            if(this.streamPort == null || this.noStream){
                this.image.setAttribute('src', require("../assets/noStream.jpg"));
            } else if (this.imgData != null) {
                this.image.setAttribute(
                    'src', `data:image/jpeg;base64,${this.imgData}`
                );
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
        const msg = JSON.parse(e.data);
        this.imgData = msg['data'];
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
