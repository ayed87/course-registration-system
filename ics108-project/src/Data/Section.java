package Data;

import java.io.Serializable;

public class Section implements Comparable<Section>, Serializable {

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
    private String courseCode;


   // zyad
    public Section(String[] sectionInformation){

        this.sectionCode = sectionInformation[0]; 
        this.type =  sectionInformation[1] ; 
        this.crn =  sectionInformation[2] ; 
        this.courseName =  sectionInformation[3] ; 
        this.instructor =  sectionInformation[4] ; 
        this.day =  sectionInformation[5]; 
        this.time =  sectionInformation[6]; 
        this.location =  sectionInformation[7]; 
        this.status = sectionInformation[8] ; 
        this.waitlist =  sectionInformation[9] ; 

        this.department = this.sectionCode.substring(0, 4).trim(); // take the first 4 litters, then ommit space if any

        String[] courseCodeParts = this.sectionCode.split("-")[0].split(" ");
        
            this.courseCode= "";
            
            for(int i=0 ; i< courseCodeParts.length ; i++){ 

                this.courseCode = this.courseCode + courseCodeParts[i];
            }

        

     
        
    }
    // we will use this to catch the conflict
    @Override
    public int compareTo(Section theOtherSection) {
        if(readStartTime()<theOtherSection.readStartTime()){
            return -1;
        }
        else if(readStartTime()>theOtherSection.readStartTime()){
            return 1;
        }
        else{
            return 0;
        }
    }

    //ayed's updates: i moved 2 methods form Schedule class to Section class to be more clear

    public int getLectureDuration(){

        String timeString = getTime();
        String[] timeList = timeString.split("-");
        String time1 = timeList[0]; 
        String time2 = timeList[1]; 

        if(time1.charAt(0) == '0'){

            time1 = time1.substring(1);
        }
        if(time2.charAt(0) == '0'){
            time2 = time2.substring(1);
        }

        int number1 = Integer.parseInt(time1);
        int number2 = Integer.parseInt(time2);

        int hourAndMinute = number2-number1;
        // as far as i know the least time is 50 minute
        if(hourAndMinute>50){
            String StringResult = Integer.toString(hourAndMinute);
            int hour = Integer.parseInt(StringResult.substring(0,1));
            int minutes = Integer.parseInt(StringResult.substring(1));
            int hourToMinutes = hour*60;
            return minutes+hourToMinutes;


        }
        else{
            return hourAndMinute;

        }    
    
    }

    // it will set section in the rihgt place in weekPane
    public double setStartPostion(){
        
        String array = getTime();
        String[] timeList = array.split("-");
        String timeString = timeList[0]; 
        
        if(timeString.charAt(0) == '0'){
            timeString = timeString.substring(1);
            int hour = Integer.parseInt(timeString.substring(0,1));
            int minutes = Integer.parseInt(timeString.substring(1));
            double finalResult = (((minutes/(double) 60)+(hour-7))*(55));
            if(finalResult==0){
                return 0;
            }
            else{
                return finalResult;
            }
        }
        else{
            int hour = Integer.parseInt(timeString.substring(0,2));
            int minutes = Integer.parseInt(timeString.substring(2));
            return ((minutes/( double) 60)+(hour-7))*(55);
        }
    }

    //ayed's update: i added here new methods

    public int readStartTime(){
        String timeString = getTime();
        String[] timeArray = timeString.split("-");
        String StartTimeString = timeArray[0];
        if(StartTimeString.charAt(0)=='0'){
            StartTimeString = StartTimeString.substring(1);
            int hour = Integer.parseInt(StartTimeString.substring(0,1));
            int minutes = Integer.parseInt(StartTimeString.substring(1));
            return hour*60+minutes;
        }
        else{
            int hour = Integer.parseInt(StartTimeString.substring(0,2));
            int minutes = Integer.parseInt(StartTimeString.substring(2));
            return hour*60+minutes;
        }


    }

    public int readEndTime(){
        String timeString = getTime();
        String[] timeArray = timeString.split("-");
        String endTimeString = timeArray[1];
        if(endTimeString.charAt(0)=='0'){
            endTimeString = endTimeString.substring(1);
            int hour = Integer.parseInt(endTimeString.substring(0,1));
            int minutes = Integer.parseInt(endTimeString.substring(1));
            return hour*60+minutes;
        }
        else{
            int hour = Integer.parseInt(endTimeString.substring(0,2));
            int minutes = Integer.parseInt(endTimeString.substring(2));
            return hour*60+minutes;
        }


    }
    

    public String toString(){ 

        return "Course Name: " + sectionCode +"   "+ type +"   "+ crn +"   "+ courseName +"   " +instructor +"   "+ day +"   "+ time +"   " + location+"   "+ 
        status +"   "+ waitlist ;
    }

    public String getCourseCode(){ 
        return courseCode ;
    }

    public String getDepartment(){ 
        return department;
    }


    //ayed: i added other geters
    public String getCourseName() {
        return courseName;
    }
    public String getDay() {
        return day;
    }
    public String getTime() {
        return time;
    }
    public String getLocation() {
        return location;
    }
    public String getInstructor() {
        return instructor;
    }
    public String getSectionCode() {
        return sectionCode;
    }
    public String getType() {
        return type;
    }
    public static void main(String[] args) {
        String[] info1 = {"ICS 104-01","LEC","22785","Introduction to Programming in Python and C","M BALAH","UT","0815-0850","24-120","Closed","Open"};
    String[] info2 = {"PHYS101-70","LAB","22041","General Physics I","None","W","0800-1040","None","Closed","Closed"};
    String[] info3 = {"ICS 108-01","LEC","22849","Object-Oriented Programming","MUSTAFA ALTURKI","MW","0800-0915","22-339","Closed","Closed"
    };
    // Schedule schedule = new Schedule();

    Section sections1 = new Section(info1);
    Section sections2 = new Section(info2);
    Section sections3 = new Section(info3);
    // System.out.println(sections1.readEndTime());
    System.out.println(sections1.setStartPostion());
    }

    


     
    
  

    
    
}
