package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 26..
 */
public class delete_Controller extends ResturantAPI {

    @FXML
    private Button back;
    @FXML
    public void goBack()throws IOException {


        Stage stage;
        Parent root;
        stage= (Stage)back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("View_Reservation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
