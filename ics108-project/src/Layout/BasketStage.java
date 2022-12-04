package Layout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.Section;
import Data.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BasketStage extends Application {
    
    public void start(Stage primaryStage) {

        // reading files 

        Student student = new Student(); 
        

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

       
      student.findCanBeTakenCourses();
      student.findCanBeTakenSections();
      
     
 
        // Pane used 
        BorderPane borderPane = new BorderPane();


        // Buttons to move between scenes
        Button previous = new Button("Previous");
        Button next =new Button("Next"); 

        previous.setMinSize(100, 20);
        next.setMinSize(100, 20);
        HBox hBox = new HBox(); 
        hBox.getChildren().addAll(previous,next); 
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

        sectionListView.setOnMouseClicked( new EventHandler<MouseEvent>() {

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
       

        

        
        



        


        Scene scene1 = new Scene(borderPane,1000,500);

        primaryStage.setScene(scene1);
        primaryStage.show();



        
    }

    public static void main(String[] args) {
        
        launch(args);
    }

   
    
}
