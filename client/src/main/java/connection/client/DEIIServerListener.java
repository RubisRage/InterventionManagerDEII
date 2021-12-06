package connection.client;

import client.control.ClientNotificationHandler;
import connection.notification.Notification;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.SocketTimeoutException;

public class DEIIServerListener extends Thread implements ServerListener{

    private ObjectInputStream objectIn;
    private Boolean running;

    public DEIIServerListener(InputStream inputStream){
        try {
            objectIn = new ObjectInputStream(inputStream);
            running = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized Boolean isRunning(){
        return running;
    }

    @Override
    public void run() {

        while(isRunning()){
            try {
                Notification n = (Notification) objectIn.readObject();
                n.accept(new ClientNotificationHandler());
            } catch (SocketTimeoutException ignored) {

            } catch(ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }

        try {
            objectIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void disconnect() {
        running = false;
    }
}
