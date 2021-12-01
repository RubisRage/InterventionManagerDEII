package client.view.gui;

import javafx.scene.Scene;

public class ViewManager {
    private static ViewManager instance;

    public static ViewManager getInstance(){
        if(instance == null)
            instance = new ViewManager();

        return instance;
    }

    private Scene currentScene;

    private ViewManager() {
        currentScene = null;
    }

    public void setView(View view){
        if (currentScene == null)
            currentScene = new Scene(view.load());
        else
            currentScene.setRoot(view.load());
    }

    public Scene getScene(){
        return currentScene;
    }
}
