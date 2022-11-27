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




public class mamdouh3 extends Application {

    @Override
    public void start(Stage primaryStage)  {
        Degree degree = new Degree();
        degree.setTitle("COE flowchart");
        Image image= new Image("COE-Summer-New.png");
        degree.setImageView(new ImageView(image));
        Scene scene = new Scene(degree,600,600);
        primaryStage.setScene(scene);
     
        primaryStage.setTitle("Degree plan");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
      }
}
