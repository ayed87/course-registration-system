package Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.util.ElementScanner14;

import javafx.scene.Node;

public class FinishedCourse extends Course {

    private String takenSemester; 
    private String grade;
   


    public FinishedCourse(String[] courseInformation){

        super(courseInformation[0]); 

        this.takenSemester = courseInformation[1]; 
        this.grade =  courseInformation[2];
    }
        

              
    
    
    public String toString(){ 
        return getCourseCode() +","+ takenSemester +","+ grade;

    }
  
    

    public String getTakenSemester() {
        return takenSemester;
    }

    public String getGrade() {
        return grade;
    }
    
}
