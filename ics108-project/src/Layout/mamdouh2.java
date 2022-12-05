package Layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

import Data.Schedule;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
// stage for new Schedule
public class mamdouh2 extends Application {
    
    Button b1 = new Button("Next");
    Button b2 = new Button("Back");
    @Override  
    public void start(Stage primaryStage){
       HBox item= new HBox();
       item.setSpacing(50);
       item.setPadding(new Insets(5,5,5,5));
       item.setAlignment(Pos.CENTER);

        TextField name = new TextField();
        item.getChildren().addAll(new Label("Enter your name Schedule :"),name);

         
        //gride.add(new Label("Enter your name Schedule :"),0,0);
        //gride.add(name,1,0);
        //gride.add(new Label("Enter your id :"),0,1);
       // gride.add(new TextField(),1,1);
        //gride.add(new Label("Enter the name of your schedule"),0,2);
       // gride.add(new TextField(),1,2);
        //gride.add(b1,0,5);
        //gride.add(b2,2,5);

       HBox item1= new HBox();
       item1.setSpacing(100);
       item1.setPadding(new Insets(5,5,5,5));
       item1.setAlignment(Pos.CENTER);
       item1.getChildren().addAll(b1,b2);
        
        VBox item2= new VBox();
        item2.setSpacing(100);
        item2.setPadding(new Insets(5,5,5,5));
        item2.setAlignment(Pos.CENTER);
        item2.getChildren().addAll(item,item1);
        Schedule schedule =new Schedule();
        //event for name
        name.setOnAction(e->{
             //schedule.getNameSchedule(name);
        });


        Scene scene1 = new Scene(item2,100,100);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("New schedule");

        primaryStage.show();

        
        
    }
   
    
    public static void main(String[] args) {
        launch(args);
      }
    
}
