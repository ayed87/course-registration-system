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
    
   
    @Override  
    public void start(Stage primaryStage){
        Button newScheduleNext = new Button("Next");
        Button newScheduleBack = new Button("Back");
       HBox item= new HBox();
       item.setSpacing(50);
       item.setPadding(new Insets(5,5,5,5));
       item.setAlignment(Pos.CENTER);

        TextField name = new TextField();
        item.getChildren().addAll(new Label("Enter your name Schedule :"),name);

         
        

       HBox item1= new HBox();
       item1.setSpacing(100);
       item1.setPadding(new Insets(5,5,5,5));
       item1.setAlignment(Pos.CENTER);
       item1.getChildren().addAll(newScheduleNext,newScheduleBack);
        
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
