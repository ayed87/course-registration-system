package Data;

import java.util.Arrays;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Schedule {

    String term;
    String registeredSections;
    String basketSections;
    int registeredCredits;
    
    
    
    // a method to count the time in minutes...
    public static int readTime(Section section){
        String timeString = section.getTime();
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

      public static int readStartTime(Section section){
        
        String array = section.getTime();
        String[] timeList = array.split("-");
        String timeString = timeList[0]; 
        
        if(timeString.charAt(0) == '0'){
            timeString = timeString.substring(1);
            int hour = Integer.parseInt(timeString.substring(0,1));
            int minutes = Integer.parseInt(timeString.substring(2));
            int finalResult = (minutes+hour*60)-425;
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
            return (minutes+ hour*60)-425;
        }



      }

      public static void main(String[] args) {
        // String n = "0800-0850";
        // System.out.println(readStartTime(n));
        String[] info1 = {"ICS 104-04","LEC","22795","Introduction to Programming in Python and C","S ARAFAT","MW","0900-0950","24-120","Closed","Closed"
    };
    String[] info2 = {"PHYS101-70","LAB","22041","General Physics I","None","W","0800-1040","None","Closed","Closed"};
    String[] info3 = {"ICS 108-01","LEC","22849","Object-Oriented Programming","MUSTAFA ALTURKI","MW","0800-0915","22-339","Closed","Closed"
    };
    Section sections1 = new Section(info1);
    Section sections2 = new Section(info2);
    Section sections3 = new Section(info3);

    System.out.println(readTime(sections3));



      }

    

}

