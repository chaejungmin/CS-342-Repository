package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.lang.String;

/**
 * Created by alishirsalimian on 4/2/17.
 */
public class adminpagecontroller extends resturant_info{


    @FXML
    private TextField WaitTime_Text;


    public void UpdateWaitTime() {
        setWaitTime(Integer.parseInt(WaitTime_Text.getText()));
    }

}
