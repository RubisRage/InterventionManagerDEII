package client.control;

import connection.client.ServerRequester;
import connection.request.Request;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Delegate;
import model.Meeting;

import java.io.IOException;

public class InterventionManager {
    private volatile Delegate user;
    private volatile Meeting currentMeeting;
    private volatile ServerRequester serverRequester;

    private InterventionManager(){
        user = null;
        currentMeeting = null;
    }


    public synchronized Delegate getUser() {
        return user;
    }

    public Meeting getCurrentMeeting() {
        return currentMeeting;
    }

    public void setUser(Delegate user){
        this.user = user;
    }

    public void setCurrentMeeting(Meeting currentMeeting){
        this.currentMeeting = currentMeeting;
    }

    public void setRequester(ServerRequester serverRequester){
        this.serverRequester = serverRequester;
    }

    public void sendRequest(Request r){
        serverRequester.sendRequest(r);
    }

    private static volatile InterventionManager interventionManager;

    public static synchronized InterventionManager getIM(){
        if(interventionManager == null) {
            interventionManager = new InterventionManager();
        }

        return interventionManager;
    }
}
