package client.control;

import client.gui.HomeView;
import client.gui.LoginView;
import client.gui.ViewManager;
import connection.client.DEIIServerRequester;
import connection.client.ServerListener;
import connection.client.ServerRequester;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final String HOST_NAME = "deii.dis.ulpgc.es";
    private final Integer PORT = 8040;

    private ServerRequester serverRequester;
    private ServerListener serverListener;

    private void establishConnection(){
        try {
            Socket socket = new Socket(HOST_NAME, PORT);

            serverRequester = new DEIIServerRequester(socket.getOutputStream());

            InterventionManager.getIM().setRequester(serverRequester);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) {
        //establishConnection();

        ViewManager vm = ViewManager.getVM();
        vm.setView(new HomeView());


        stage.setScene(vm.getScene());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        serverRequester.disconnect();
        serverListener.disconnect();
    }
}
