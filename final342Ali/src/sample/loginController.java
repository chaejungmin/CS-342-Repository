package sample;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URI;

/**
 * Created by alishirsalimian on 4/1/17.
 */
public class loginController {

    @FXML
    private Label label;

    @FXML
    private Label invalid_label;

    @FXML
    private TextField username_box;

    @FXML
    private TextField password_box;


    @FXML
    public void validLogin() {
        isvalid();
    }

    public void isvalid() {

        System.out.println("UserName:" + this.username_box.getText());
        System.out.println("pass:" + password_box.getText());
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            String URL = "https://www.google.com/";
            desktop.browse(URI.create(URL));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
