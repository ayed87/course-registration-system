package Data;

public class FinishedCourse extends Course {

    private String takenSemester; 
    private String grade ; 


    public FinishedCourse(String[] courseInformation){

        super(courseInformation[0]); 
        this.takenSemester = courseInformation[1]; 
        this.grade = courseInformation[2];

              



    }
    
}
