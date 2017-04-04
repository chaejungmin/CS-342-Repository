package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 3..
 */
public class reservationController {
    private Button makeReservation, back;
    private Text firstName, lastName, contact, email, howMany;
    private TextField memo;
    private ChoiceBox time;
    private DatePicker date;

    private String FirstName, LastName, PhoneNumber, Email;
    private int numOfPpl;

    public void goBack()throws IOException {
        Stage stage;
        Parent root;
        stage= (Stage)back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("restaurant_info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void makeReservation(){

    }


}
