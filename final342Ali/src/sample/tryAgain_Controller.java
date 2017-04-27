package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yoonhakang on 2017. 4. 26..
 */
public class tryAgain_Controller extends Reservation{
    @FXML
    private Button back;
    @FXML
    public void goBack()throws IOException {

        //System.exit(0);
        Stage stage;
        Parent root;
        stage= (Stage)back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservation_info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
