package Layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

import Data.Student;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Parent;


public class Degree extends Application{
    Button b6 = new Button("Next");
    Button b7 = new Button("Back");
    Button b8 = new Button("Show the flowchart");
    public void start(Stage primaryStage)  {
        
        b6.setMinSize(100, 20);
        b7.setMinSize(100, 20);
        b8.setMinSize(100, 20);
        Text label =new Text("Degree plan");
        label.setFont(new Font("Arial", 50));
        CheckBox taken= new CheckBox("Taken");

     //Reading file 



   
   
    Student student1 = new Student(); 
        

     try{ 

       

        FileReader degreePlan = new FileReader("DegreePlan.csv");
        BufferedReader degreePlanReader = new BufferedReader(degreePlan);

        

         
        student1.readAllCourse(degreePlanReader);
         

     }

     catch(FileNotFoundException e){System.out.println(e);}








       



        // vbox for class
        VBox vbox2= new VBox();
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(new Label("Courses"),new Label("ics108"));
        

        // credit 
        VBox vbox3= new VBox();
        vbox3.setSpacing(10);
        vbox3.setPadding(new Insets(5,5,5,5));
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().addAll(new Label("Credit"),new Label("4"));
         
        
        // corequisite
         VBox vbox5= new VBox();
         vbox5.setSpacing(10);
         vbox5.setPadding(new Insets(5,5,5,5));
         vbox5.setAlignment(Pos.CENTER);
         vbox5.getChildren().addAll(new Label("corequisite"),new Label("n"));
 
        

        //prerequisite 
        VBox vbox4= new VBox();
        vbox4.setSpacing(10);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(new Label("prerequisite "),new Label("c "));





         //checkbox
         VBox vbox6= new VBox();
         vbox6.setSpacing(10);
         vbox6.setPadding(new Insets(5,5,5,5));
         vbox6.setAlignment(Pos.CENTER);
         vbox6.getChildren().addAll(new Label("Taken Courses"),taken);
         

        // Grades for the course 
         String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"}; 
         ComboBox<String> grades = new ComboBox<>();


         grades.getItems().addAll(grade);

         grades.setOnAction(e-> {}
         );

         //checkbox grades
         VBox vbox7= new VBox();
         vbox7.setSpacing(10);
         vbox7.setPadding(new Insets(5,5,5,5));
         vbox7.setAlignment(Pos.CENTER);
         vbox7.getChildren().addAll(new Label("Grades"),grades);
         

      
         // events for comboBox
          
   
        
   
        //// Grades for the course 
         String[] years= {"222","221","213","212","211","203","202","201"}; 
         ComboBox<String> terms = new ComboBox<>();

      
        
         terms.getItems().addAll(years);

         //checkbox grades
         VBox vbox8= new VBox();
         vbox8.setSpacing(10);
         vbox8.setPadding(new Insets(5,5,5,5));
         vbox8.setAlignment(Pos.CENTER);
         vbox8.getChildren().addAll(new Label("Term"),terms);
        
        
        
        
         // events for comboBox
          terms.getItems().addAll(years);
          
   
          grades.setOnAction(e-> {}
          );
   
        //


        HBox parts= new HBox();
        parts.setSpacing(200);
        parts.setPadding(new Insets(5,5,5,5));
        parts.setAlignment(Pos.CENTER);
        parts.getChildren().addAll(vbox2,vbox3,vbox4,vbox5,vbox6,vbox7,vbox8);


        ScrollPane  scrollPane= new ScrollPane(parts);
        
    grades.setDisable(true) ;
    terms.setDisable(true);
    
    // event for checkbox taken
    taken.setOnAction(e ->{ grades.setDisable(false) ;terms.setDisable(false);

    });

        // hbox for button
        HBox buttonClick= new HBox();
        buttonClick.setSpacing(100);
        buttonClick.setPadding(new Insets(5,5,5,5));
        buttonClick.setAlignment(Pos.CENTER);
        buttonClick.getChildren().addAll(b6,b7,b8);
        

        
      
        
        //String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"}; 
        
        
        
        VBox main= new  VBox();
        main.setSpacing(300);
        main.setPadding(new Insets(5,5,5,5));
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(label,scrollPane,buttonClick);

        BorderPane.setAlignment(label, Pos.CENTER);
        Scene scene2=new Scene(main,300,500);



        primaryStage.setTitle("Degree Plan");
        primaryStage.setScene(scene2);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch();
    }


        
}



