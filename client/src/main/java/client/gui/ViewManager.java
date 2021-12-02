package client.gui;

import javafx.scene.Scene;

import java.util.Observer;

public class ViewManager {
    private static ViewManager instance;

    public static ViewManager getInstance(){
        if(instance == null)
            instance = new ViewManager();

        return instance;
    }

    private Scene scene;
    private View currentView;

    private ViewManager() {
        scene = null;
        currentView = null;
    }

    public View getView() {
        return currentView;
    }

    public void setView(View view){
        currentView = view;
        if (scene == null)
            scene = new Scene(view.load());
        else
            scene.setRoot(view.load());
    }

    public Scene getScene(){
        return scene;
    }
}
