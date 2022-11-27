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

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        
        GridPane gride = new GridPane();
        gride.setAlignment(Pos.CENTER);
        gride.setPadding(new Insets(11.5,12.5,13.5,14.5));
        gride.setHgap(5.5);
        gride.setVgap(5.5);
        

        gride.add(new Label("Enter your name:"),0,0);
        gride.add(new TextField(),1,0);
        gride.add(new Label("Enter your id :"),0,1);
        gride.add(new TextField(),1,1);
        gride.add(new Label("Enter the name of your schedule"),0,2);
        gride.add(new TextField(),1,2);
        gride.add(b1,0,5);
        gride.add(b2,2,5);
        

        Scene scene = new Scene(gride);
        primaryStage.setScene(scene);
     
        primaryStage.setTitle("New schedule");
        primaryStage.show();


        
    }
    public static void main(String[] args) {
        launch(args);
      }
    
}
