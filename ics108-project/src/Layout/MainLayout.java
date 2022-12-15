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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
            // FileInputStream fileInputStream = new FileInputStream("savedScedule.dat");
            // ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // Schedule oldSchedule = (Schedule) objectInputStream.readObject();

            // if(schedule.getRegisteredSections()!= null){
            //   schedule.loadOldObject(oldSchedule);
            //   for(Section section: schedule.getRegisteredSections()){
            //     addCourseToPane(section);
            //   }
            //   objectInputStream.close();
            // }


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

            System.out.println(student.getCourseArray().toString());

            

        }
        catch(NullPointerException e){

        }
        // catch(ClassNotFoundException e){
        //   System.out.println(e);
        // }

        catch(FileNotFoundException e){System.out.println(e);}

        // main menu Stage

        // main menue buttons 
        Button degreePlanButton = new Button("Degree Plan");
        Button savedScheduleButton = new Button("Saved Schedule");
        Button newScheduleButton = new Button("New Schedule");
        Button exitButton= new Button("Exist");
        exitButton.setStyle(Styles.backButtonStyle());
    

       degreePlanButton.setTextFill(Color.WHITE);
       savedScheduleButton.setTextFill(Color.WHITE);
       newScheduleButton.setTextFill(Color.WHITE);
      //  exitButton.setTextFill(Color.WHITE);
       degreePlanButton.setStyle("-fx-background-color: Green;");
       savedScheduleButton.setStyle("-fx-background-color: Green;");
       newScheduleButton.setStyle("-fx-background-color: Green;");
      
        
        
        Label text= new Label();
        text.setText("Course offering");
        // Left side vbox
        VBox vbox1= new VBox();
        vbox1.setSpacing(10);
        vbox1.setPadding(new Insets(5,5,5,5));
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(degreePlanButton);
        vbox1.getChildren().add(newScheduleButton);

        // Right side vbox 
        VBox vbox2= new VBox();
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().add(savedScheduleButton);
        vbox2.getChildren().add(exitButton);

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

        BorderPane mainMenuPane= new  BorderPane();
        mainMenuPane.setTop(hbox);
        mainMenuPane.setLeft(vbox1);
        mainMenuPane.setRight(vbox2);

         

        
        
        // To close the window
      

        BorderPane.setAlignment(text, Pos.CENTER);
        

        Scene mainMenu = new Scene(mainMenuPane ,1540,800);
        mainMenu.getWindow();
        // primaryStage.setFullScreen(true);

        primaryStage.setScene(mainMenu);
        primaryStage.show();


        // new Schedule stage 

        Button newScheduleNext = new Button("Next");
        newScheduleButton.setStyle(Styles.nextButtonStyle());
        Button newScheduleBack = new Button("Back");
        newScheduleBack.setStyle(Styles.backButtonStyle());
        HBox item= new HBox();
        item.setSpacing(50);
        item.setPadding(new Insets(5,5,5,5));
        item.setAlignment(Pos.CENTER);

        TextField name = new TextField();
        item.getChildren().addAll(new Label("Enter your name Schedule :"),name);

         
        

        HBox item1= new HBox();
        item1.setSpacing(100);
        item1.setPadding(new Insets(5,5,5,5));
        item1.setAlignment(Pos.CENTER);
        item1.getChildren().addAll(newScheduleNext,newScheduleBack);
        
        VBox item2= new VBox();
        item2.setSpacing(100);
        item2.setPadding(new Insets(5,5,5,5));
        item2.setAlignment(Pos.CENTER);
        item2.getChildren().addAll(item,item1);
        

        //event for name
        name.setOnAction(e->{
             
            //scheduleName = name.getText();
            //come back
        });


        Scene newScheduleScene = new Scene(item2,1540,800);

        // saved schedule
        ///

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
            }
            catch(FileNotFoundException ex){
                System.out.println(ex);
            
        }});


        
        degreePlanBackButton.setMinSize(100, 20);
        Text label =new Text("Degree plan");
        label.setFont(new Font("Arial", 50));



   
   
        

     


        ListView<HBox> showPlanelListView = new ListView<>(createCourseBox(student));
        
        
        // hbox for button
     
        HBox bottomButtonsPane= new HBox();
        bottomButtonsPane.setSpacing(100);
        bottomButtonsPane.setPadding(new Insets(5,5,5,5));
        bottomButtonsPane.setAlignment(Pos.CENTER);
        bottomButtonsPane.getChildren().addAll(degreePlanSaveButton,degreePlanBackButton);
        
        VBox dgreePlanVbox = new  VBox();
        dgreePlanVbox.setSpacing(50);
        dgreePlanVbox.setPadding(new Insets(5,5,5,5));
        dgreePlanVbox.setAlignment(Pos.CENTER);
        dgreePlanVbox.getChildren().addAll(label,showPlanelListView,bottomButtonsPane);


        Scene degreePlanScene = new Scene(dgreePlanVbox,1540,800);
        


        //basket stage

        student.findCanBeTakenCourses();
        student.findCanBeTakenSections();
        
        
       
   
          // Pane used 
          BorderPane borderPane = new BorderPane();
  
  
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
  
          // button functionality
  
  
          // Choice boxes to select department and courses
  
          Label department = new Label("Select Department: "); 
          Label courses = new Label("Select Course: ");
  
          // choice box adjustment 
         ComboBox<String> departmentChoice = new ComboBox<>();
         ComboBox<String> coursesChoice = new ComboBox<>();
  
        
        // events for comboBox
         departmentChoice.getItems().addAll(student.getDepartments());
         
  
         departmentChoice.setOnAction(e-> {
  
      coursesChoice.getItems().removeAll(coursesChoice.getItems());
      coursesChoice.getItems().addAll(student.getCoursesForDepartment(departmentChoice.getValue()));
         });
  
          
  
          
      
          
         
        
      
         
         // actions for basket
         coursesChoice.setOnAction(e-> {
  
  
          student.findShownSections(departmentChoice.getValue(),coursesChoice.getValue());
          ListView<Section> sectionListView = new ListView<Section>(student.getShownSections());
          ListView<Section> basketListView = new ListView<Section>(student.getBasket()) ;
  
          sectionListView.setOnMouseClicked( new EventHandler <MouseEvent>() {
  
              public void handle(MouseEvent e){ 
  
                  student.clickOnSectionList(sectionListView);
                 
                  


              }
              
          });
  
          basketListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
  
              public void handle(MouseEvent e){ 
  
                  student.clickOnBasketList(basketListView);
                  
              }
              
          });
          VBox sectionAndBasket = new VBox(); 
           sectionAndBasket.getChildren().addAll(sectionListView,basketListView); 
           sectionAndBasket.setSpacing(10);
   
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
  
  
          // title
          coursesSelectionBox.setSpacing(100);
          Label header = new Label("Sections' Basket"); 
          header.setFont(new Font("Arial", 30));
          header.setStyle(Styles.green());
  
         
  
          
  
          
  
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
            
           
           
           schedule.setBasketSections(student.getBasket());
           
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
        .text("the course you want to add already exists")
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
    bottomButtonArea.getChildren().addAll(saveScheduleButton,planBackButton);
    
    
    
    BorderPane planStageBorderPane = new BorderPane();
    planStageBorderPane.setStyle("-fx-background-color:  #E8F1F1;");
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
        System.out.println("ha ha");
        FileOutputStream outputStream = new FileOutputStream("savedScedule.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);


        objectOutputStream.writeObject(schedule);
        objectOutputStream.close();
      }
      catch(IOException ex){
        System.out.println(ex.getMessage());
      }

    });

    

    newScheduleButton.setOnAction(e->{
      // ObservableList<Section> observableList = FXCollections.observableArrayList();
      // schedule.setRegisteredSections(observableList);
      // weekDaysPane.getChildren().removeAll();


        primaryStage.setScene(basketScene);
    });

    savedScheduleButton.setOnAction(e->{
        primaryStage.setScene(planScene);

    });

    exitButton.setOnAction(actionEvent -> primaryStage.close());
// want to remove
    newScheduleNext.setOnAction(e->{
      System.out.println("f");

        primaryStage.setScene(basketScene);
    });

// want re remove
    newScheduleBack.setOnAction(e->{


        primaryStage.setScene(mainMenu);
    });

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
        HBox hBox = new HBox(80);
        // hBox.setPrefSize(70,70);
        hBox.setAlignment(Pos.CENTER);
        Label textName = new Label(course.getCourseCode());
        textName.setAlignment(Pos.CENTER);
        textName.prefWidth(500);
        Label Textcridit = new Label(Integer.toString(course.getCredit()));
        Textcridit.prefWidth(500);
        Textcridit.setAlignment(Pos.CENTER);

        Label textpreRequest = new Label(Arrays.toString(course.getPrerequisite()));
        textpreRequest.prefWidth(500);

        textpreRequest.setAlignment(Pos.CENTER);

        Label TextCorerequisite = new Label(Arrays.toString(course.getCorequisite()));
        textpreRequest.prefWidth(500);

        TextCorerequisite.setAlignment(Pos.CENTER);

        Button StatusButton = new Button("Not taken");
        String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"}; 
        ComboBox<String> grades = new ComboBox<>();

        grades.getItems().addAll(grade);


        String[] years= {"222","221","213","212","211","203","202","201"}; 

        ComboBox<String> terms = new ComboBox<>();
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

        hBox.getChildren().addAll(textName,Textcridit,textpreRequest,TextCorerequisite,StatusButton,terms,grades);
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
    theLable.setPrefSize(160,hight);
    
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
  // public static void readWeekdaysPane(Schedule schedule){
  //   for(Section section: schedule.getRegisteredSections()){
  //     addCourseToPane(section);
  //   }

  // }
  
  
  
  
  
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
