package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.sql.*;
import sample.loginController;
import sample.resController;

public class Main extends Application {
//    public String username_con;
//
//    @FXML
//    loginController loginController1;
//    @FXML
//    resController resController1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        primaryStage.setTitle("Resturant Reserver App");
        Scene selectScene = new Scene(root);
        primaryStage.setScene(selectScene);
        primaryStage.show();
    }

//    @FXML
//    public void initialize() {
//        System.out.println("Application started");
//        loginController1.init(this);
//        resController1.init(this);
//    }
//
//    public void setUsername(String username){
//        username_con = username;
//    }
//
//    public String getUsername() {
//        return username_con;
//    }


    public static void main(String[] args) {

        launch(args);
    }
}
