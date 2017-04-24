package ResturantApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("StartUpScene.fxml"));
        primaryStage.setTitle("Resturant Reserver App");
        Scene selectScene = new Scene(root);
        primaryStage.setScene(selectScene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
