package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.awt.*;
import java.net.*;
import java.io.IOException;

/**
 * Created by yoonhakang on 2017. 4. 2..
 */
public class resController  extends resturant_info{
    @FXML
    private Button checkTime, menu, Reservation, backToMain;
    @FXML
    private Label showTime;

    @FXML
    public void goBackToMain(){


    }


    @FXML
    public void makeReservation() throws IOException{
        Stage stage;
        Parent root;
        stage= (Stage)Reservation.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("reservation_info.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showMenu() throws IOException {

        try {
            Desktop desktop = Desktop.getDesktop();
            String URL = getMenu();
            desktop.browse(URI.create(URL));
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

}
