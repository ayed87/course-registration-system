package Layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;





public class mamdouh extends Application {
    Button b1 = new Button("Degree Plan");
    Button b2 = new Button("Taken Courses Views");
    Button b3 = new Button("Saved Schedule");
    Button b4= new Button("New Schedule");
    Button b5= new Button("Exist"); 
    public void start(Stage primaryStage) {
        Label text= new Label();
        text.setText("Course offering");
        // Left side vbox
        VBox vbox1= new VBox();
        vbox1.setSpacing(10);
        vbox1.setPadding(new Insets(5,5,5,5));
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(b1);
        vbox1.getChildren().add(b3);

        // Right side vbox 
        VBox vbox2= new VBox();
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().add(b2);
        vbox2.getChildren().add(b4);


        BorderPane pane= new  BorderPane();
        pane.setTop(text);
        pane.setLeft(vbox1);
        pane.setRight(vbox2);
        pane.setBottom(b5);

        BorderPane.setAlignment(b5, Pos.CENTER);
        BorderPane.setAlignment(text, Pos.CENTER);
        


        Scene scene = new Scene(pane ,300,200);
        primaryStage.setScene(scene);


        primaryStage.show();
        


        

        
    }
    public static void main(String[] args) {
        launch(args);
      }
}
