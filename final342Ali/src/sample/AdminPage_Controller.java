package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alishirsalimian on 4/2/17.
 */
public class AdminPage_Controller extends ResturantAPI {
    private static String myusername;

    @FXML
    private TextField Menu_Text,WaitTime_Text, OpenTime_Text, ClosingTime_Text, ContactNum_Text, Street_Text, City_Text, State_Text, Zipcode_Text;

    @FXML
    private Button backButton;

    @FXML
    private Label resturant_name;

    public void goBack() throws IOException {
        Stage stage;
        Parent root;
        stage= (Stage)backButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login_Scene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void UpdateWaitTime() {
        setWaitTime( Integer.parseInt(WaitTime_Text.getText()),getAdminResturantName(ValidLoginController.getMyusername()));
    }

    public void UpdateOpenTime() { setOpenTime(OpenTime_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateClosingTime() {setclosingTime(ClosingTime_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateContactNumber() {setPhoneNumber(ContactNum_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateStreet() {setstreet(Street_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateCity(){ setcity(City_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateState(){ setstate(State_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername()));}

    public void UpdateZipcode(){ setZipcode(Integer.parseInt(Zipcode_Text.getText()),getAdminResturantName(ValidLoginController.getMyusername()));}
    
    public void UpdateMenu(){ setMenu(Menu_Text.getText(),getAdminResturantName(ValidLoginController.getMyusername())); }

    public void view_reservations(ActionEvent event)throws IOException, SQLException {
            goButton(event, "View_Reservation.fxml");
    }


    @FXML
    public void initialize(){
        resturant_name.setText(getAdminResturantName(ValidLoginController.getMyusername()));

    }


}
