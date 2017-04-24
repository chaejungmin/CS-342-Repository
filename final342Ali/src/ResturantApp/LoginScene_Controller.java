package ResturantApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginScene_Controller {

    @FXML
    public void Login(ActionEvent event) throws IOException{

        Parent admin_parent = FXMLLoader.load(getClass().getResource("Login_Scene.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();
    }

//Referenced Philip Johnson https://www.youtube.com/watch?v=LDVztNtJWOo.

}


