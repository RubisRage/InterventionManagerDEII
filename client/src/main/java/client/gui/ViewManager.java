package client.gui;

import javafx.scene.Scene;

public class ViewManager {
    private static final ViewManager instance = new ViewManager();

    public static ViewManager getVM(){
        return instance;
    }

    private Scene scene = null;
    private View currentView = null;

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
