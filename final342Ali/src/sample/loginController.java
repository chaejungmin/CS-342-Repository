package sample;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;



import java.awt.*;
import java.net.URI;

/**
 * Created by alishirsalimian on 4/1/17.
 */
public class loginController {


    @FXML
    private Label Error_label;

    @FXML
    private TextField username_box;

    @FXML
    private TextField password_box;


    @FXML
    public void validLogin(ActionEvent event) throws IOException, SQLException {
        Error_label.setText(" ");
        isvalid(event);
    }

    public void isvalid(ActionEvent event) throws IOException, SQLException{

        System.out.println("UserName:" + username_box.getText());
        System.out.println("pass:" + password_box.getText());

        if(username_box.getText().equals("admin")  && password_box.getText().equals("password1")){

            Parent admin_parent = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
            Scene admin_scene = new Scene(admin_parent);
            Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
            admin_stage.setScene(admin_scene);
            admin_stage.show();
            Error_label.setText("Sucess1");

        }else if(username_box.getText().equals("user")  && password_box.getText().equals("password")){
            Error_label.setText(" ");
            Parent user_parent = FXMLLoader.load(getClass().getResource("restaurant_Info.fxml"));
            Scene user_scene = new Scene(user_parent);
            Stage user_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
            user_stage.setScene(user_scene);
            user_stage.show();
            Error_label.setText("Sucess2");
        }else{
            Error_label.setText("Error Login");
        }
    }
}

//Referenced Philip Johnson from https://www.youtube.com/watch?v=LDVztNtJWOo.

