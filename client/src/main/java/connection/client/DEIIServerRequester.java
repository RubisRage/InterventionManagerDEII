package connection.client;

import connection.request.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DEIIServerRequester extends Thread implements ServerRequester {
    public static final Long QUERY_TIMEOUT = 100L;

    private Boolean running;
    private final BlockingQueue<Request> queue;
    private ObjectOutputStream objOut;

    public DEIIServerRequester(OutputStream outputStream){
        running = true;
        queue = new LinkedBlockingQueue<>();
        objOut = null;

        try {
            objOut = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendRequest(Request r) {
        queue.add(r);
    }

    private Request getRequest(long millis) throws InterruptedException {
        return queue.poll(millis, TimeUnit.MILLISECONDS);
    }

    private synchronized Boolean isRunning(){
        return running;
    }

    @Override
    public synchronized void disconnect() {
        running = false;
    }

    @Override
    public void run(){
        while(isRunning()){
            try {

                Request r = getRequest(QUERY_TIMEOUT);
                if(r != null)
                    objOut.writeObject(r);

            } catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }

        try {
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
