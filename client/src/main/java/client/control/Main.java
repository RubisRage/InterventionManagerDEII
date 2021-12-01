package client.control;

import client.view.gui.LoginView;
import client.view.gui.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewManager vm = ViewManager.getInstance();
        vm.setView(new LoginView());

        stage.setScene(vm.getScene());
        stage.show();
    }
}
