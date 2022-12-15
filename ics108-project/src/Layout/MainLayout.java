package Layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import Data.Course;
import Data.FinishedCourse;
import Data.Schedule;
import Data.Section;
import Data.Student;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.ExpandVetoException;

import org.controlsfx.control.Notifications;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainLayout extends Application {
    Student student = new Student(); 
    static  Pane weekDaysPane = new Pane();
    static ListView<VBox> listView;
    static ObservableList<VBox> selectedCourses;
    static Schedule schedule = new Schedule();
    Schedule oldSchedule;


    @Override
    public void start(Stage primaryStage) throws Exception {


        try{



            // reading files and creating objects for sections, courses in degree plan, finished courses
            FileReader courseOffering = new FileReader("CourseOffering.csv");
            FileReader degreePlan = new FileReader("DegreePlan.csv");
            FileReader finishedCourses = new FileReader("FinishedCourses.csv");
            

            BufferedReader courseOfferingReader = new BufferedReader(courseOffering);
            BufferedReader degreePlanReader = new BufferedReader(degreePlan); 
            BufferedReader finishedCoursesReader = new BufferedReader(finishedCourses);

           

            student.readAllSections(courseOfferingReader);
            student.readAllCourse(degreePlanReader);
            student.readAllFinishedCourses(finishedCoursesReader);

            

            

        }
        

        catch(FileNotFoundException e){System.out.println(e);}
        


        // main menu Stage

        // main menue buttons 
        Button degreePlanButton = new Button("Degree Plan");
        Button savedScheduleButton = new Button("Saved Schedule");
        Button newScheduleButton = new Button("New Schedule");
        Button exitButton= new Button("Exist");
        

        degreePlanButton.setPrefSize(150, 80);
        savedScheduleButton.setPrefSize(150, 80);
        newScheduleButton.setPrefSize(150, 80);
        exitButton.setPrefSize(150, 80);
        exitButton.setStyle(Styles.backButtonStyle());
        degreePlanButton.setStyle(Styles.buttonsStyle());
        savedScheduleButton.setStyle(Styles.buttonsStyle());
        newScheduleButton.setStyle(Styles.buttonsStyle());
      
    

       degreePlanButton.setTextFill(Color.WHITE);
       savedScheduleButton.setTextFill(Color.WHITE);
       newScheduleButton.setTextFill(Color.WHITE);
      //  exitButton.setTextFill(Color.WHITE);

      // we will use some of the part
      //  degreePlanButton.setStyle("-fx-background-color: Green;");
      //  savedScheduleButton.setStyle("-fx-background-color: Green;");
      //  newScheduleButton.setStyle("-fx-background-color: Green;");
      
        
        
        Label text= new Label();
        text.setText("Course offering");
        // Left side vbox
        VBox vbox1= new VBox();
        vbox1.setSpacing(100);
        vbox1.setPadding(new Insets(5,5,5,5));
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(degreePlanButton);
        vbox1.getChildren().add(newScheduleButton);

        // Right side vbox 
        VBox vbox2= new VBox();
        vbox2.setSpacing(100);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().add(savedScheduleButton);
        vbox2.getChildren().add(exitButton);

        // Top hbox




        HBox mainMenuPane = new HBox(100);
        mainMenuPane.setStyle(Styles.mainStyleDark());
        mainMenuPane.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(mainMenuPane, Pos.CENTER);
        mainMenuPane.getChildren().addAll(vbox1,vbox2);


         

        
        
        // To close the window
      

        

        Scene mainMenu = new Scene(mainMenuPane ,1540,800);
        mainMenu.getWindow();
        // primaryStage.setFullScreen(true);

        primaryStage.setScene(mainMenu);
        primaryStage.show();




        // degree plan
        Button degreePlanSaveButton = new Button("Save");
        degreePlanSaveButton.setStyle(Styles.saveButtonStyle());
        Button degreePlanBackButton = new Button("Back");
        degreePlanBackButton.setStyle(Styles.backButtonStyle());
        
    


        // save button 
        degreePlanSaveButton.setMinSize(100, 20);
        degreePlanSaveButton.setOnAction(e->{
            try{

           
                File file =new File("FinishedCourses.csv");
                PrintWriter output=new PrintWriter(file);
                output.println("Course , term , grade");
                for(FinishedCourse finishedCourse: student.getFinishedCourses()){
                    output.println(finishedCourse);
                }
                output.close();
                 
                  FileReader finishedCourses = new FileReader("FinishedCourses.csv");

                  BufferedReader finishedCoursesReader = new BufferedReader(finishedCourses);
      
                  student.updateFinishedCourses(finishedCoursesReader);

                  student.updateCanBeTakenCourses();
                  student.updateCanBeTakenSections();
      
                  
      
                  
      
              

                

                           
              
                
            }
            catch(FileNotFoundException ex){
                System.out.println(ex);
            
        }});


        
        degreePlanBackButton.setMinSize(100, 20);
        Text label =new Text("Degree plan");
        label.setFont(new Font("Arial", 30));        

     


        ListView<HBox> showPlanelListView = new ListView<>(createCourseBox(student));
        
        
        // hbox for button

        HBox topDiscrption = new HBox(123);
        topDiscrption.setAlignment(Pos.CENTER);
        topDiscrption.getChildren().addAll(
          new Text("course name"),
          new Text("cridits"),
          new Text("pre requiset"),
          new Text("core requiset"),
          new Text("status"),
          new Text("term"),
          new Text("grade")
        );
     
        HBox bottomButtonsPane= new HBox();
        bottomButtonsPane.setSpacing(100);
        bottomButtonsPane.setPadding(new Insets(5,5,5,5));
        bottomButtonsPane.setAlignment(Pos.CENTER);
        bottomButtonsPane.getChildren().addAll(degreePlanSaveButton,degreePlanBackButton);
        
        VBox dgreePlanVbox = new  VBox();
        dgreePlanVbox.setStyle(Styles.mainStyleDark());
        dgreePlanVbox.setSpacing(30);
        dgreePlanVbox.setPadding(new Insets(5,5,5,5));
        dgreePlanVbox.setAlignment(Pos.CENTER);
        dgreePlanVbox.getChildren().addAll(label,topDiscrption,showPlanelListView,bottomButtonsPane);


        Scene degreePlanScene = new Scene(dgreePlanVbox,1540,800);
        


        //basket stage Code

        // finding Can be taken courses and sections
        student.findCanBeTakenCourses();
        student.findCanBeTakenSections();
        
        
       
   
          // Pane used 
          BorderPane borderPane = new BorderPane();
          borderPane.setStyle(Styles.mainStyle());
  
  
          // Buttons to move between scenes
          Button basketPreviousButton = new Button("Previous");
          basketPreviousButton.setStyle(Styles.backButtonStyle());
          Button basketNextButton =new Button("Next"); 
          basketNextButton.setStyle(Styles.nextButtonStyle());
  
          basketPreviousButton.setMinSize(100, 20);
          basketNextButton.setMinSize(100, 20);
          HBox hBox = new HBox(); 
          hBox.getChildren().addAll(basketPreviousButton,basketNextButton); 
          hBox.setSpacing(100);
          hBox.setAlignment(Pos.CENTER);
          borderPane.setBottom(hBox);
  
         
  
  
          // Choice boxes to select department and courses
  
          Label department = new Label("Select Department: "); 
          Label courses = new Label("Select Course: ");
  
          // choice box adjustment 
         ComboBox<String> departmentChoice = new ComboBox<>();
         ComboBox<String> coursesChoice = new ComboBox<>();
  
        
        // events for comboBoxes
         departmentChoice.getItems().addAll(student.getDepartments());
         
  
         departmentChoice.setOnAction(e-> {
  
      coursesChoice.getItems().removeAll(coursesChoice.getItems());
      coursesChoice.getItems().addAll(student.getCoursesForDepartment(departmentChoice.getValue()));
         });
  
          
  
          
      
          
         
        
      
         
         
         coursesChoice.setOnAction(e-> {
  
  
          // sections basket 
          student.findShownSections(departmentChoice.getValue(),coursesChoice.getValue());
          ListView<Section> sectionListView = new ListView<Section>(student.getShownSections());
          ListView<Section> basketListView = new ListView<Section>(student.getBasket()) ;
  
          sectionListView.setOnMouseClicked( new EventHandler <MouseEvent>() {
  
            // basket sections selections and updating 
              public void handle(MouseEvent e){ 
  
                  student.clickOnSectionList(sectionListView);
                 
                  


              }
              
          });
  

          basketListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
  
              public void handle(MouseEvent e){ 
  
                  student.clickOnBasketList(basketListView);
                  
              }
              
          });

          // layout for the baskets 
          VBox sectionAndBasket = new VBox(); 

          Label sectionsLabel = new Label("Available Sections List");
          sectionsLabel.setFont(new Font("Arial", 20));
          Label sectionTaken = new Label("Choosen Sections");
          sectionTaken.setFont(new Font("Arial", 20));
           sectionAndBasket.getChildren().addAll(sectionsLabel ,sectionListView,sectionTaken, basketListView); 
           sectionAndBasket.setSpacing(20);
           sectionAndBasket.setAlignment(Pos.CENTER);
          
   
          borderPane.setCenter(sectionAndBasket);
  
          
         });
  
        
        
  
         
          departmentChoice.setPrefSize(100,10);
          coursesChoice.setPrefSize(100, 10);
  
  
  
          HBox departmentBox = new HBox(); 
  
          departmentBox.getChildren().addAll(department,departmentChoice);
  
          departmentBox.setSpacing(10);
  
          HBox courseBox = new HBox(); 
  
          courseBox.getChildren().addAll(courses,coursesChoice);
          
          courseBox.setSpacing(38);
  
          HBox coursesSelectionBox = new HBox(); 
  
          coursesSelectionBox.getChildren().addAll(departmentBox,courseBox);

          coursesSelectionBox.setPadding(new Insets(15));
  
  
          // title
          coursesSelectionBox.setSpacing(100);
          Label header = new Label("Sections' Basket"); 
          header.setFont(new Font("Arial", 30));
          // header.setStyle(Styles.green());
  
         
  
          
  
          
  
          // title 
          VBox topPart = new VBox(); 
          topPart.getChildren().addAll(header,coursesSelectionBox);
          topPart.setAlignment(Pos.CENTER);
          topPart.setSpacing(40);
          borderPane.setTop(topPart);
  
  
          // courses select list, need more improvement
          ScrollPane listScroll = new ScrollPane();
          listScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
  
          ObservableList<String> books = FXCollections.observableArrayList(" Section 1   ICS108  UTR  7:00 - 7:50");
          ListView<String> sectionListView = new ListView<String>(books);
  
          listScroll.setContent(sectionListView);
  
         
          listScroll.setFitToWidth(true);
         

           Scene basketScene = new Scene(borderPane,1540,800);

           // plan stage 
            
           
           
           
           Button saveScheduleButton = new Button("Save Schedule");
           saveScheduleButton.setStyle(Styles.saveButtonStyle());
           Button planBackButton = new Button("go back");
           planBackButton.setStyle(Styles.backButtonStyle());
           planBackButton.setOnAction(e->{
            primaryStage.setScene(basketScene);
           });
           BorderPane scheduleArea = new BorderPane();
           
           
           scheduleArea.setPadding(new Insets(4));
    


           HBox top = new HBox(8);
           top.setAlignment(Pos.CENTER_RIGHT);
    
        top.getChildren().addAll(
      // createCourseLabel(),
       createLabel("Sun ",Styles.daysStyle(),15)
      , createLabel("Mom",Styles.daysStyle(),15)
      , createLabel("Tue",Styles.daysStyle(),15)
      , createLabel("Wed",Styles.daysStyle(),15)
      , createLabel("thurs",Styles.daysStyle(),15)
      , createLabel("Fri",Styles.daysStyle(),15)
      , createLabel("Sat",Styles.daysStyle(),15)
    
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
    
    // weekDaysPane = new Pane();
    weekDaysPane.setStyle("-fx-background-color: #D7F4F4;");
    weekDaysPane.setMaxHeight(601);
    


    // weekDaysPane.setStyle(Styles.blue());
    // weekDaysPane.setMaxHeight(601);
    VBox sizedBox = new VBox();
    Pane emptyPane = new Pane();

    sizedBox.getChildren().addAll(weekDaysPane,emptyPane);

    scheduleArea.setCenter(weekDaysPane);
    scheduleArea.setAlignment(weekDaysPane, Pos.TOP_CENTER);
    

    
    
    VBox selectedCoursesArea = new VBox(5);
    selectedCoursesArea.setPadding(new Insets(15));
    selectedCoursesArea.setPrefWidth(245);
    selectedCoursesArea.setStyle("-fx-background-color: #BCD7D7;");
    Label selectedCoursesText = createLabel("Selected Courses", Styles.v(),15);
    
    
    selectedCourses = schedule.createVboxSections();



    listView = new ListView<VBox>(selectedCourses);
    // listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    Button confirmButton = new Button("confirm");
    confirmButton.setStyle(Styles.saveButtonStyle());
    // if

    confirmButton.setOnAction(e -> {
      try{
        System.out.println("pressed");
        int selctedCourseIndix = listView.getSelectionModel().getSelectedIndex();
        Section selectedSection = schedule.getBasketSections().get(selctedCourseIndix);
        System.out.println(selectedSection);
        if(!schedule.checkExistence(selectedSection)){
          
          if(schedule.checkConflict(selectedSection)){
            schedule.addRigesterdCourse(selectedSection);
            schedule.removeCourseFromBasket(selectedSection);
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
          .text("the course you want to add already exists")
          .showWarning();
        }
      }catch(Exception ex){
        System.out.println(ex);
        
      }




      // 170 for each day
      // 55 for each hour



    });
    



    selectedCoursesArea.getChildren().addAll(selectedCoursesText,listView,confirmButton);
    
    //adding the buttons at the bottom

    HBox bottomButtonArea  = new HBox();
    bottomButtonArea.setSpacing(15);
    bottomButtonArea.setAlignment(Pos.CENTER);
    bottomButtonArea.getChildren().addAll(saveScheduleButton,planBackButton);
    
    
    
    BorderPane planStageBorderPane = new BorderPane();
    planStageBorderPane.setStyle(Styles.mainStyleDark());
    planStageBorderPane.setPadding(new Insets(15));

    planStageBorderPane.setCenter(scheduleArea);
    // planStageBorderPane.setAlignment(weekDaysPane, Pos.TOP_CENTER);
    planStageBorderPane.setRight(selectedCoursesArea);
    planStageBorderPane.setBottom(bottomButtonArea);
    Scene planScene = new Scene(planStageBorderPane, 1540, 800);



    // connecting the scenes 

    degreePlanButton.setOnAction(e->{ 

        primaryStage.setScene(degreePlanScene);
    });

    degreePlanBackButton.setOnAction(e->{ 

      
        primaryStage.setScene(mainMenu);

        
    });

    //saving schudel 
    saveScheduleButton.setOnAction(e->{
      try{
        System.out.println("file was saved");
        Notifications.create()
        .title("")
        .text("file was saved")
        .showWarning();
        FileOutputStream outputStream = new FileOutputStream("savedScedule.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);


        objectOutputStream.writeObject(schedule);
        objectOutputStream.close();
      }
      catch(IOException ex){
        System.out.println(ex);
      }

    });

    

    newScheduleButton.setOnAction(e->{
      // ObservableList<Section> observableList = FXCollections.observableArrayList();
      // schedule.setRegisteredSections(observableList);
      // weekDaysPane.getChildren().removeAll();

      schedule.clear();
      weekDaysPane.getChildren().clear();


        primaryStage.setScene(basketScene);
    });

    savedScheduleButton.setOnAction(e->{
      try{
        FileInputStream fileInputStream = new FileInputStream("savedScedule.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Schedule oldSchedule = (Schedule) objectInputStream.readObject();

        if(schedule.getRegisteredSections()!= null){
          schedule.loadOldObject(oldSchedule);
          for(Section section: schedule.getRegisteredSections()){
            addCourseToPane(section);
          }
          objectInputStream.close();
          Notifications.create()
          .title("")
          .text("secdule is loaded ")
          .showWarning();
        }
        // you need to up date the vbox again
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
        listView.getItems().clear();

        primaryStage.setScene(planScene);
      }
      catch(IOException ex){


      }
      catch(ClassNotFoundException ex){

      }


    });

    exitButton.setOnAction(actionEvent -> primaryStage.close());

// want to remove


    basketPreviousButton.setOnAction(e->{

        primaryStage.setScene(mainMenu);
    });

    basketNextButton.setOnAction(e->{

         schedule.setBasketSections(student.getBasket());
        primaryStage.setScene(planScene);
        schedule.setBasketSections(student.getBasket());
        selectedCourses = schedule.createVboxSections();
        listView.setItems(selectedCourses);
    });





    

    





        
        
    }

   public static void main(String[] args) {
    launch(args);
   }

   public static ObservableList<HBox> createCourseBox (Student student){
    ObservableList<HBox> finalResult = FXCollections.observableArrayList();

    for(Course course: student.getCourseArray()){
        HBox hBox = new HBox(100);
        hBox.setStyle(Styles.mainStyle());
        // hBox.setStyle(Styles.blue());
        hBox.setPrefHeight(90);
        // hBox.setPrefSize(70,70);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        Text textName = new Text(course.getCourseCode());
        // textName.setStyle(Styles.blue());
        Pane paneText = new Pane();
        paneText.setPrefSize(90, 90);


        // textName.setAlignment(Pos.CENTER_LEFT);
        // textName.setMaxWidth(40);
        paneText.getChildren().add(textName);
        Label Textcridit = new Label(Integer.toString(course.getCredit()));
        Textcridit.setMaxWidth(40);
        // Textcridit.setAlignment(Pos.CENTER);
        VBox textpreRequest = new VBox();
        textpreRequest.setStyle(Styles.mainStyle());
        textpreRequest.setPrefSize(90, 90);


        // textpreRequest.setAlignment(Pos.CENTER);
        for(String pre :course.getPrerequisite()){
          Text text = new Text(pre);
          textpreRequest.getChildren().add(text);
        }
        textpreRequest.setMaxWidth(180);
        
        

        // textpreRequest.setAlignment(Pos.CENTER);
        VBox textCorerequisite = new VBox();
        textCorerequisite.setStyle(Styles.mainStyle());
        textCorerequisite.setPrefSize(90, 90);


        // textpreRequest.setAlignment(Pos.CENTER);
        for(String pre :course.getCorequisite()){
          Text text = new Text(pre);
          textCorerequisite.getChildren().add(text);
        }
        textCorerequisite.setMaxWidth(180);

        

        // TextCorerequisite.setAlignment(Pos.CENTER);

        Button StatusButton = new Button("Not taken");
        String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"}; 
        ComboBox<String> grades = new ComboBox<>();
        // grades.setPrefSize(90, 90);

        grades.getItems().addAll(grade);


        String[] years= {"222","221","213","212","211","203","202","201"}; 

        ComboBox<String> terms = new ComboBox<>();
        // terms.setPrefSize(90, 90);

        terms.getItems().addAll(years);
        

        for(int i= 0 ; i< student.getFinishedCourses().size(); i++ ){ 


            //System.out.println(course.getCourseCode().equals(student.getFinishedCourses().get(i).getCourseCode()));


            if(course.getCourseCode().equals(student.getFinishedCourses().get(i).getCourseCode())){
                System.out.println(course.getCourseCode());
                StatusButton.setText("Taken");
                terms.setValue(student.getFinishedCourses().get(i).getTakenSemester());
                grades.setValue(student.getFinishedCourses().get(i).getGrade());
                

            }

        }

        




        
        
        
        //checkBox.setDisable(!(grades.getSelectionModel().getSelectedItem()!=null &&terms.getSelectionModel().getSelectedItem()!=null));
        StatusButton.setOnAction(e->{

            if(StatusButton.getText().equals("Not taken")){
            String term = terms.getSelectionModel().getSelectedItem();
            String takenGrade = grades.getSelectionModel().getSelectedItem();
          

            String[] courseInformation = {course.getCourseCode() ,term,takenGrade};
            FinishedCourse finishedCourse = new FinishedCourse(courseInformation);
            student.addFinshedCourse(finishedCourse);
            StatusButton.setText("taken");

            }

            else{

                for(int i= 0 ; i< student.getFinishedCourses().size(); i++ ){ 


                    //System.out.println(course.getCourseCode().equals(student.getFinishedCourses().get(i).getCourseCode()));
    
    
                    if(course.getCourseCode().equals(student.getFinishedCourses().get(i).getCourseCode())){
    
                        StatusButton.setText("Not taken");
                        student.removeFinshedCourse(student.getFinishedCourses().get(i));

                    
                        
                        
    
                    }
    
                }


            }
            

        });
        

        // course: MATH101   Credits : 4 

        hBox.getChildren().addAll(paneText,Textcridit,textpreRequest,textCorerequisite,StatusButton,terms,grades);
        finalResult.add(hBox);


    }
    return finalResult;
}
public static Label createLabel(String text, String style,double size){
    Label theLable = new Label(text);
    theLable.setStyle(style);
    theLable.setPrefSize(161,50);
    theLable.setFont(new Font("Arial", size));

    theLable.setAlignment(Pos.CENTER);

    return theLable;

  }
  public static Label createTimeLabel(String text){
    Label theLable = new Label(text);
    theLable.setStyle("-fx-background-color: #113E3E; -fx-text-fill: white;");
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



    

    Text courseNameAndSection = new Text(section.getSectionCode()+"@"+section.getLocation());
    Text instructorText = new Text(section.getInstructor());
    courseNameAndSection.setFill(Paint.valueOf("white"));;
    instructorText.setFill(Paint.valueOf("white"));

    theLable.getChildren().addAll(courseNameAndSection,instructorText);

    int hight = (section.getLectureDuration()*50)/55;
    theLable.setMaxHeight(hight);
    theLable.setMaxWidth(160);


    
    theLable.setLayoutY(section.setStartPostion());
    return theLable;

  }

  public static void addCourseToPane(Section section){

    String chosedColor = Styles.pickColor();
    // here we want to check what should we 
    // if the type of day was UTR
    if(section.getDay().equals("UTR")){
      VBox first,second,third;
      first = createRigestedCoursePane(section);
      second = createRigestedCoursePane(section);
      third = createRigestedCoursePane(section);
      first.setStyle(chosedColor);
      second.setStyle(chosedColor);
      third.setStyle(chosedColor);

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
        weekDaysPane.getChildren().removeAll(first,second,third);
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
      first.setStyle(chosedColor);
      second.setStyle(chosedColor);

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
      first.setStyle(chosedColor);
      second.setStyle(chosedColor);

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
      first.setStyle(chosedColor);
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
      first.setStyle(chosedColor);
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
      first.setStyle(chosedColor);
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
      first.setStyle(chosedColor);
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
      first.setStyle(chosedColor);
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
  /// to read all the old data
  public static void readWeekdaysPane(Schedule schedule){
    for(Section section: schedule.getRegisteredSections()){
      addCourseToPane(section);
    }

  }
  
  
  
  
  
  public static Button createRemoveButton(EventHandler<ActionEvent> onPress){
    Button removButton = new Button();
    removButton.setGraphic(new ImageView(new Image("/resources/del.png", 10, 10, true, true)));
    removButton.setBackground(null);
    removButton.setMinSize(15, 7);
    removButton.setMaxSize(15, 7);

    removButton.setOnAction(onPress); 

    return removButton;
    
  }

    
    
}
