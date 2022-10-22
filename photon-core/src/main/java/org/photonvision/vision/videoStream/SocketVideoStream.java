package org.photonvision.vision.videoStream;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.photonvision.vision.frame.Frame;

import io.javalin.websocket.WsContext;

public class SocketVideoStream implements Consumer<Frame> {

    int portID = 0; // Align with cscore's port for unique identification of stream
    MatOfByte jpegBytes = null;

    // Gets set to true when another class reads out valid jpeg bytes at least once
    // Set back to false when another frame is freshly converted
    // Should eliminate synchronization issues of differeing rates of putting frames in
    // and taking them back out
    boolean frameWasConsumed = false;

    //Synclock around manipulating the jpeg bytes from multiple threads
    Lock jpegBytesLock = new ReentrantLock();

    Set<WsContext> subscribedUsers = new HashSet<WsContext>();

    public SocketVideoStream(int portID){
        this.portID = portID;
    }

    @Override
    public void accept(Frame frame) {
        if (subscribedUsers.size() > 0){
            if(jpegBytesLock.tryLock()){ //we assume frames are coming in frequently. Just skip this frame if we're locked doing something else.
                try{
                    //Does a single-shot frame recieve and convert to JPEG for efficency
                    // Will not capture/convert again until convertNextFrame() is called
                    if(frame != null && !frame.image.getMat().empty() && jpegBytes == null) {
                        frameWasConsumed = false;
                        jpegBytes = new MatOfByte();
                        Imgcodecs.imencode(".jpg", frame.image.getMat(), jpegBytes);
                    } 
                } finally {
                    jpegBytesLock.unlock();
                }
            }
        } 
    }

    public String getJPEGBase64EncodedStr(){
        String sendStr = null;
        jpegBytesLock.lock();
        if(jpegBytes != null){
            sendStr = Base64.getEncoder().encodeToString(jpegBytes.toArray());
        }
        jpegBytesLock.unlock();
        return sendStr;
    }

    public void convertNextFrame(){
        jpegBytesLock.lock();
        if(jpegBytes != null){
            jpegBytes.release();
            jpegBytes = null;
        }
        jpegBytesLock.unlock();
    }

    public void subscribeUser(WsContext user){
        subscribedUsers.add(user);
    }

    public void unsubscribeUser(WsContext user){
        subscribedUsers.remove(user);
    }

    public boolean userIsSubscribed(WsContext user){
        return subscribedUsers.contains(user);
    }

}
