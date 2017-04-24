package ResturantApp;



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


/**
 * Created by alishirsalimian on 4/1/17.
 */
public class ValidLoginController {

    private static String myVariable;

    @FXML
    private Label Error_label;

    @FXML
    private TextField username_box;

    @FXML
    private TextField password_box;


    @FXML
    public void validLogin(ActionEvent event) throws IOException, SQLException  {

        Error_label.setText(" ");
        //username_con = "";
        int valid = isvalid(event);
        //System.out.println("BANGd:" + username_con);

        ValidLoginController.setMyVariable(myVariable);

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

        }else if(valid == 3){

            Error_label.setText("Error Login");
            username_box.setText("");
            password_box.setText("");

        }

    }

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
                    System.out.println("USERNAME = " + username);
                    String password = rs.getString("PASSWORD");
                    System.out.println("PASSWORD = " + password);
                    int access = rs.getInt("Access");
                    System.out.println("Access = " + access);
                    myVariable = username;
                    if (access == 0) {
                        valid = 2;
                    }else if (access == 1) {
                        valid = 1;
                    }
                }else{
                    System.out.println("FREE");
                }
            }
            rs.close();
        }catch (Exception e) {
            System.out.println(e);
        }finally{
            stmt.close();
            c.close();
        }

        System.out.println(valid);
        return valid;
    }


    public static String getMyVariable() {
        return myVariable;
    }

    public static void setMyVariable(String myVariable) {
        ValidLoginController.myVariable = myVariable;
    }

    }



//Referenced Philip Johnson from https://www.youtube.com/watch?v=LDVztNtJWOo.

