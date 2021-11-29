package client.view.persistence;

import model.Intervention;
import model.Meeting;
import model.client.Synchronizer;

import java.io.IOException;
import java.net.Socket;

public class ServerClient implements Synchronizer {

    private static ServerClient instance;
    private static String url;
    private static Integer port;

    private Socket socket;

    private ServerClient(String url, Integer port){
        try {
            socket = new Socket(url, port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void setServer(String url, Integer port){
        if(ServerClient.url == null && ServerClient.port == null) {
            ServerClient.url = url;
            ServerClient.port = port;
        }
    }

    public static ServerClient getInstance(){
        if(instance == null){
            instance = new ServerClient(ServerClient.url, ServerClient.port);
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
    public void login(String username, String password) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void createMeeting(Meeting meeting) {

    }

    @Override
    public void joinMeeting() {

    }
}
