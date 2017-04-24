package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 3..
 */
public class Reservation_Controller {
    @FXML
    private Button makeReservation, back;
    @FXML
    private Text restaurantName;
    @FXML
    private TextField firstName,lastName,contact,email,howMany;
    @FXML
    private TextArea memo;
    @FXML
    private ChoiceBox time;
    @FXML
    private DatePicker date;
    @FXML
    private String FirstName, LastName, PhoneNumber, Email;
    @FXML
    private int numOfPpl;

    @FXML
    public void goBack()throws IOException {
        Stage stage;
        Parent root;
        stage= (Stage)back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("restaurant_info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void makeReservation(){

    }

    public void initialize(){
    }


}
