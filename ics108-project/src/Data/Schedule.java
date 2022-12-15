package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.controlsfx.control.PlusMinusSlider.PlusMinusEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Schedule implements Serializable {

    String term;
    ArrayList<Section> registeredSections = new ArrayList<>();
    ArrayList<Section> basketSections = new ArrayList<>();
    // int registeredCredits;
    Pane weekDaysPane;
    
    
    
    public Schedule(ObservableList<Section> basketSections){

      this.basketSections = (ArrayList<Section>) basketSections.stream().collect(Collectors.toList());

    }
    public Schedule(){}

    public ArrayList<Section> getBasketSections() {
        return basketSections;
    }
    public void saveWeekPane(Pane pane){
      weekDaysPane = pane;
    }
    public void loadOldObject(Schedule schedule){
      this.registeredSections = schedule.getRegisteredSections();
      this.basketSections = schedule.getBasketSections();


    }

    
  

    // our mission here is to save the pane that was contin the sections;

    public void setWeekDaysPane(Pane weekDaysPane) {
        this.weekDaysPane = weekDaysPane;
    }

    public Pane getWeekDaysPane() {
        return weekDaysPane;
    }
 
    public ArrayList<Section> getRegisteredSections() {
        return registeredSections;
    }


    public void setBasketSections(ObservableList<Section> basketSections) {
        this.basketSections = (ArrayList<Section>) basketSections.stream().collect(Collectors.toList());;
    }

    public void addToBasket(Section section){ 
      basketSections.add(section);
    }

    public void removeFromBasket(Section section){ 
      basketSections.remove(section);
    }

    
      public void addRigesterdCourse(Section section){
        registeredSections.add(section);
        
      }

      public void removeCourse(Section section){
        registeredSections.remove(section);
      }
      public void retrunToBasket(Section section){
        basketSections.add(section);
      }
      public void removeCourseFromBasket(Section section){
        basketSections.remove(section);
    }

      // we need a method to check the conflict and the similirty ..
      public boolean checkExistence(Section section){
        for(Section eachSection : registeredSections){
          if(eachSection.getCourseCode().equals(section.getCourseCode()) && eachSection.getType().equals(section.getType())){
              return true;
          }
        }

        return false;

      }
      public boolean checkConflict(Section section){
        // frist chck the similarity
        // for(Section eachSection : registeredSections){
        //     if(eachSection.getCourseCode().equals(section.getCourseCode())){
        //         return false;
        //     }
        // }
        for(Section eachSection: registeredSections){
            if(eachSection.getDay().equals(section.getDay())|| section.getDay().contains(eachSection.getDay()) || eachSection.getDay().contains(section.getDay())){
                Section[] sections = new Section[2];
                sections[0] = eachSection;
                sections[1] = section;
                Arrays.sort(sections);
                if(sections[0].readEndTime()>sections[1].readStartTime()){
                    return false;
                }
                // else if()
            }  
        }
        return true;
      }
      public ObservableList<VBox> createVboxSections(){

        ObservableList<VBox> arrayList = FXCollections.observableArrayList();
        for(int i =0; i<basketSections.size(); i++){
          arrayList.add(createCourseLabel(basketSections.get(i)));
        }
        
        return arrayList;
      }
      
      public static VBox createCourseLabel(Section section){
        VBox theLable = new VBox();
    
        theLable.setStyle("-fx-background-color: #d9dfdf ;");
        Text courseNameAndSection = new Text(section.getCourseName()+"@");
        Text codText = new Text(section.getSectionCode());
    
        Text locationText = new Text(section.getLocation());
        Text timeText = new Text(section.getTime());
        Text dayText = new Text(section.getDay());
        // theLable.setTextFill(Paint.valueOf("black"));
        theLable.setPrefSize(150,90);
        // theLable.setFont(new Font("Arial", 17));
        // theLable.setAlignment(Pos.TOP_CENTER);
        theLable.getChildren().addAll(courseNameAndSection,codText,locationText,timeText,dayText);
    
        return theLable;
    
      }
      



      public static void main(String[] args) {
        ObservableList<Integer> numbers =  FXCollections.observableArrayList();

        for(int n: numbers){System.out.println(n);}
    //     // String n = "0800-0850";
    //     // System.out.println(readStartTime(n));
    String[] s1 = {"ICS 202-01","LEC","20502","Data Structures and Algorithms","HUSNI AL-MUHTASEB","UTR","0800-0850","22-125","Open","Closed"};
    String[] s2 = {"PHYS101-70","LAB","22041","General Physics I","None","W","0800-1040","None","Closed","Closed"};

    String[] s3 = {"ICS 108-06","LAB","22867","Object-Oriented Programming","RASHAD OTHMAN","MW","1530-1645","22-335","Closed","Open"

  };

    String[] s4 = {"ICS 104-04","LEC","22795","Introduction to Programming in Python and C","S ARAFAT","MW","0900-0950","24-120","Closed","Closed"
    };
    String[] s5 = {"PHYS102-01","REC","20086","General Physics II","RADITYA BOMANTARA","W","0800-0850","59-1005","Open","Closed"
    };
    String[] s6 = {"ICS 104-01","LEC","22785","Introduction to Programming in Python and C","M BALAH","UT","0800-0850","24-120","Closed","Open"
    };
    // Schedule schedule = new Schedule();

    Section sec1 = new Section(s1);
    Section sec2 = new Section(s2);
    Section sec3 = new Section(s3);
    Section sec4 = new Section(s4);
    Section sec5 = new Section(s5);
    Section sec6 = new Section(s6);
    // schedule.addCourse(sec6);
    // schedule.addCourse(sec5);
    // schedule.addCourse(sections3);
    // schedule.addCourse();
    System.out.println(sec6);
    System.out.println(sec5);
    System.out.println(sec1);
    System.out.println(sec1.readEndTime());
    System.out.println(sec1.readStartTime());
    // System.out.println(schedule.checkConflict(sec1));
    // System.out.println("UTR".contains("U"));

  



      }

      public void clear(){ 

      registeredSections.removeAll(registeredSections);
      basketSections.removeAll(basketSections);
      }

    

}


    // a method to count the time in minutes...
    // public static int readTime(Section section){
    //     String timeString = section.getTime();
    //     String[] timeList = timeString.split("-");
    //     String time1 = timeList[0]; 
    //     String time2 = timeList[1]; 

    //     if(time1.charAt(0) == '0'){
    //         time1 = time1.substring(1);
    //     }
    //     if(time2.charAt(0) == '0'){
    //         time2 = time2.substring(1);
    //     }

    //     int number1 = Integer.parseInt(time1);
    //     int number2 = Integer.parseInt(time2);

    //     int hourAndMinute = number2-number1;
    //     // as far as i know the least time is 50 minute
    //     if(hourAndMinute>50){
    //         String StringResult = Integer.toString(hourAndMinute);
    //         int hour = Integer.parseInt(StringResult.substring(0,1));
    //         int minutes = Integer.parseInt(StringResult.substring(1));
    //         int hourToMinutes = hour*60;
    //         return minutes+hourToMinutes;


    //     }
    //     else{
    //         return hourAndMinute;

    //     }

        
    
    
    //   }


    // public static int readStartTime(Section section){
        
    //     String array = section.getTime();
    //     String[] timeList = array.split("-");
    //     String timeString = timeList[0]; 
        
    //     if(timeString.charAt(0) == '0'){
    //         timeString = timeString.substring(1);
    //         int hour = Integer.parseInt(timeString.substring(0,1));
    //         int minutes = Integer.parseInt(timeString.substring(2));
    //         int finalResult = (minutes+hour*60)-425;
    //         if(finalResult==0){
    //             return 0;
    //         }
    //         else{
    //             return finalResult;
    //         }
    //     }
    //     else{
    //         int hour = Integer.parseInt(timeString.substring(0,2));
    //         int minutes = Integer.parseInt(timeString.substring(2));
    //         return (minutes+ hour*60)-425;
    //     }



    //   }
