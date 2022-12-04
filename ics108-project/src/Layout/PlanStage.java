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
import java.nio.file.FileStore;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Random;

import Data.Schedule;
import Data.Section;
import Data.Student;
import javafx.util.Duration;

public class PlanStage extends Application {
  // Section[] sections = new Section[2];
  static Pane newPane;
  int x = 0;
  int y = 0;
  public void start(Stage primaryStage) {

    //Student  list  have to be here 
    Student student = new Student();
    String[] info5 = {"PHYS101-70","LAB","22041","General Physics I","None","W","0800-1040","None","Closed","Closed"};

    String[] info3 = {"ICS 108-06","LAB","22867","Object-Oriented Programming","RASHAD OTHMAN","MW","1530-1645","22-335","Closed","Open"

  };

    String[] info1 = {"ICS 104-04","LEC","22795","Introduction to Programming in Python and C","S ARAFAT","MW","0900-0950","24-120","Closed","Closed"
    };
    String[] info2 = {"PHYS102-01","REC","20086","General Physics II","RADITYA BOMANTARA","W","0800-0850","59-1005","Open","Closed"
    };
    String[] info4 = {"ICS 104-01","LEC","22785","Introduction to Programming in Python and C","M BALAH","UT","0800-0850","24-120","Closed","Open"
    };


  
    Section sections1 = new Section(info1);
    Section sections2 = new Section(info2);
    Section sections3 = new Section(info3);
    Section section4 = new Section(info4);
    Section section5 = new Section(info5);
    student.addCourse(sections1);
    student.addCourse(sections2);
    student.addCourse(sections3);
    student.addCourse(section5);
    student.addCourse(section4);
    
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
    newPane = new Pane();
    Label aLabel = new Label("ics lab");
    Label asecondLabel = new Label("ics lab");

    aLabel.setStyle(Styles.pink());
    aLabel.setPrefSize(160, 176);
    aLabel.setLayoutX(170+170+170);
    aLabel.setLayoutY(55);
    asecondLabel.setStyle(Styles.green());
    asecondLabel.setPrefSize(160,50);
    asecondLabel.setLayoutX(170);
    asecondLabel.setLayoutY(55+55);
    // newPane.getChildren().addAll(aLabel,asecondLabel);
    // newPane.getChildren().add(createCourseLabel());

    // newPane.getChildren().addAll(aLabel);





    scheduleArea.setCenter(newPane);
    
    VBox selectedCoursesArea = new VBox(5);
    selectedCoursesArea.setPadding(new Insets(15));
    selectedCoursesArea.setPrefWidth(245);
    selectedCoursesArea.setStyle("-fx-background-color: white;");
    Label selectedCoursesText = createLabel("Selected Courses", Styles.white(),15);

    ArrayList<VBox> arrayList = new ArrayList<VBox>();
    for(int i =0; i<student.getBasket().size(); i++){
      arrayList.add(i,createCourseLabel(student.getBasket().get(i)));
    }
    ObservableList<VBox> selectedCourses = FXCollections.observableArrayList(arrayList);



    ListView<VBox> listView = new ListView<VBox>(selectedCourses);
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    Button confirmButton = new Button("confirm");
    // if

    confirmButton.setOnAction(e -> {
      System.out.println("pressed");
      int selctedCourseIndix = listView.getSelectionModel().getSelectedIndex();
      VBox selectedCourse = arrayList.get(selctedCourseIndix);
      // schedule.addSecion(selectedCourse);
      // arrayList.remove(selctedCourseIndix);
      VBox slected = createRigestedCoursePane(student.getBasket().get(selctedCourseIndix));
      addCourseToPane(student.getBasket().get(selctedCourseIndix));

      // slected.setLayoutX(x);
      // slected.setLayoutY(y);

      // 170 for each day
      // 55 for each hour

      // newPane.getChildren().add(slected);
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
  public static VBox createCourseLabel(Section section){
    VBox theLable = new VBox();

    theLable.setStyle("-fx-background-color: lightgreen;");
    Text courseNameAndSection = new Text(section.getCourseName()+"@");
    Text locationText = new Text(section.getLocation());
    Text timeText = new Text(section.getTime());
    Text dayText = new Text(section.getDay());
    // theLable.setTextFill(Paint.valueOf("black"));
    theLable.setPrefSize(150,90);
    // theLable.setFont(new Font("Arial", 17));
    // theLable.setAlignment(Pos.TOP_CENTER);
    theLable.getChildren().addAll(courseNameAndSection,locationText,timeText,dayText);

    return theLable;

  }

  public static VBox createRigestedCoursePane(Section section){
    VBox theLable = new VBox();
    // adding random color
    String[] colors = {"#ed9121","blue","#702963","#7fff00","#ff7f50"};
    Random random = new Random();
    int pickColor = random.nextInt(colors.length);
    theLable.setStyle("-fx-background-color: "+colors[pickColor]+";");

    Text courseNameAndSection = new Text(section.getCourseName());
    courseNameAndSection.setFont(new Font(1));
    Text time = new Text(section.getTime());
    time.setFont(new Font(1));

    // Text day = new Text(section.getDay());
    Button removButton = new Button("remove");

    removButton.setAlignment(Pos.BOTTOM_LEFT);
    removButton.setOnAction(e -> {
      System.out.println("got pressed form ayed");
      newPane.getChildren().remove(theLable);
      
    });


    // theLable.setFont(new Font("Arial", 17));
    // theLable.setAlignment(Pos.TOP_CENTER);
    theLable.getChildren().addAll(courseNameAndSection,time,removButton);

    int hight = (Schedule.readTime(section)*55)/50;
    theLable.setPrefSize(160,hight);
    
    // theLable.setMaxSize(160, hight);
    theLable.setLayoutY(Schedule.readStartTime(section));
    return theLable;

  }

  public static void addCourseToPane(Section section){
    // here we want to check what should we 

    if (section.getDay().equals("MW")){
      VBox first = createRigestedCoursePane(section);  
      first.setLayoutX(170);      
      VBox second = createRigestedCoursePane(section);
      second.setLayoutX(170+170+170);
      newPane.getChildren().addAll(first,second);


    }
    if( section.getDay().equals("W")){
      VBox first = createRigestedCoursePane(section);
      first.setLayoutX(170*3);
      newPane.getChildren().addAll(first);
    }
    if(section.getDay().equals("UT")){
      VBox first  = createRigestedCoursePane(section);

      VBox second = createRigestedCoursePane(section);
      second.setLayoutX(170*2);
      newPane.getChildren().addAll(first,second);
    }
  }

  


  
}