package Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.lang.model.util.ElementScanner14;

import javafx.scene.Node;

public class FinishedCourse extends Course {

    private String takenSemester; 
    private String grade ;
    public Object getFinishedCourse; 

    public FinishedCourse(){
        grade="A";
    }
    public FinishedCourse(String[] courseInformation){

        super(courseInformation[0]); 
        this.takenSemester = courseInformation[1]; 
        this.grade = courseInformation[2];

              



    }
    // mamdouh downward 
    public FinishedCourse(String nameCourse,String term,String grade){
        super(nameCourse);
        this.takenSemester = term; 
        this.grade = grade;

    }
    public String setDisplay(String grade){
        return grade;

    }
    public String toString(){ 
        return getCourseCode() +","+ takenSemester +","+ grade;

    }

    public static void  getFinishedCourse (String l) {
        try{
         File file =new File("FinishedCourses.csv");
         PrintWriter output=new PrintWriter(file);
         if(l.length()>3){
            output.print(l);
            output.print(",");
        if(l.length()==3){
            output.print(l);
            output.print(",");}
        else
            output.print(l);}
         
         //output.print(l.toString());
         output.close();
     }
     catch(FileNotFoundException e){
         System.out.print(e);
     }
         
     }
    
}
