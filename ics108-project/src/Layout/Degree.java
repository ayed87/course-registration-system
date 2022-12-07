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
    String name="";
   

   

    String title="Course,Term,Grade";
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
     
     ///////////////////////
       
       
       

        
       


       


        // vbox for class
        VBox vbox2= new VBox();
        vbox2.setSpacing(29.2);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(new Label("Courses"));
        for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox2.getChildren().add(new Label (student1.getCourseArray().get(i).getCourseCode()));
        }
       
        

        // credit 
        VBox vbox3= new VBox();
        vbox3.setSpacing(29.2);
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
         vbox5.setSpacing(29.2);
         vbox5.setPadding(new Insets(5,5,5,5));
         vbox5.setAlignment(Pos.CENTER);
         vbox5.getChildren().addAll(new Label("Corequisite"));
         for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox5.getChildren().add(new Label (Arrays.toString(student1.getCourseArray().get(i).getCorequisite())));
       }
        

        //prerequisite 
        VBox vbox4= new VBox();
        vbox4.setSpacing(29.2);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(new Label("Prerequisite "));
        for(int i=0;i<student1.getNumberOfCourses();i++){
            vbox4.getChildren().add(new Label (Arrays.toString(student1.getCourseArray().get(i).getPrerequisite())));
       }




         //checkbox
        VBox vbox6= new VBox();
        vbox6.setSpacing(28.5);
        vbox6.setPadding(new Insets(5,5,5,5));
        vbox6.setAlignment(Pos.CENTER);
        vbox6.getChildren().add(new Label("Taken Courses"));
        vbox6.getChildren().addAll(box1,box2,box3,box4,box5,box6,box7,box8,box9,box10);
        vbox6.getChildren().addAll(box11,box12,box13,box14,box15,box16,box17,box18,box19,box20);
        vbox6.getChildren().addAll(box21,box22,box23,box24,box25,box26,box27,box28,box29,box30);
        vbox6.getChildren().addAll(box31,box32,box33,box34,box35,box36,box37,box38,box39,box40);
        vbox6.getChildren().addAll(box41,box42,box43,box44);
        FinishedCourse finish= new FinishedCourse();
        finish.getFinishedCourse(title);
        //ArrayList <String> array=new ArrayList<>();
       // array.add(title);
        // Event for checkbox
        box1.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(0).getCourseCode();
        });
        term1.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade1.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        });
        name="";
        box2.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(1).getCourseCode();
        });
        term2.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade2.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box3.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(2).getCourseCode();
        });
        term3.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade3.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box4.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(3).getCourseCode();
        });
        term4.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade4.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box5.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(4).getCourseCode();
        });
        term5.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade5.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box6.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(5).getCourseCode();
        });
        term6.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade6.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box7.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(6).getCourseCode();
        });
        term7.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade7.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box8.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(7).getCourseCode();
        });
        term8.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade8.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            //finish.getFinishedCourse(name);
        }); 
        name="";
        box9.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(8).getCourseCode();
        });
        term9.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade9.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box10.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(9).getCourseCode();
        });
        term10.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade10.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box11.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(10).getCourseCode();
        });
        term11.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade11.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box12.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(11).getCourseCode();
        });
        term12.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade12.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box13.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(12).getCourseCode();
        });
        term13.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade13.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box14.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(13).getCourseCode();
        });
        term14.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade14.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box15.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(14).getCourseCode();
        });
        term15.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade15.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box16.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(15).getCourseCode();
        });
        term16.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade16.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
           finish.getFinishedCourse(name);
        }); 
        name="";
        box17.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(16).getCourseCode();
        });
        term17.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade17.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
           finish.getFinishedCourse(name);
        }); 
        name="";
        box18.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(17).getCourseCode();
        });
        term18.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade18.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box19.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(18).getCourseCode();
        });
        term19.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade19.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box20.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(19).getCourseCode();
        });
        term20.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade20.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box21.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(20).getCourseCode();
        });
        term21.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade21.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box22.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(21).getCourseCode();
        });
        term22.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade22.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box23.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(22).getCourseCode();
        });
        term23.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade23.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box24.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(23).getCourseCode();
        });
        term24.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade24.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box25.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(24).getCourseCode();
        });
        term25.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade25.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box26.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(25).getCourseCode();
        });
        term26.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade26.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box27.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(26).getCourseCode();
        });
        term27.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade27.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box28.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(27).getCourseCode();
        });
        term28.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade28.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box29.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(28).getCourseCode();
        });
        term29.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade29.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box30.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(29).getCourseCode();
        });
        term30.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade30.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box31.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(30).getCourseCode();
        });
        term31.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade31.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box32.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(31).getCourseCode();
        });
        term32.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade32.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box33.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(32).getCourseCode();
        });
        term33.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade33.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box34.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(33).getCourseCode();
        });
        term34.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade34.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box35.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(34).getCourseCode();
        });
        term35.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade35.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box36.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(35).getCourseCode();
        });
        term36.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade36.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box37.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(36).getCourseCode();
        });
        term37.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade37.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box38.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(37).getCourseCode();
        });
        term38.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade38.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box39.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(38).getCourseCode();
        });
        term39.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade39.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box40.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(39).getCourseCode();
        });
        term40.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade40.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        }); 
        name="";
        box41.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(40).getCourseCode();
        });
        term41.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade41.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        });
        name="";    
        box42.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(41).getCourseCode();
        });
        term42.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade42.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        });
        name="";
        box43.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(42).getCourseCode();
        });
        term43.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade43.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        });
        name="";
        box44.setOnAction(e ->{
            //grade1.setDisable(false);
            //term1.setDisable(false);
            name=student1.getCourseArray().get(43).getCourseCode();
        });
        term44.setOnAction(c ->{String gradeScore1=term1.getValue();
            name=name+","+gradeScore1;

        });
        grade44.setOnAction(m ->{String gradeScore=grade1.getValue();
            name=name+","+gradeScore;
            finish.getFinishedCourse(name);
        });
///////////////////////////////////////////////////////////////////////////
         //checkbox grades
         VBox vbox8= new VBox();
         vbox8.setSpacing(20);
         vbox8.setPadding(new Insets(5,5,5,5));
         vbox8.setAlignment(Pos.CENTER);
         vbox8.getChildren().addAll(new Label("Grades"));
         vbox8.getChildren().addAll(grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10);
         vbox8.getChildren().addAll(grade11,grade12,grade13,grade14,grade15,grade16,grade17,grade18,grade19,grade20);
         vbox8.getChildren().addAll(grade21,grade22,grade23,grade24,grade25,grade26,grade27,grade28,grade29,grade30);
         vbox8.getChildren().addAll(grade31,grade32,grade33,grade34,grade35,grade36,grade37,grade38,grade39,grade40);
         vbox8.getChildren().addAll(grade41,grade42,grade43,grade44);
         

      
        
          
   
       

         //checkbox term
         VBox vbox7= new VBox();
         vbox7.setSpacing(20);
         vbox7.setPadding(new Insets(5,5,5,5));
         vbox7.setAlignment(Pos.CENTER);
         vbox7.getChildren().addAll(new Label("Term"));
         vbox7.getChildren().addAll(term1,term2,term3,term4,term5,term6,term7,term8,term9,term10);
         vbox7.getChildren().addAll(term11,term12,term13,term14,term15,term16,term17,term18,term19,term20);
         vbox7.getChildren().addAll(term21,term22,term23,term24,term25,term26,term27,term28,term29,term30);
         vbox7.getChildren().addAll(term31,term32,term33,term34,term35,term36,term37,term38,term39,term40);
         vbox7.getChildren().addAll(term41,term42,term43,term44);
        

        HBox parts= new HBox();
        parts.setSpacing(200);
        parts.setPadding(new Insets(5,5,5,5));
        parts.setAlignment(Pos.CENTER);
        parts.getChildren().addAll(vbox2,vbox3,vbox4,vbox5,vbox6,vbox7,vbox8);

        ScrollPane  scrollPane= new ScrollPane(parts);
    
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


        




