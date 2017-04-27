package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;


import javafx.scene.control.*;


/**
 * Created by alishirsalimian on 4/25/17.
 */
public class viewreservations_controller extends Reservation{

    @FXML
    private Button delete, checkin;

    @FXML
    private javafx.scene.control.ListView<String> listview;

    @FXML
    public void viewresevation(ActionEvent event) throws IOException{
        Parent admin_parent = FXMLLoader.load(getClass().getResource("ViewReservation_Scence.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();
    }

    @FXML
    public void delete_reservation()throws IOException{

        System.out.println(listview.getSelectionModel().getSelectedIndex());
        int index = listview.getSelectionModel().getSelectedIndex();
        String uname =  listview.getSelectionModel().getSelectedItem();
        deletereservation(uname);
        listview.getItems().remove(index);
        Stage stage;
        Parent root;
        stage= (Stage)delete.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("delete_Scene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void checkin_resrevation()throws IOException{
        System.out.println(listview.getSelectionModel().getSelectedIndex());
        int index = listview.getSelectionModel().getSelectedIndex();
        String uname =  listview.getSelectionModel().getSelectedItem();
        deletereservation(uname);
        listview.getItems().remove(index);
        Stage stage;
        Parent root;
        stage= (Stage)checkin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("confirm_scene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    public void back1(ActionEvent event) throws IOException {

        Parent admin_parent = FXMLLoader.load(getClass().getResource("Admin_Scene.fxml"));
        Scene admin_scene = new Scene(admin_parent);
        Stage admin_stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();// basic code to get the stage set to the current scence
        admin_stage.setScene(admin_scene);
        admin_stage.show();


    }

    @FXML
    public void initialize() {

        ObservableList<String> reservations = FXCollections.observableArrayList(get_reservations());
        listview.setItems(reservations);


    }

}
