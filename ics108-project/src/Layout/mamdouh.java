package Layout;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Parent;







public class mamdouh extends Application {
    
    


     
    public void start(Stage primaryStage) {
    Button b1 = new Button("Degree Plan");
    Button b2 = new Button("Saved Schedule");
    Button b3 = new Button("New Schedule");
    Button b4= new Button("Exist");
    

       b1.setTextFill(Color.WHITE);
       b2.setTextFill(Color.WHITE);
       b3.setTextFill(Color.WHITE);
       b4.setTextFill(Color.WHITE);
       b1.setStyle("-fx-background-color: Green;");
       b2.setStyle("-fx-background-color: Green;");
       b3.setStyle("-fx-background-color: Green;");
       b4.setStyle("-fx-background-color: Green;");
        
        
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

        // Top hbox
        ImageView imageView1= new ImageView();
        Image flowChartImage = new Image("https://en.wikipedia.org/wiki/King_Fahd_University_of_Petroleum_and_Minerals#/media/File:KFUPM_seal.png");
        imageView1.setImage(flowChartImage);
        HBox hbox= new HBox();
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5,5,5,5));
        hbox.setAlignment(Pos.CENTER);
        //hbox.getChildren().addAll(text,imageView1);
        hbox.getChildren().add(text);

        BorderPane pane= new  BorderPane();
        pane.setTop(hbox);
        pane.setLeft(vbox1);
        pane.setRight(vbox2);
        

        
        
        // To close the window
        b4.setOnAction(actionEvent -> Platform.exit());

        
       

        
        
        
        
        
        
        
        
      

        BorderPane.setAlignment(text, Pos.CENTER);
        

        Scene scene1 = new Scene(pane ,300,200);
  

        primaryStage.setScene(scene1);
        
         

       

        primaryStage.show();
        


        

        
    }
    
    
            
    
      
    public static void main(String[] args) {
        launch(args);

      }

}
   