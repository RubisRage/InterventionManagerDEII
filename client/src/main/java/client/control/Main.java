package client.control;

import client.view.gui.View;
import client.view.gui.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewManager vm = ViewManager.getInstance();
        vm.setView(View.LOGIN_VIEW);

        stage.setScene(vm.getScene());
        stage.show();
    }
}
