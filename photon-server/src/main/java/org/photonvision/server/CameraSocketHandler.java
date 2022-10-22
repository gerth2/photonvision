/*
 * Copyright (C) Photon Vision.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.photonvision.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.websocket.WsBinaryMessageContext;
import io.javalin.websocket.WsCloseContext;
import io.javalin.websocket.WsConnectContext;
import io.javalin.websocket.WsContext;
import io.javalin.websocket.WsMessageContext;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.photonvision.common.logging.LogGroup;
import org.photonvision.common.logging.Logger;
import org.photonvision.vision.videoStream.SocketVideoStreamManager;

public class CameraSocketHandler {
    private final Logger logger = new Logger(CameraSocketHandler.class, LogGroup.WebServer);
    private final List<WsContext> users = new CopyOnWriteArrayList<>();
    private final SocketVideoStreamManager svsManager = SocketVideoStreamManager.getInstance();

    private Thread cameraBroadcastThread;


    public static class UIMap extends HashMap<String, Object> {}

    private static class ThreadSafeSingleton {
        private static final CameraSocketHandler INSTANCE = new CameraSocketHandler();
    }

    public static CameraSocketHandler getInstance() {
        return CameraSocketHandler.ThreadSafeSingleton.INSTANCE;
    }

    private CameraSocketHandler() {
        cameraBroadcastThread = new Thread(this::broadcastFramesTask);
        cameraBroadcastThread.start();
    }

    public void onConnect(WsConnectContext context) {
        context.session.setIdleTimeout(Long.MAX_VALUE); // TODO: determine better value
        var insa = context.session.getRemote().getInetSocketAddress();
        var host = insa.getAddress().toString() + ":" + insa.getPort();
        logger.info("New camera websocket connection from " + host);
        users.add(context);
    }

    protected void onClose(WsCloseContext context) {
        var insa = context.session.getRemote().getInetSocketAddress();
        var host = insa.getAddress().toString() + ":" + insa.getPort();
        var reason = context.reason() != null ? context.reason() : "Connection closed by client";
        logger.info("Closing camera websocket connection from " + host + " for reason: " + reason);
        svsManager.removeAllSubscriptions(context);
        users.remove(context);
    }
    
    @SuppressWarnings({"unchecked"})
    public void onMessage(WsMessageContext context) {
        var messageStr = context.message();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode actualObj = mapper.readTree(messageStr);

            for (var entry : actualObj) {
                try {
                    var entryKey = entry.textValue();
                    var entryValue = entry.elements();
                    var socketMessageType = CameraSocketMessageType.fromEntryKey(entryKey);

                    logger.trace(
                            () ->
                                    "Got Camera WS message: ["
                                            + socketMessageType
                                            + "] ==> ["
                                            + entryKey
                                            + "], ["
                                            + entryValue
                                            + "]");

                    if (socketMessageType == null) {
                        logger.warn("Got unknown socket message type: " + entryKey);
                        continue;
                    }

                    switch (socketMessageType) {
                        case CSMT_SUBSCRIBE:
                            {
                                while(entryValue.hasNext()){
                                    var portSpec = entryValue.next();
                                    int portId = portSpec.get("port").asInt();
                                    svsManager.addSubscription(context, portId);
                                }
                                break;
                            }
                        case CSMT_UNSUBSCRIBE:
                            {
                                while(entryValue.hasNext()){
                                    var portSpec = entryValue.next();
                                    int portId = portSpec.get("port").asInt();
                                    svsManager.removeSubscription(context, portId);
                                }
                                break;
                            }
                    }
                } catch (Exception e) {
                    logger.error("Failed to parse message!", e);
                }
            }
        } catch (JsonProcessingException e) {
            logger.warn("Could not parse message \"" + messageStr + "\"");
            e.printStackTrace();
            return;
        }
    
    }


    @SuppressWarnings({"unchecked"})
    public void onBinaryMessage(WsBinaryMessageContext context) {
        return; // ignoring binary messages for now
    }

    private void broadcastFramesTask() {
        // Background camera image broadcasting thread
        while (!Thread.currentThread().isInterrupted()) {
            
            for(var user : users){
                var frames = svsManager.getSendFrames(user);
            }

            svsManager.allStreamConvertNextFrame();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                logger.error("Exception waiting for camera stream broadcast semaphor", e);
            }
        }
    }
}
