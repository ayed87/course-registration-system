import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import javafx.util.Duration;

public class PlanStage extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    Button saveScheduleButton = new Button("Save Schedule");
    Button backButton = new Button("go back");

    GridPane weekDays = new GridPane();
    weekDays.setPadding(new Insets(20,40,20,40));
    weekDays.setStyle("-fx-background-color: pink;");
    weekDays.setMinSize(0, 0);
    weekDays.setAlignment(Pos.TOP_CENTER);


    weekDays.setMinSize(0, 0);
    weekDays.setGridLinesVisible(false);



    weekDays.setHgap(5);
    weekDays.setVgap(10);
    Label label = new Label("Sun");
    label.setPrefSize(40,40);
    label.setFont(Font.font(15));  
    weekDays.addRow(
      0,
      createTimeLabel("")

      , createLabel("Sun ")
      , createLabel("Mon")
      , createLabel("Tus")
      , createLabel("wns")
      , createLabel("thurs")
      , createLabel("Fri")
      , createLabel("Sat")

    );


    weekDays.addColumn(
      0,
      createTimeLabel("7:00 AM"),
      createTimeLabel(" 8:00 AM"),
      createTimeLabel("9:00 AM"),
      createTimeLabel("10:00 AM"),
      createTimeLabel("11:00 AM"),
      createTimeLabel("12:00 PM"),
      createTimeLabel("1:00 PM"),
      createTimeLabel("2:00 PM"),
      createTimeLabel("3:00 PM"),
      createTimeLabel("4:00 PM"),
      createTimeLabel("5:00 PM")
      

    );
    

    
    
    VBox chosedCoursed = new VBox();
    chosedCoursed.setPadding(new Insets(15));
    chosedCoursed.setPrefWidth(200);
    chosedCoursed.setStyle("-fx-background-color: white;");
    Label coursesChosedText = createLabel("chosed courses");


    chosedCoursed.getChildren().addAll(coursesChosedText);
    //adding the buttons at the bottom

    HBox bottomButtonArea  = new HBox();
    bottomButtonArea.setSpacing(15);
    bottomButtonArea.getChildren().addAll(saveScheduleButton,backButton);
    
    
    
    BorderPane borderPane = new BorderPane();

    borderPane.setStyle("-fx-background-color: lightblue;");
    borderPane.setPadding(new Insets(15));

    borderPane.setCenter(weekDays);
    borderPane.setRight(chosedCoursed);
    borderPane.setBottom(bottomButtonArea);







    
    Scene scene = new Scene(borderPane, 500, 250);
    primaryStage.setTitle("schedule page"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static Label createLabel(String text){
    Label theLable = new Label(text);
    theLable.setStyle("-fx-background-color: violet;");
    theLable.setPrefSize(700,50);
    theLable.setFont(new Font("Arial", 20));

    theLable.setAlignment(Pos.TOP_CENTER);

    return theLable;

  }
  public static Label createTimeLabel(String text){
    Label theLable = new Label(text);
    theLable.setStyle("-fx-background-color: lightyellow;");
    theLable.setPrefSize(700,50);
    theLable.setFont(new Font("Arial", 20));
    theLable.setAlignment(Pos.TOP_CENTER);

    return theLable;

  }


  
}