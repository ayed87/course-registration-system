package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.scene.Node;

public class FinishedCourse extends Course {

    private String takenSemester; 
    private String grade ;
    public Object getFinishedCourse; 

   
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
    public String toString(){ 
        return getCourseCode() +","+ takenSemester +","+ grade;

    }
    public static void  getFinishedCourse (String m) {
        try{
         File file =new File("FinishedCourses.csv");
         PrintWriter output=new PrintWriter(file);
         output.print(m);
         output.close();
     }
     catch(FileNotFoundException e){
         System.out.print(m);
     }
         
     }
    
}
