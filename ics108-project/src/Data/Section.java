package Data;

public class Section  {

    private String sectionCode;  // course code and section number
    private String type;
    private String crn;
    private String courseName; 
    private String instructor;
    private String day; 
    private String time; 
    private String location; 
    private String status; 
    private String waitlist;
    private String department ;


    public Section(String[] sectionInformation){

        this.sectionCode = sectionInformation[0]; 
        this.type =  sectionInformation[1] ; 
        this.crn =  sectionInformation[2] ; 
        this.courseName =  sectionInformation[3] ; 
        this.instructor =  sectionInformation[4] ; 
        this.day =  sectionInformation[5]; 
        this.time =  sectionInformation[6]; 
        this.location =  sectionInformation[7]; 
        //this.status = sectionInformation[8] ; 
        //this.waitlist =  sectionInformation[9] ; 

        this.department = this.sectionCode.substring(0, 5).trim(); // take the first 4 litters, then ommit space if any
        
    }



     
    
  

    
    
}
