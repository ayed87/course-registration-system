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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Parent;







public class flowchart extends Application {
    

    public void start(Stage primaryStage) {

        Text label =new Text("ICS Flowchart");
        label.setFont(new Font("Arial", 50));
   
        ImageView imageView1= new ImageView();
        Image flowChartImage = new Image("http://www.kfupm.edu.sa/departments/ics/PublishingImages/Pages/Forms/AllItems/BS_CS_summerTraining.JPG");
        imageView1.setImage(flowChartImage);
        
        VBox vbox= new VBox();
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(5,5,5,5));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label,imageView1);
        

        

        

        Scene scene1 = new Scene(vbox ,300,200);
  

        primaryStage.setScene(scene1);
        
         

       
        primaryStage.setTitle("flowchart");
        primaryStage.show();
    }

        public static void main(String[] args) {
            launch(args);
    
        }
 }       
    
          
        

