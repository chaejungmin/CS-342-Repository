package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by alishirsalimian on 4/25/17.
 */
public class viewreservation_labels extends Reservation{

    @FXML
    private Label NumberOfGuest,PhoneNumber,Comments,ReservationName;


    @FXML
    public void initialize() {

            


    }

    @FXML
    public void back1(ActionEvent event)throws IOException,SQLException{
        goButton(event, "View_Reservation.fxml");

    }



}
