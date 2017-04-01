package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{


    Button button1;
    Button button2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Resturant Reserver App");

        button1 = new Button("Admin");
        button2 = new Button("User");
        button1.setOnAction(this);
        button2.setOnAction(this);

        FlowPane grid = new FlowPane();
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setHgap(100);
        grid.getChildren().addAll(button1,button2);

        Scene scene = new Scene(grid,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == button1){
            System.out.println("User Sign In Page");
        }
        if(event.getSource() == button2){
            System.out.println("Admin Sign In Page");
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
