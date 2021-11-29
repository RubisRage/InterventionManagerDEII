package client.view.gui;

import client.control.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewManager {
    private static ViewManager instance;

    public static ViewManager getInstance(){
        if(instance == null)
            instance = new ViewManager();

        return instance;
    }

    private Scene currentScene;
    private Map<View, String> views;

    private ViewManager() {
        currentScene = null;
        views = new HashMap<>();

        views.put(View.LOGIN_VIEW, "LoginView");
    }

    public void setView(View view){
        try {
            if(currentScene == null)
                currentScene = new Scene(loadFXML(views.get(view)));
            else
                currentScene.setRoot(loadFXML(views.get(view)));

        } catch (IOException e) {
            System.err.println("Error occured while loading scene");
            e.printStackTrace();

            System.exit(1);
        }
    }


    public Scene getScene(){
        return currentScene;
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewManager.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
