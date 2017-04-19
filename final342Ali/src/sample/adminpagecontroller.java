package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.String;

/**
 * Created by alishirsalimian on 4/2/17.
 */
public class adminpagecontroller extends resturant_info{

    @FXML
    private TextField Menu_Text,WaitTime_Text, OpenTime_Text, ClosingTime_Text, ContactNum_Text, Street_Text, City_Text, State_Text, Zipcode_Text;

    @FXML
    private Button backButton;

    public void goBack() throws IOException {
        Stage stage;
        Parent root;
        stage= (Stage)backButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void UpdateWaitTime() {

        System.out.println(Integer.parseInt(WaitTime_Text.getText()));

        setWaitTime(Integer.parseInt(WaitTime_Text.getText()));
    }

    public void UpdateOpenTime() { setOpenTime(OpenTime_Text.getText());}

    public void UpdateClosingTime() {setclosingTime(ClosingTime_Text.getText());}

    public void UpdateContactNumber() {setPhoneNumber(ContactNum_Text.getText());}

    public void UpdateStreet() {setstreet(Street_Text.getText());}

    public void UpdateCity(){ setcity(City_Text.getText());}

    public void UpdateState(){ setstate(State_Text.getText());}

    public void UpdateZipcode(){ setZipcode(Integer.parseInt(Zipcode_Text.getText()));}
    
    public void UpdateMenu(){ setMenu(Menu_Text.getText()); }



}
