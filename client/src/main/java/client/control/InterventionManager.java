package client.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Delegate;
import model.Meeting;

import java.io.IOException;

public class InterventionManager {
    private Delegate user;
    private Meeting currentMeeting;
    private Scene currentScene;

    private InterventionManager(){
        user = null;
        currentMeeting = null;
    }


    public Delegate getUser() {
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

    private static InterventionManager interventionManager;

    public static InterventionManager getIM(){
        if(interventionManager == null) {
            interventionManager = new InterventionManager();
        }

        return interventionManager;
    }
}
