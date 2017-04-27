package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.awt.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;




/**
 * Created by alishirsalimian on 4/24/17.
 */
public class newuser_controller {

    @FXML
    private javafx.scene.control.TextField username;

    @FXML
    private PasswordField password_text;
    @FXML
    private Button back;


    // goes back to login
    @FXML
    public void back1(ActionEvent event) throws IOException{
        Parent admin_parent = FXMLLoader.load(getClass().getResource("StartUpScene.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();

    }

    // creates an account based on info that
    // was put in the text fields
    @FXML
    public void createaccount(){

            Connection c = null;
            Statement stmt = null;
            String resturant_info = "";

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:resturantdb.db");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                stmt.executeUpdate("INSERT INTO Users Values ('"+username.getText()+"', '"+ password_text.getText()+"',0,0)");
                stmt.close();
                c.close();
            }catch(Exception e){
                System.out.println(e);
            }
    }

}
