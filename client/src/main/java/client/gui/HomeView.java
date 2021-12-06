package client.gui;

import client.control.InterventionManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeView implements View, Initializable {

    @FXML
    private Label fullNameLabel;

    @FXML
    private ImageView userImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ellipse circleClip = new Ellipse();

        circleClip.centerXProperty().bind(userImage.xProperty().add(userImage.fitWidthProperty().divide(2)));
        circleClip.centerYProperty().bind(userImage.yProperty().add(userImage.fitHeightProperty().divide(2)));
        circleClip.radiusXProperty().bind(userImage.fitWidthProperty().divide(2));
        circleClip.radiusYProperty().bind(userImage.fitHeightProperty().divide(2));

        userImage.setClip(circleClip);
    }

    public void update(){

    }
}
