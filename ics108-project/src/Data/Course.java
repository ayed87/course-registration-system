package Data;

import java.util.Arrays;

public class Course {

    // instance variables 

    private String courseCode ;
    private int credits; 
    private String[] prerequisite;
    private String[] corequisite;
    private String department;
   


    public Course(String[] courseInformation){

        this.courseCode = courseInformation[0];
        this.credits = Integer.parseInt(courseInformation[1]); 
        this.prerequisite = courseInformation[2].split(";"); 
        this.corequisite = courseInformation[3].split(";"); 

       
    }

    public Course(String courseCode){ 

        this.courseCode = courseCode;
    }
   
    public String getCourseCode(){ 
        return courseCode;
    }

    public String[] getPrerequisite(){ 
        return prerequisite;
    }

    public String toString(){ 
        return courseCode +" "+ credits +" "+ Arrays.toString(prerequisite) +" "+ Arrays.toString(corequisite);

    }

    public String[] getCorequisite(){ 

        return corequisite;
    }

    public String getDepartment(){ 
        return department;
    }
  
    
    

     

    
    
}
