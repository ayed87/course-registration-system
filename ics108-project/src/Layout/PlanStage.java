package Layout;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Size;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
import java.util.ArrayList;

import Data.Schedule;
import javafx.util.Duration;

public class PlanStage extends Application {
  int x = 0;
  int y = 0;
  public void start(Stage primaryStage) {
    // Schedule schedule = new Schedule();
    // buttons
    
    Button saveScheduleButton = new Button("Save Schedule");
    Button backButton = new Button("go back");
    BorderPane scheduleArea = new BorderPane();
    scheduleArea.setPadding(new Insets(4));
    


    HBox top = new HBox(8);
    top.setAlignment(Pos.CENTER_RIGHT);
    
    top.getChildren().addAll(
      // createCourseLabel(),
       createLabel("Sun ",Styles.white(),15)
      , createLabel("Mom",Styles.white(),15)
      , createLabel("Tue",Styles.white(),15)
      , createLabel("Wed",Styles.white(),15)
      , createLabel("thurs",Styles.white(),15)
      , createLabel("Fri",Styles.white(),15)
      , createLabel("Sat",Styles.white(),15)
    
    );


    scheduleArea.setTop(top);
    VBox left = new VBox(5);
    left.setPrefHeight(20);
    
    left.getChildren().addAll(
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
    scheduleArea.setLeft(left);
    Pane newPane = new Pane();
    Label aLabel = new Label();
    aLabel.setStyle(Styles.green());
    aLabel.setPrefSize(160, 100);
    aLabel.setLayoutX(0);
    aLabel.setLayoutY(55);
    newPane.getChildren().addAll(aLabel);
    // newPane.getChildren().add(createCourseLabel());

    // newPane.getChildren().addAll(aLabel);




    GridPane weekDaysArea = new GridPane();
    weekDaysArea.setPadding(new Insets(20,20,20,20));
    weekDaysArea.setStyle(Styles.green());
    weekDaysArea.setMinSize(0, 0);
    // weekDaysArea.setAlignment(Pos.TOP_CENTER);
    weekDaysArea.setGridLinesVisible(false);


    // weekDaysArea.setHgap(8);
    // weekDaysArea.setVgap(10);

    // first Row

    // weekDaysArea.addRow(
    //   0,
    //   createTimeLabel("")

    //   , createLabel("Sun ",Styles.white(),15)
    //   , createLabel("Mom",Styles.white(),15)
    //   , createLabel("Tue",Styles.white(),15)
    //   , createLabel("Wed",Styles.white(),15)
    //   , createLabel("Fri",Styles.white(),15)
    //   , createLabel("Sat",Styles.white(),15)

    // );
    // First column

    // weekDaysArea.addColumn(
    //   0,
    //   createTimeLabel("7:00 AM"),
    //   createTimeLabel(" 8:00 AM"),
    //   createTimeLabel("9:00 AM"),
    //   createTimeLabel("10:00 AM"),
    //   createTimeLabel("11:00 AM"),
    //   createTimeLabel("12:00 PM"),
    //   createTimeLabel("1:00 PM"),
    //   createTimeLabel("2:00 PM"),
    //   createTimeLabel("3:00 PM"),
    //   createTimeLabel("4:00 PM"),
    //   createTimeLabel("5:00 PM")
      

    // );
    // weekDaysArea.add(createTimeLabel(""), 1, 2);

    // weekDaysArea.add(createCourseLabel(), 2, 3);
    

    // choused coruses side

    scheduleArea.setCenter(newPane);
    
    VBox selectedCoursesArea = new VBox(5);
    selectedCoursesArea.setPadding(new Insets(15));
    selectedCoursesArea.setPrefWidth(245);
    selectedCoursesArea.setStyle("-fx-background-color: white;");
    Label selectedCoursesText = createLabel("Selected Courses", Styles.white(),15);

    ArrayList<VBox> arrayList = new ArrayList<VBox>();
    for(int i =0; i<5; i++){
      arrayList.add(i, createCourseLabel());
    }
    ObservableList<VBox> selectedCourses = FXCollections.observableArrayList(arrayList);



    ListView<VBox> listView = new ListView<VBox>(selectedCourses);
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    Button confirmButton = new Button("confirm");
    confirmButton.setOnAction(e -> {
      System.out.println("pressed");
      int selctedCourseIndix = listView.getSelectionModel().getSelectedIndex();
      VBox selectedCourse = arrayList.get(selctedCourseIndix);
      // schedule.addSecion(selectedCourse);
      arrayList.remove(selctedCourseIndix);
      HBox slected = createRigestedCourseLabel();

      slected.setLayoutX(x);
      slected.setLayoutY(y);

      // 170 for each day
      // 55 for each hour

      newPane.getChildren().add(slected);
      x += 170;
      y += 55;
      listView.getItems().removeAll(listView.getSelectionModel().getSelectedItem
      ());





      // if
      // schedule.setRegisteredSections(listView.getSelectionModel().getSelectedItems());

      
      
      // if(schedule.checkConflict()){
      //   System.out.println("there is a conflict");
      // }
      // else{
      //   System.out.println("there is no confilict");
        
      // }



    });
    



    selectedCoursesArea.getChildren().addAll(selectedCoursesText,listView,confirmButton);
    
    //adding the buttons at the bottom

    HBox bottomButtonArea  = new HBox();
    bottomButtonArea.setSpacing(15);
    bottomButtonArea.setAlignment(Pos.CENTER);
    bottomButtonArea.getChildren().addAll(saveScheduleButton,backButton);
    
    
    
    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background-color: lightblue;");
    borderPane.setPadding(new Insets(15));

    borderPane.setCenter(scheduleArea);
    borderPane.setRight(selectedCoursesArea);
    borderPane.setBottom(bottomButtonArea);
    
    
    Scene scene = new Scene(borderPane, 500, 250);
    primaryStage.setTitle("schedule page"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); 
    
    // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static Label createLabel(String text, String style,double size){
    Label theLable = new Label(text);
    theLable.setStyle(style);
    theLable.setPrefSize(160,50);
    theLable.setFont(new Font("Arial", size));

    theLable.setAlignment(Pos.CENTER);

    return theLable;

  }
  public static Label createTimeLabel(String text){
    Label theLable = new Label(text);
    theLable.setStyle("-fx-background-color: #F0F1F3;");
    // theLable.setTextFill(Paint.valueOf("black"));
    theLable.setPrefSize(80,50);
    theLable.setFont(new Font("Arial", 17));
    theLable.setAlignment(Pos.TOP_CENTER);

    return theLable;

  }
  public static VBox createCourseLabel(){
    VBox theLable = new VBox();

    theLable.setStyle("-fx-background-color: lightgreen;");
    Text courseNameAndSection = new Text("ics108-section1");
    Text time = new Text("7:00");
    Text day = new Text("to day");
    // theLable.setTextFill(Paint.valueOf("black"));
    theLable.setPrefSize(150,90);
    // theLable.setFont(new Font("Arial", 17));
    // theLable.setAlignment(Pos.TOP_CENTER);
    theLable.getChildren().addAll(courseNameAndSection,time,day);

    return theLable;

  }
  public static HBox createRigestedCourseLabel(){
    HBox theLable = new HBox();

    theLable.setStyle("-fx-background-color: lightpink;");
    Text courseNameAndSection = new Text("ics108-section1");
    Text time = new Text("7:00");
    Text day = new Text("Sunday");
    // theLable.setTextFill(Paint.valueOf("black"));
    theLable.setPrefSize(160,50);
    // theLable.setFont(new Font("Arial", 17));
    // theLable.setAlignment(Pos.TOP_CENTER);
    theLable.getChildren().addAll(courseNameAndSection,time,day);

    return theLable;

  }


  
}