package sample;

import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;


/**
 * Created by alishirsalimian on 4/1/17.
 */
public class ValidLoginController {

    private static String myusername;

    @FXML
    private Label Error_label, warning;

    @FXML
    private TextField username_box;

    @FXML
    private PasswordField password_box;

    @FXML
    private Button back;

    // if it a valid login and based on the admin or user access
    // we transfer to the next approaite scene
    @FXML
    public void validLogin(ActionEvent event) throws IOException, SQLException  {

        Error_label.setText(" ");
        int valid = isvalid(event);

        ValidLoginController.setMyusername(myusername);

        if(valid == 1){
            Error_label.setText(" ");
            Parent user_parent = FXMLLoader.load(getClass().getResource("Admin_Scene.fxml"));
            Scene user_scene = new Scene(user_parent);
            Stage user_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
            user_stage.setScene(user_scene);
            user_stage.show();
            Error_label.setText("Sucess2");


        }else if(valid == 2){

            Error_label.setText(" ");
            Parent user_parent = FXMLLoader.load(getClass().getResource("restaurantList.fxml"));
            Scene user_scene = new Scene(user_parent);
            Stage user_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
            user_stage.setScene(user_scene);
            user_stage.show();
            Error_label.setText("Sucess2");

        }else if(valid == 0){

            Error_label.setText("Invalid credentials. Try again");
            username_box.setText("");
            password_box.setText("");

        }

    }

    // validate the login
    public int isvalid(ActionEvent event) throws IOException, SQLException {

        Connection c = null;
        Statement stmt = null;
        int valid = 0;

        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Username= " + "'" + username_box.getText() + "'"
                    + " AND Password= " + "'" + password_box.getText() + "'");
            while (rs.next()) {
                if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    int access = rs.getInt("Access");
                    myusername = username;
                    if (access == 0) {
                        valid = 2;
                    }else if (access == 1) {
                        valid = 1;
                    }
                }
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e) {
            System.out.println(e);
        }

        return valid;
    }


    // goes back to login
    @FXML
    public void back1(ActionEvent event) throws IOException{
        Parent admin_parent = FXMLLoader.load(getClass().getResource("StartUpScene.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();

    }

    // get and set the username that was used during the log on.
    public static String getMyusername() {
        return myusername;
    }

    public static void setMyusername(String myusername) {
        ValidLoginController.myusername = myusername;
    }

    }



//Referenced Philip Johnson from https://www.youtube.com/watch?v=LDVztNtJWOo.

