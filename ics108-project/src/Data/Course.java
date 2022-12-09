package Data;

import java.util.Arrays;

public class Course {

    // instance variables 

    private String courseCode ;
    private int credits; 
    private String[] prerequisite;
    private String[] corequisite;
    private String department;
   

    public Course(){
        courseCode="Ics";
    }
    public Course(String[] courseInformation){

        this.courseCode = courseInformation[0];
        this.credits = Integer.parseInt(courseInformation[1]); 
        this.prerequisite = courseInformation[2].split(";"); 
        this.corequisite = courseInformation[3].split(";"); 

       
    }
    public String[] retrunFinshedCourseinfo(){
        String[] infoArray = new String[5];
        infoArray[0] = getCourseCode();
        infoArray[1] = Integer.toString(getCredit());
        infoArray[2] = Arrays.toString(getPrerequisite());
        infoArray[3] = Arrays.toString(getCorequisite());
        infoArray[4] = getDepartment();
        return infoArray;
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
    //mamdouh
    public int getCredit(){ 
        return credits;
    }

    

     

    
    
}
