package Layout;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.FindException;
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

//sorry it is hard to read but you can do it
public class degreePane extends Application{
    Button saveButton = new Button("Save");
    Button backButton = new Button("Back");
    Button saveChartButton = new Button("Show the flowchart");
    Student student = new Student(); 





   

    String title="Course,Term,Grade";
    public void start(Stage primaryStage)  {


        // save button 
        saveButton.setMinSize(100, 20);
        saveButton.setOnAction(e->{
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
        backButton.setMinSize(100, 20);
        saveChartButton.setMinSize(100, 20);
        Text label =new Text("Degree plan");
        label.setFont(new Font("Arial", 50));



   
   
        

     try{ 
        FileReader finishedCourses = new FileReader("FinishedCourses.csv");
        BufferedReader finishedCoursesReader = new BufferedReader(finishedCourses);

    
        student.readAllFinishedCourses(finishedCoursesReader);

        
        FileReader degreePlan = new FileReader("DegreePlan.csv");
        BufferedReader degreePlanReader = new BufferedReader(degreePlan);
         
        student.readAllCourse(degreePlanReader);
        

         
     }

     catch(FileNotFoundException e){System.out.println(e);}


        ListView<HBox> showPlanelListView = new ListView<>(createCourseBox(student));
        
        
        // hbox for button
        Button exiButton = new Button("exit");
        exiButton.setOnAction(e ->{
            primaryStage.close();
        });
        HBox bottomButtonsPane= new HBox();
        bottomButtonsPane.setSpacing(100);
        bottomButtonsPane.setPadding(new Insets(5,5,5,5));
        bottomButtonsPane.setAlignment(Pos.CENTER);
        bottomButtonsPane.getChildren().addAll(saveButton,backButton,saveChartButton,exiButton);
        
        VBox main = new  VBox();
        main.setSpacing(50);
        main.setPadding(new Insets(5,5,5,5));
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(label,showPlanelListView,bottomButtonsPane);


        Scene scene2 = new Scene(main,300,500);

        primaryStage.setTitle("Degree Plan");
        primaryStage.setScene(scene2);
        primaryStage.show();


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
            CheckBox checkBox = new CheckBox();
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

            checkBox.setOnAction(e ->{
                if(checkBox.isSelected()){

                    

                    String term = terms.getSelectionModel().getSelectedItem();
                    String takenGrade = grades.getSelectionModel().getSelectedItem();
                  

                    String[] courseInformation = {course.getCourseCode() ,term,takenGrade};
                    FinishedCourse finishedCourse = new FinishedCourse(courseInformation);
                    student.addFinshedCourse(finishedCourse);
                    

                    

                    
                    
                }else{
                    
                    for(int i= 0 ; i< student.getNumberOfFinishedCourse(); i++ ){ 


                        if(course.getCourseCode().equals(student.getFinishedCourses().get(i).getCourseCode())){ 

                            student.removeFinshedCourse(student.getFinishedCourses().get(i));
                        }
                    }
                }
           



            });
            hBox.getChildren().addAll(textName,Textcridit,textpreRequest,TextCorerequisite,StatusButton,terms,grades);
            finalResult.add(hBox);


        }
        return finalResult;
    }
    
    public static void main(String[] args) {
        launch();
    }
}    


        




