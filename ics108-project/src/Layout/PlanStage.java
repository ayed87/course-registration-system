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
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.nio.file.FileStore;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Random;

import javax.management.Notification;

import org.controlsfx.control.Notifications;

import Data.Schedule;
import Data.Section;
import Data.Student;
import javafx.util.Duration;

public class PlanStage extends Application {
  // Section[] sections = new Section[2];
  static Pane weekDaysPane;
  static ListView<VBox> listView;
  static ObservableList<VBox> selectedCourses;
  static Schedule schedule = new Schedule();


  public void start(Stage primaryStage) {

    //Student  list  have to be here 
    Student student = new Student();
    
    String[] s1 = {"ICS 202-01","LEC","20502","Data Structures and Algorithms","HUSNI AL-MUHTASEB","UTR","0800-0850","22-125","Open","Closed"};
    String[] s2 = {"PHYS101-70","LAB","22041","General Physics I","None","W","0800-1040","None","Closed","Closed"};

    String[] s3 = {"ICS 108-06","LAB","22867","Object-Oriented Programming","RASHAD OTHMAN","MW","1530-1645","22-335","Closed","Open"

  };

    String[] s4 = {"ICS 104-04","LEC","22795","Introduction to Programming in Python and C","S ARAFAT","MW","0900-0950","24-120","Closed","Closed"
    };
    String[] s5 = {"PHYS102-01","REC","20086","General Physics II","RADITYA BOMANTARA","W","0800-0850","59-1005","Open","Closed"
    };
    String[] s6 = {"ICS 104-01","LEC","22785","Introduction to Programming in Python and C","M BALAH","UT","0800-0850","24-120","Closed","Open"
    };
    String[] s7 = {"ICS 104-60","LAB","22822","Introduction to Programming in Python and C","None","W","0800-1040","23-077","Closed","Closed"
    };


    Section sec6 = new Section(s1);
  
    Section sec2 = new Section(s2);
    Section sec3 = new Section(s3);
    Section sec4 = new Section(s4);
    Section sec5 = new Section(s5);
    Section sec1 = new Section(s6);
    Section sec7 = new Section(s7);

    student.addCourse(sec1);
    student.addCourse(sec2);
    student.addCourse(sec3);
    student.addCourse(sec4);
    student.addCourse(sec5);
    student.addCourse(sec6);
    student.addCourse(sec7);
    
    schedule.setBasketSections(student.getBasket());

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
    weekDaysPane = new Pane();


    scheduleArea.setCenter(weekDaysPane);
    
    VBox selectedCoursesArea = new VBox(5);
    selectedCoursesArea.setPadding(new Insets(15));
    selectedCoursesArea.setPrefWidth(245);
    selectedCoursesArea.setStyle("-fx-background-color: white;");
    Label selectedCoursesText = createLabel("Selected Courses", Styles.white(),15);
    
    selectedCourses = schedule.createVboxSections();



    listView = new ListView<VBox>(selectedCourses);
    // listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    Button confirmButton = new Button("confirm");
    // if

    confirmButton.setOnAction(e -> {
      System.out.println("pressed");
      int selctedCourseIndix = listView.getSelectionModel().getSelectedIndex();
      Section selectedSection = student.getBasket().get(selctedCourseIndix);
      System.out.println(selectedSection);
      if(!schedule.checkExistence(selectedSection)){
        
        if(schedule.checkConflict(selectedSection)){
          schedule.addCourse(selectedSection);
          student.removeCourse(selectedSection);
          addCourseToPane(selectedSection);
          listView.getItems().removeAll(listView.getSelectionModel().getSelectedItem
          ());
  
  
        }
        else{
          // System.out.println("there is a conflict problem");
           Notifications.create()
                .title("Error")
                .text("There is a conflict")
                .showWarning();
  
  
     
        }
      }
      else{
        Notifications.create()
        .title("Error")
        .text("the course you want to add is already existant")
        .showWarning();
      }







      // 170 for each day
      // 55 for each hour


      
      




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
    Text codText = new Text(section.getSectionCode());

    Text locationText = new Text(section.getLocation());
    Text timeText = new Text(section.getTime());
    Text dayText = new Text(section.getDay());
    // theLable.setTextFill(Paint.valueOf("black"));
    theLable.setPrefSize(150,90);
    // theLable.setFont(new Font("Arial", 17));
    // theLable.setAlignment(Pos.TOP_CENTER);
    theLable.getChildren().addAll(courseNameAndSection,codText,locationText,timeText,dayText);

    return theLable;

  }

  public static VBox createRigestedCoursePane(Section section){
    VBox theLable = new VBox();

    // {"#ed9121","blue","#702963","#7fff00","#ff7f50"}
    // adding random color
    String[] colors = {"white","white","white","white","white"};
    Random random = new Random();
    int pickColor = random.nextInt(colors.length);
    theLable.setStyle("-fx-background-color: "+colors[pickColor]+";");

    

    Text courseNameAndSection = new Text(section.getSectionCode()+"@"+section.getLocation());
    Text instructorText = new Text(section.getInstructor());

    theLable.getChildren().addAll(courseNameAndSection,instructorText);

    int hight = (section.getLectureDuration()*50)/55;
    theLable.setPrefSize(160,hight);
    
    theLable.setLayoutY(section.setStartPostion());
    return theLable;

  }

  public static void addCourseToPane(Section section){
    // here we want to check what should we 
    // if the type of day was UTR
    if(section.getDay().equals("UTR")){
      VBox first,second,third;
      first = createRigestedCoursePane(section);
      second = createRigestedCoursePane(section);
      third = createRigestedCoursePane(section);
      // the function of buttons.. 
      Button removeButton1 = createRemoveButton(e->{
        weekDaysPane.getChildren().removeAll(first,second,third);
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        


        
        
        
      });
      first.getChildren().add(removeButton1);

      Button removeButton2 = createRemoveButton(e->{
        weekDaysPane.getChildren().removeAll(first,second,third);
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        

        
      });

      second.getChildren().add(removeButton2);
      second.setLayoutX(2*170);

      Button removeButton3 = createRemoveButton(e->{
        weekDaysPane.getChildren().addAll(first,second,third);
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        
      });

      third.getChildren().add(removeButton3);
      third.setLayoutX(4*170);

      

      weekDaysPane.getChildren().addAll(first,second,third);
    }






    // if the day was MW we have to care about 2 Vbox
    else if (section.getDay().equals("MW")){
      VBox first, second;
      first = createRigestedCoursePane(section);  
      first.setLayoutX(170);      
      second = createRigestedCoursePane(section);
      second.setLayoutX(170*3);
      Button removeButton1 = createRemoveButton(e -> {
        System.out.println("got pressed form ayed");
        weekDaysPane.getChildren().removeAll(first,second);
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        
      });

      Button removeButton2 = createRemoveButton(e -> {
        System.out.println("got pressed form ayed");
        weekDaysPane.getChildren().removeAll(first,second);
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        
      });

  


      first.getChildren().add(removeButton1);
      second.getChildren().add(removeButton2);

      weekDaysPane.getChildren().addAll(first,second);




    }
    else if(section.getDay().equals("UT")){
      VBox first  = createRigestedCoursePane(section);
      VBox second = createRigestedCoursePane(section);
      Button removeButton1 = createRemoveButton(e->{
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);

        weekDaysPane.getChildren().removeAll(first,second);
      });
      first.getChildren().add(removeButton1);

      Button removeButton2 = createRemoveButton(e->{
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        weekDaysPane.getChildren().removeAll(first,second);
      });
      second.getChildren().add(removeButton2);


      second.setLayoutX(170*2);
      weekDaysPane.getChildren().addAll(first,second);
    }




    else if( section.getDay().equals("U")){
      VBox first = createRigestedCoursePane(section);
      Button removButton = createRemoveButton(e-> {
        System.out.println("got pressed form ayed");
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        weekDaysPane.getChildren().removeAll(first);
      });

      first.getChildren().add(removButton);

      
      weekDaysPane.getChildren().addAll(first);

      
    }
    else if( section.getDay().equals("M")){
      VBox first = createRigestedCoursePane(section);
      Button removButton = createRemoveButton(e-> {
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        System.out.println("got pressed form ayed");

        weekDaysPane.getChildren().removeAll(first);
      });
      first.getChildren().add(removButton);

      
      first.setLayoutX(170);

      weekDaysPane.getChildren().addAll(first);

      
    }
    else if( section.getDay().equals("T")){
      VBox first = createRigestedCoursePane(section);
      Button removButton = createRemoveButton(e-> {
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        System.out.println("got pressed form ayed");
        weekDaysPane.getChildren().removeAll(first);
        section.toString();
      });
      first.getChildren().add(removButton);

      
      first.setLayoutX(170*2);
      weekDaysPane.getChildren().addAll(first);

      
    }
    else if( section.getDay().equals("W")){
      VBox first = createRigestedCoursePane(section);
      Button removButton = createRemoveButton(e-> {
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        System.out.println("got pressed form ayed");
        weekDaysPane.getChildren().removeAll(first);
        section.toString();
      });
      first.getChildren().add(removButton);

      
      first.setLayoutX(170*3);
      weekDaysPane.getChildren().addAll(first);

      
    }
    else if( section.getDay().equals("R")){
      VBox first = createRigestedCoursePane(section);
      Button removButton = createRemoveButton(e-> {
        schedule.removeCourse(section);
        schedule.retrunToBasket(section);
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        System.out.println("got pressed form ayed");
        weekDaysPane.getChildren().removeAll(first);
        section.toString();
      });
      first.getChildren().add(removButton);

      
      first.setLayoutX(170*4);
      weekDaysPane.getChildren().addAll(first);

      
    }
    


  }
  
  
  
  
  
  public static Button createRemoveButton(EventHandler<ActionEvent> onPress){
    Button removButton = new Button();
    removButton.setGraphic(new ImageView(new Image("/resources/deleteButton.png", 10, 10, true, true)));
    removButton.setBackground(null);
    removButton.setMinSize(15, 7);
    removButton.setMaxSize(15, 7);

    removButton.setOnAction(onPress); 

    return removButton;
    
  }

  


  
}