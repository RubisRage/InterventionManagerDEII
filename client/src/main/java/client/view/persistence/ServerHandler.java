package client.view.persistence;

import model.Delegate;
import model.Intervention;
import model.Meeting;
import model.client.MeetingNotifier;
import model.client.Requester;

import java.io.IOException;
import java.net.Socket;

public class ServerHandler implements Requester, MeetingNotifier {

    private static ServerHandler instance;
    private static String url;
    private static Integer port;

    private Socket socket;

    private ServerHandler(String url, Integer port){
        try {
            socket = new Socket(url, port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void setServer(String url, Integer port){
        if(ServerHandler.url == null && ServerHandler.port == null) {
            ServerHandler.url = url;
            ServerHandler.port = port;
        }
    }

    public static ServerHandler getInstance(){
        if(instance == null){
            instance = new ServerHandler(ServerHandler.url, ServerHandler.port);
        }

        return instance;
    }

    @Override
    public void notifyPassIntervention() {

    }

    @Override
    public void notifyPassMeetingPoint() {

    }

    @Override
    public void notifyCreateIntervention(Intervention intervention) {

    }

    @Override
    public void notifyCancelIntervention(Intervention intervention) {

    }

    @Override
    public Delegate authenticate(String username, String password) {
        return null;
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return null;
    }

    @Override
    public Meeting joinMeeting() {
        return null;
    }
}
