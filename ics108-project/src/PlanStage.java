import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Size;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import java.time.temporal.WeekFields;

import javafx.util.Duration;

public class PlanStage extends Application {
  public void start(Stage primaryStage) {


    // buttons
    Button saveScheduleButton = new Button("Save Schedule");
    Button backButton = new Button("go back");

    GridPane weekDaysArea = new GridPane();
    weekDaysArea.setPadding(new Insets(20,20,20,20));
    weekDaysArea.setStyle(Styles.green());
    weekDaysArea.setMinSize(0, 0);
    weekDaysArea.setAlignment(Pos.TOP_CENTER);
    weekDaysArea.setGridLinesVisible(false);


    weekDaysArea.setHgap(8);
    weekDaysArea.setVgap(10);

    // first Row

    weekDaysArea.addRow(
      0,
      createTimeLabel("")

      , createLabel("Sun ",Styles.white(),15)
      , createLabel("Mom",Styles.white(),15)
      , createLabel("Tue",Styles.white(),15)
      , createLabel("Wed",Styles.white(),15)
      , createLabel("Fri",Styles.white(),15)
      , createLabel("Sat",Styles.white(),15)

    );
    // First column

    weekDaysArea.addColumn(
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
    weekDaysArea.add(createTimeLabel("ics 104"), 1, 1);
    weekDaysArea.add(createTimeLabel(""), 1, 2);
    

    // choused coruses side
    
    VBox selectedCoursesArea = new VBox();
    selectedCoursesArea.setPadding(new Insets(15));
    selectedCoursesArea.setPrefWidth(250);
    selectedCoursesArea.setStyle("-fx-background-color: white;");
    Label selectedCoursesText = createLabel("Selected Courses", Styles.white(),15);
    ObservableList<String> selectedCourses = FXCollections.observableArrayList(
      "ics 104 ","phys 102","chem 101");
    ListView<String> listView = new ListView<String>(selectedCourses);
    



    selectedCoursesArea.getChildren().addAll(selectedCoursesText,listView);
    
    //adding the buttons at the bottom

    HBox bottomButtonArea  = new HBox();
    bottomButtonArea.setSpacing(15);
    bottomButtonArea.setAlignment(Pos.CENTER);
    bottomButtonArea.getChildren().addAll(saveScheduleButton,backButton);
    
    
    
    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background-color: lightblue;");
    borderPane.setPadding(new Insets(15));

    borderPane.setCenter(weekDaysArea);
    borderPane.setRight(selectedCoursesArea);
    borderPane.setBottom(bottomButtonArea);







    
    Scene scene = new Scene(borderPane, 500, 250);
    primaryStage.setTitle("schedule page"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static Label createLabel(String text, String style,double size){
    Label theLable = new Label(text);
    theLable.setStyle(style);
    theLable.setPrefSize(700,50);
    theLable.setFont(new Font("Arial", size));

    theLable.setAlignment(Pos.TOP_CENTER);

    return theLable;

  }
  public static Label createTimeLabel(String text){
    Label theLable = new Label(text);
    theLable.setStyle("-fx-background-color: #F0F1F3;");
    theLable.setPrefSize(700,50);
    theLable.setFont(new Font("Arial", 17));
    theLable.setAlignment(Pos.TOP_CENTER);

    return theLable;

  }


  
}