package client.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Arrays;

public interface View {

    default Parent load(){
        Class<? extends View> instanceClass = this.getClass();
        String instanceName = instanceClass.getSimpleName();
        FXMLLoader fxmlLoader = new FXMLLoader(instanceClass.getResource(instanceName + ".fxml"));
        fxmlLoader.setController(this);

        Parent p = null;

        try {
            p = fxmlLoader.load();
        } catch (IOException e) {
            System.err.printf("Error while loading %s: %s\n",
                    this.getClass().getCanonicalName(),
                    Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }

        return p;
    }
}
