package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 3..
 */
public class Reservation_Controller extends Reservation{

    @FXML
    private Button makeReservation, back;
    @FXML
    private Label resturant_name;
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
    public void goBack()throws IOException {
        Stage stage;
        Parent root;
        stage= (Stage)back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("restaurant_info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Get information from reservation scene
    // and insert it into the reservation db
    @FXML
    public void makeReservation(){
        Reservation reservation = new Reservation();

        reservation.setFirstName(firstName.getText());
        reservation.setLastName(lastName.getText());
        reservation.setContact(contact.getText());
        reservation.setEmail(email.getText());
        reservation.setHowMany(howMany.getText());
        reservation.setMemo(memo.getText());


        //insertreservation()


    }

    public void initialize(){
        resturant_name.setText(RestaurantList_Controller.getResturant_selected());



    }


}
