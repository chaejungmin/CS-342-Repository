package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller  {

    @FXML
    public void Login(ActionEvent event) throws IOException{

        Parent admin_parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();;
        admin_stage.setScene(admin_scene);
        admin_stage.show();
    }


}


