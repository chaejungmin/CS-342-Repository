package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by alishirsalimian on 4/2/17.
 */
public class userpage {

     @FXML
     private ChoiceBox resturant_viewer;

     @FXML
     ObservableList<String> resturants = FXCollections.observableArrayList("Buffalo Wild Wings");


    public void initialize() {
         System.out.println("CLICKED");
         resturant_viewer = new ChoiceBox();
         resturant_viewer.setItems(resturants);
    }

}

//Referenced:   http://docs.oracle.com/javafx/2/ui_controls/choice-box.htm
