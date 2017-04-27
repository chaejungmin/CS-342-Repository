package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 3..
 */
public class Reservation_Controller extends Reservation{

    @FXML
    private Button back, makeres_button;
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
    public void makeReservation()throws IOException{
        Reservation reservation = new Reservation();
        reservation.setContact(contact.getText());

        if(Integer.parseInt(howMany.getText())>10){
            Stage stage;
            Parent root;
            stage= (Stage)makeres_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("tryAgain_scene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            reservation.setHowMany(howMany.getText());
            reservation.setMemo(memo.getText());
            reservation.insert_reservation();

            Stage stage;
            Parent root;
            stage = (Stage) makeres_button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ThankYou.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void initialize(){
        resturant_name.setText(RestaurantList_Controller.getResturant_selected());
    }


}
