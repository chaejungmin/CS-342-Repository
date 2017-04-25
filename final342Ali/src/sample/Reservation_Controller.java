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
    private Button back;
    @FXML
    private Label resturant_name;
    @FXML
    private TextField contact,howMany;
    @FXML
    private TextArea memo;


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
        reservation.setContact(contact.getText());
        reservation.setHowMany(howMany.getText());
        reservation.setMemo(memo.getText());
        reservation.insertreservation();
    }

    public void initialize(){
        resturant_name.setText(RestaurantList_Controller.getResturant_selected());
    }


}
