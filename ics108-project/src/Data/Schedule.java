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

    private String term;
    private ArrayList<Section> registeredSections = new ArrayList<>();
    private ArrayList<Section> basketSections = new ArrayList<>();
    // int registeredCredits;
    private Pane weekDaysPane;
    
    
    
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

    
      public void addRigesterdSection(Section section){
        registeredSections.add(section);
        
      }

      public void removeCourse(Section section){
        registeredSections.remove(section);
      }
      public void retrunToBasket(Section section){
        basketSections.add(section);
      }
      public void removeSectionFromBasket(Section section){
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

        for(Section eachSection: registeredSections){
            if(eachSection.getDay().equals(section.getDay())|| section.getDay().contains(eachSection.getDay()) || eachSection.getDay().contains(section.getDay())){
                Section[] sections = new Section[2];
                sections[0] = eachSection;
                sections[1] = section;
                Arrays.sort(sections);
                if(sections[0].readEndTime()>sections[1].readStartTime()){
                    return false;
                }

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
      // it will create a vbox that will be used in plane scene
      public static VBox createCourseLabel(Section section){
        VBox theLable = new VBox();
    
        theLable.setStyle("-fx-background-color: #d9dfdf ;");
        Text courseNameAndSection = new Text(section.getCourseName()+"@");
        Text codText = new Text(section.getSectionCode());
    
        Text locationText = new Text(section.getLocation());
        Text timeText = new Text(section.getTime());
        Text dayText = new Text(section.getDay());
        theLable.setPrefSize(150,90);

        theLable.getChildren().addAll(courseNameAndSection,codText,locationText,timeText,dayText);
    
        return theLable;
    
      }
      

      public void clear(){ 

      registeredSections.removeAll(registeredSections);
      basketSections.removeAll(basketSections);
      }

    

}





