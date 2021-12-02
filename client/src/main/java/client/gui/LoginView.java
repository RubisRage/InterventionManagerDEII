package client.gui;

import client.control.InterventionManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Intervention;


public class LoginView implements View{
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void loginCallback(){

    }

    @Override
    public void update(){
        if(InterventionManager.getIM().getUser() != null) {
            //ViewManager.getVM().setView();
        }
    }
}
