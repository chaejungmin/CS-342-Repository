package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yoonhakang on 2017. 4. 3..
 */
public class RestaurantList_Controller extends ResturantAPI{

    private static String resturant_selected = "";

    ObservableList<String> ListOfRestaurant = FXCollections.observableArrayList("Buffalo Wild Wings", "Red Loster", "Purple Pig", "Chef Ping");

    @FXML
    private Button back, submit;
    @FXML
    private ChoiceBox restaurant_list;

    @FXML
    public void initialize (){
        restaurant_list.setValue("Purple Pig");
        restaurant_list.setItems(ListOfRestaurant);

    }

    //going back to portal main
    @FXML
    public void goBack1(ActionEvent event)throws IOException, SQLException {
        goButton(event, "Login_Scene.fxml");
    }


    //going to Restaurant_info
    @FXML
    public void goSubmit(ActionEvent event)throws IOException, SQLException{
        resturant_selected =  (String)restaurant_list.getValue();
        RestaurantList_Controller.setselectedresturant(resturant_selected);
        goButton(event, "restaurant_info.fxml");

    }

    // setting the selected resturant and getting method to load from the API
    public static void setselectedresturant(String resturant_selected){

        RestaurantList_Controller.resturant_selected = resturant_selected;
    }

    public static String getResturant_selected(){
        return resturant_selected;
    }


    



}
