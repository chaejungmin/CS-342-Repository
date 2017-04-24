package ResturantApp;


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
public class ResturantInfo_Controller extends ResturantAPI {
    private static String myusername;
    private static String selectedres;

//    public String username1;
//
//    private StartUpController maincontroller;

    @FXML
    private Button checkTime, menu, Reservation, backToMain;

    @FXML
    private Label Hours,ResName,addressLabel,phonenumber,WaitTime;


    @FXML
    public void goBackToMain() throws IOException{
        Stage stage;
        Parent root;
        stage= (Stage)Reservation.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login_Scene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize(){
        myusername = ValidLoginController.getMyVariable();
        selectedres = RestaurantList_Controller.getResturant_selected();
      System.out.println("username1" + ValidLoginController.getMyVariable());
      System.out.println("Res Selected: " + RestaurantList_Controller.getResturant_selected());
        ResName.setText(getResturantName(selectedres));
        Hours.setText(getOpenTime(selectedres) + "-" + getclosingTime(selectedres));
        addressLabel.setText(getstreet(selectedres) + "\n" + getcity(selectedres) + "," + getstate(selectedres) + " "+ getZipcode(selectedres));
        phonenumber.setText(getPhoneNumber(selectedres));
        WaitTime.setText(Integer.toString(getWaitTime(selectedres)));

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
            String URL = getMenu(selectedres);
            desktop.browse(URI.create(URL));
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

}
