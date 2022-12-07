package Layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Data.Course;
import Data.FinishedCourse;
import Data.Student;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;


public class Degree extends Application{
    Button b6 = new Button("Save");
    Button b7 = new Button("Back");
    Button b8 = new Button("Show the flowchart");
    public void start(Stage primaryStage)  {
        
        b6.setMinSize(100, 20);
        b7.setMinSize(100, 20);
        b8.setMinSize(100, 20);
        Text label =new Text("Degree plan");
        label.setFont(new Font("Arial", 50));
        //CheckBox taken= new CheckBox("Taken");

     //Reading file 



   
   
     Student student1 = new Student(); 
        

     try{ 

       

        FileReader degreePlan = new FileReader("DegreePlan.csv");
        BufferedReader degreePlanReader = new BufferedReader(degreePlan);

        

         
        student1.readAllCourse(degreePlanReader);
         

     }

     catch(FileNotFoundException e){System.out.println(e);}





    //CheckBox for each course:
        CheckBox box1= new CheckBox();
        CheckBox box2= new CheckBox();
        CheckBox box3= new CheckBox();
        CheckBox box4= new CheckBox();
        CheckBox box5= new CheckBox();
        CheckBox box6= new CheckBox();
        CheckBox box7= new CheckBox();
        CheckBox box8= new CheckBox();
        CheckBox box9= new CheckBox();
        CheckBox box10= new CheckBox();
        CheckBox box11= new CheckBox();
        CheckBox box12= new CheckBox();
        CheckBox box13= new CheckBox();
        CheckBox box14= new CheckBox();
        CheckBox box15= new CheckBox();
        CheckBox box16= new CheckBox();
        CheckBox box17= new CheckBox();
        CheckBox box18= new CheckBox();
        CheckBox box19= new CheckBox();
        CheckBox box20= new CheckBox();
        CheckBox box21= new CheckBox();
        CheckBox box22= new CheckBox();
        CheckBox box23= new CheckBox();
        CheckBox box24= new CheckBox();
        CheckBox box25= new CheckBox();
        CheckBox box26= new CheckBox();
        CheckBox box27= new CheckBox();
        CheckBox box28= new CheckBox();
        CheckBox box29= new CheckBox();
        CheckBox box30= new CheckBox();
        CheckBox box31= new CheckBox();
        CheckBox box32= new CheckBox();
        CheckBox box33= new CheckBox();
        CheckBox box34= new CheckBox();
        CheckBox box35= new CheckBox();
        CheckBox box36= new CheckBox();
        CheckBox box37= new CheckBox();
        CheckBox box38= new CheckBox();
        CheckBox box39= new CheckBox();
        CheckBox box40= new CheckBox();
        CheckBox box41= new CheckBox();
        CheckBox box42= new CheckBox();
        CheckBox box43= new CheckBox();
        CheckBox box44= new CheckBox();
        ////////////////////////////////
       //Grade  courses combox for courses that are taken
       String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"}; 
       ComboBox<String> grade1 = new ComboBox<>();
       grade1.getItems().addAll(grade);
       ComboBox<String> grade2 = new ComboBox<>();
       grade2.getItems().addAll(grade);
       ComboBox<String> grade3 = new ComboBox<>();
       grade3.getItems().addAll(grade);
       ComboBox<String> grade4 = new ComboBox<>();
       grade4.getItems().addAll(grade);
       ComboBox<String> grade5 = new ComboBox<>();
       grade5.getItems().addAll(grade);
       ComboBox<String> grade6 = new ComboBox<>();
       grade6.getItems().addAll(grade);
       ComboBox<String> grade7 = new ComboBox<>();
       grade7.getItems().addAll(grade);
       ComboBox<String> grade8 = new ComboBox<>();
       grade8.getItems().addAll(grade);
       ComboBox<String> grade9 = new ComboBox<>();
       grade9.getItems().addAll(grade);
       ComboBox<String> grade10 = new ComboBox<>();
       grade10.getItems().addAll(grade);
       ComboBox<String> grade11 = new ComboBox<>();
       grade11.getItems().addAll(grade);
       ComboBox<String> grade12 = new ComboBox<>();
       grade12.getItems().addAll(grade);
       ComboBox<String> grade13 = new ComboBox<>();
       grade13.getItems().addAll(grade);
       ComboBox<String> grade14 = new ComboBox<>();
       grade14.getItems().addAll(grade);
       ComboBox<String> grade15 = new ComboBox<>();
       grade15.getItems().addAll(grade);
       ComboBox<String> grade16 = new ComboBox<>();
       grade16.getItems().addAll(grade);
       ComboBox<String> grade17 = new ComboBox<>();
       grade17.getItems().addAll(grade);
       ComboBox<String> grade18 = new ComboBox<>();
       grade18.getItems().addAll(grade);
       ComboBox<String> grade19 = new ComboBox<>();
       grade19.getItems().addAll(grade);
       ComboBox<String> grade20 = new ComboBox<>();
       grade20.getItems().addAll(grade);
       ComboBox<String> grade21 = new ComboBox<>();
       grade21.getItems().addAll(grade);
       ComboBox<String> grade22 = new ComboBox<>();
       grade22.getItems().addAll(grade);
       ComboBox<String> grade23 = new ComboBox<>();
       grade23.getItems().addAll(grade);
       ComboBox<String> grade24 = new ComboBox<>();
       grade24.getItems().addAll(grade);
       ComboBox<String> grade25 = new ComboBox<>();
       grade25.getItems().addAll(grade);
       ComboBox<String> grade26 = new ComboBox<>();
       grade26.getItems().addAll(grade);
       ComboBox<String> grade27 = new ComboBox<>();
       grade27.getItems().addAll(grade);
       ComboBox<String> grade28 = new ComboBox<>();
       grade28.getItems().addAll(grade);
       ComboBox<String> grade29 = new ComboBox<>();
       grade29.getItems().addAll(grade);
       ComboBox<String> grade30 = new ComboBox<>();
       grade30.getItems().addAll(grade);
       ComboBox<String> grade31 = new ComboBox<>();
       grade31.getItems().addAll(grade);
       ComboBox<String> grade32 = new ComboBox<>();
       grade32.getItems().addAll(grade);
       ComboBox<String> grade33 = new ComboBox<>();
       grade33.getItems().addAll(grade);
       ComboBox<String> grade34 = new ComboBox<>();
       grade34.getItems().addAll(grade);
       ComboBox<String> grade35 = new ComboBox<>();
       grade35.getItems().addAll(grade);
       ComboBox<String> grade36 = new ComboBox<>();
       grade36.getItems().addAll(grade);
       ComboBox<String> grade37 = new ComboBox<>();
       grade37.getItems().addAll(grade);
       ComboBox<String> grade38 = new ComboBox<>();
       grade38.getItems().addAll(grade);
       ComboBox<String> grade39 = new ComboBox<>();
       grade39.getItems().addAll(grade);
       ComboBox<String> grade40 = new ComboBox<>();
       grade40.getItems().addAll(grade);
       ComboBox<String> grade41 = new ComboBox<>();
       grade41.getItems().addAll(grade);
       ComboBox<String> grade42 = new ComboBox<>();
       grade42.getItems().addAll(grade);
       ComboBox<String> grade43 = new ComboBox<>();
       grade43.getItems().addAll(grade);
       ComboBox<String> grade44 = new ComboBox<>();
       grade44.getItems().addAll(grade);
       ///////////////////////////////////////////
       //Term courses combox for courses that are taken.
       String[] years= {"222","221","213","212","211","203","202","201"}; 
       ComboBox<String> term1 = new ComboBox<>();
       term1.getItems().addAll(years);
       ComboBox<String> term2 = new ComboBox<>();
       term2.getItems().addAll(years);
       ComboBox<String> term3 = new ComboBox<>();
       term3.getItems().addAll(years);
       ComboBox<String> term4 = new ComboBox<>();
       term4.getItems().addAll(years);
       ComboBox<String> term5 = new ComboBox<>();
       term5.getItems().addAll(years);
       ComboBox<String> term6 = new ComboBox<>();
       term6.getItems().addAll(years);
       ComboBox<String> term7 = new ComboBox<>();
       term7.getItems().addAll(years);
       ComboBox<String> term8= new ComboBox<>();
       term8.getItems().addAll(years);
       ComboBox<String> term9 = new ComboBox<>();
       term9.getItems().addAll(years);
       ComboBox<String> term10 = new ComboBox<>();
       term10.getItems().addAll(years);
       ComboBox<String> term11 = new ComboBox<>();
       term11.getItems().addAll(years);
       ComboBox<String> term12 = new ComboBox<>();
       term12.getItems().addAll(years);
       ComboBox<String> term13 = new ComboBox<>();
       term13.getItems().addAll(years);
       ComboBox<String> term14 = new ComboBox<>();
       term14.getItems().addAll(years);
       ComboBox<String> term15 = new ComboBox<>();
       term15.getItems().addAll(years);
       ComboBox<String> term16 = new ComboBox<>();
       term16.getItems().addAll(years);
       ComboBox<String> term17 = new ComboBox<>();
       term17.getItems().addAll(years);
       ComboBox<String> term18= new ComboBox<>();
       term18.getItems().addAll(years);
       ComboBox<String> term19 = new ComboBox<>();
       term19.getItems().addAll(years);
       ComboBox<String> term20 = new ComboBox<>();
       term20.getItems().addAll(years);
       ComboBox<String> term21 = new ComboBox<>();
       term21.getItems().addAll(years);
       ComboBox<String> term22 = new ComboBox<>();
       term22.getItems().addAll(years);
       ComboBox<String> term23 = new ComboBox<>();
       term23.getItems().addAll(years);
       ComboBox<String> term24 = new ComboBox<>();
       term24.getItems().addAll(years);
       ComboBox<String> term25 = new ComboBox<>();
       term25.getItems().addAll(years);
       ComboBox<String> term26 = new ComboBox<>();
       term26.getItems().addAll(years);
       ComboBox<String> term27 = new ComboBox<>();
       term27.getItems().addAll(years);
       ComboBox<String> term28= new ComboBox<>();
       term28.getItems().addAll(years);
       ComboBox<String> term29 = new ComboBox<>();
       term29.getItems().addAll(years);
       ComboBox<String> term30 = new ComboBox<>();
       term30.getItems().addAll(years);
       ComboBox<String> term31 = new ComboBox<>();
       term31.getItems().addAll(years);
       ComboBox<String> term32 = new ComboBox<>();
       term32.getItems().addAll(years);
       ComboBox<String> term33 = new ComboBox<>();
       term33.getItems().addAll(years);
       ComboBox<String> term34 = new ComboBox<>();
       term34.getItems().addAll(years);
       ComboBox<String> term35 = new ComboBox<>();
       term35.getItems().addAll(years);
       ComboBox<String> term36 = new ComboBox<>();
       term36.getItems().addAll(years);
       ComboBox<String> term37 = new ComboBox<>();
       term37.getItems().addAll(years);
       ComboBox<String> term38= new ComboBox<>();
       term38.getItems().addAll(years);
       ComboBox<String> term39 = new ComboBox<>();
       term39.getItems().addAll(years);
       ComboBox<String> term40 = new ComboBox<>();
       term40.getItems().addAll(years);
       ComboBox<String> term41 = new ComboBox<>();
       term41.getItems().addAll(years);
       ComboBox<String> term42 = new ComboBox<>();
       term42.getItems().addAll(years);
       ComboBox<String> term43 = new ComboBox<>();
       term43.getItems().addAll(years);
       ComboBox<String> term44 = new ComboBox<>();
       term44.getItems().addAll(years);
       //////////////////////////////////////////


     //make the comboxs on if the checkbox turn on
     grade1.setDisable(true);
     grade2.setDisable(true);
     grade3.setDisable(true);
     grade4.setDisable(true); 
     grade5.setDisable(true);
     grade6.setDisable(true);
     grade7.setDisable(true);
     grade8.setDisable(true);
     grade9.setDisable(true);
     grade10.setDisable(true);
     grade11.setDisable(true);
     grade12.setDisable(true);
     grade13.setDisable(true);
     grade14.setDisable(true); 
     grade15.setDisable(true);
     grade16.setDisable(true);
     grade17.setDisable(true);
     grade18.setDisable(true);
     grade19.setDisable(true);
     grade20.setDisable(true);
     grade21.setDisable(true);
     grade22.setDisable(true);
     grade23.setDisable(true);
     grade24.setDisable(true); 
     grade25.setDisable(true);
     grade26.setDisable(true);
     grade27.setDisable(true);
     grade28.setDisable(true);
     grade29.setDisable(true);
     grade30.setDisable(true);
     grade31.setDisable(true);
     grade32.setDisable(true);
     grade33.setDisable(true);
     grade34.setDisable(true); 
     grade35.setDisable(true);
     grade36.setDisable(true);
     grade37.setDisable(true);
     grade38.setDisable(true);
     grade39.setDisable(true);
     grade40.setDisable(true);
     grade41.setDisable(true);
     grade42.setDisable(true);
     grade43.setDisable(true);
     grade44.setDisable(true);
     term1.setDisable(true);
     term2.setDisable(true);
     term3.setDisable(true);
     term4.setDisable(true);
     term5.setDisable(true);
     term6.setDisable(true);
     term7.setDisable(true);
     term8.setDisable(true);
     term9.setDisable(true);
     term10.setDisable(true);
     term11.setDisable(true);
     term12.setDisable(true);
     term13.setDisable(true);
     term14.setDisable(true);
     term15.setDisable(true);
     term16.setDisable(true);
     term17.setDisable(true);
     term18.setDisable(true);
     term19.setDisable(true);
     term20.setDisable(true);
     term21.setDisable(true);
     term22.setDisable(true);
     term23.setDisable(true);
     term24.setDisable(true);
     term25.setDisable(true);
     term26.setDisable(true);
     term27.setDisable(true);
     term28.setDisable(true);
     term29.setDisable(true);
     term30.setDisable(true);
     term31.setDisable(true);
     term32.setDisable(true);
     term33.setDisable(true);
     term34.setDisable(true);
     term35.setDisable(true);
     term36.setDisable(true);
     term37.setDisable(true);
     term38.setDisable(true);
     term39.setDisable(true);
     term40.setDisable(true);
     term41.setDisable(true);
     term42.setDisable(true);
     term43.setDisable(true);
     term44.setDisable(true);
     ///////////////////////
       
       
       

        
       


       


        // vbox for class
        VBox vbox2= new VBox();
        vbox2.setSpacing(15);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(new Label("Courses"));
        for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox2.getChildren().add(new Label (student1.getCourseArray().get(i).getCourseCode()));
        }
       
        

        // credit 
        VBox vbox3= new VBox();
        vbox3.setSpacing(15);
        vbox3.setPadding(new Insets(5,5,5,5));
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().addAll(new Label("Credit"));
        for(int i=0;i<student1.getNumberOfCourses();i++){
            int number= student1.getCourseArray().get(i).getCredit();
            String string=Integer.toString(number);
            vbox3.getChildren().add(new Label(string));
        }
        
        // corequisite
         VBox vbox5= new VBox();
         vbox5.setSpacing(15);
         vbox5.setPadding(new Insets(5,5,5,5));
         vbox5.setAlignment(Pos.CENTER);
         vbox5.getChildren().addAll(new Label("Corequisite"));
         for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox5.getChildren().add(new Label (Arrays.toString(student1.getCourseArray().get(i).getCorequisite())));
       }
        

        //prerequisite 
        VBox vbox4= new VBox();
        vbox4.setSpacing(15);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(new Label("Prerequisite "));
        for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox4.getChildren().add(new Label (Arrays.toString(student1.getCourseArray().get(i).getPrerequisite())));
       }




         //checkbox
        VBox vbox6= new VBox();
        vbox6.setSpacing(10);
        vbox6.setPadding(new Insets(5,5,5,5));
        vbox6.setAlignment(Pos.CENTER);
        vbox6.getChildren().add(new Label("Taken Courses"));
        vbox6.getChildren().addAll(box1,box2,box3,box4,box5,box6,box7,box8,box9,box10);
        vbox6.getChildren().addAll(box11,box12,box13,box14,box15,box16,box17,box18,box19,box20);
        vbox6.getChildren().addAll(box21,box22,box23,box24,box25,box26,box27,box28,box29,box30);
        vbox6.getChildren().addAll(box31,box32,box33,box34,box35,box36,box37,box38,box39,box40);
        vbox6.getChildren().addAll(box41,box42,box43,box44);
        FinishedCourse finish= new FinishedCourse();
        grade1.getValue();
        // Event for checkbox
        box1.setOnAction(e ->{
            grade1.setDisable(false);
            term1.setDisable(false);
            finish.getFinishedCourse(student1.getCourseArray().get(0).getCourseCode());
            grade1.setOnAction(m ->{String gradeScore=grade1.getValue();
               finish.getFinishedCourse(gradeScore);
            });
            term1.setOnAction(m ->{String gradeScore1=term1.getValue();
                finish.getFinishedCourse(gradeScore1);
            });
             

            }); 


         //checkbox grades
         VBox vbox7= new VBox();
         vbox7.setSpacing(10);
         vbox7.setPadding(new Insets(5,5,5,5));
         vbox7.setAlignment(Pos.CENTER);
         vbox7.getChildren().addAll(new Label("Grades"));
         vbox7.getChildren().addAll(grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10);
         vbox7.getChildren().addAll(grade11,grade12,grade13,grade14,grade15,grade16,grade17,grade18,grade19,grade20);
         vbox7.getChildren().addAll(grade21,grade22,grade23,grade24,grade25,grade26,grade27,grade28,grade29,grade30);
         vbox7.getChildren().addAll(grade31,grade32,grade33,grade34,grade35,grade36,grade37,grade38,grade39,grade40);
         vbox7.getChildren().addAll(grade41,grade42,grade43,grade44);
         //for(int i=0;i<student1.getNumberOfCourses();i++){
           // vbox7.getChildren().add(grades);
       //}

      
         // events for comboBox
          
   
        
   
        //// Grades for the course 
         //String[] years= {"222","221","213","212","211","203","202","201"}; 
         //ComboBox<String> terms = new ComboBox<>();

      
        
         //terms.getItems().addAll(years);

         //checkbox term
         VBox vbox8= new VBox();
         vbox8.setSpacing(10);
         vbox8.setPadding(new Insets(5,5,5,5));
         vbox8.setAlignment(Pos.CENTER);
         vbox8.getChildren().addAll(new Label("Term"));
         vbox8.getChildren().addAll(term1,term2,term3,term4,term5,term6,term7,term8,term9,term10);
         vbox8.getChildren().addAll(term11,term12,term13,term14,term15,term16,term17,term18,term19,term20);
         vbox8.getChildren().addAll(term21,term22,term23,term24,term25,term26,term27,term28,term29,term30);
         vbox8.getChildren().addAll(term31,term32,term33,term34,term35,term36,term37,term38,term39,term40);
         vbox8.getChildren().addAll(term41,term42,term43,term44);
        // for(int i=0;i<student1.getNumberOfCourses();i++){
         //   vbox8.getChildren().add(terms);
       // }
        
        
        
        
         // events for comboBox
          //terms.getItems().addAll(years);
          
   
          //grades.setOnAction(e-> {}
         // );
   
        //


        HBox parts= new HBox();
        parts.setSpacing(200);
        parts.setPadding(new Insets(5,5,5,5));
        parts.setAlignment(Pos.CENTER);
        parts.getChildren().addAll(vbox2,vbox3,vbox4,vbox5,vbox6,vbox7,vbox8);


        ScrollPane  scrollPane= new ScrollPane(parts);
        
   
    
    // event for checkbox taken
    //taken.setOnAction(e ->{ grades.setDisable(false) ;terms.setDisable(false);
        
        //FinishedCourse course1=new FinishedCourse("mamdouh","211","a");  
        //course1.getFinishedCourse.add(course1.toString());

   // });

        // hbox for button
        HBox buttonClick= new HBox();
        buttonClick.setSpacing(100);
        buttonClick.setPadding(new Insets(5,5,5,5));
        buttonClick.setAlignment(Pos.CENTER);
        buttonClick.getChildren().addAll(b6,b7,b8);
    
        
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


        




