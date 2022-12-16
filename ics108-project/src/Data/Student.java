package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import org.w3c.dom.events.Event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.print.Printer;
import javafx.scene.control.ListView;



// zyad
public class Student {

    private ArrayList<Course> allCourses = new ArrayList<>() ;
    private ArrayList<FinishedCourse> finishedCourses = new ArrayList<>();
    private ArrayList<Course> canBeTakenCourses = new ArrayList<>();
    private ArrayList<Section> allSections = new ArrayList<> ();
    private ArrayList<Section> canBeTakSections = new ArrayList<>();
    private ObservableList<Section> shownSections ;
    private ObservableList<Section> basket = FXCollections.observableArrayList();
    
    



    // readin the file and creating objects for sections 
    public void readAllSections(BufferedReader buff){ 

       try{
        buff.readLine(); // no need for first line
        String line = "";

        while((line = buff.readLine()) != null ){ 

            String[] lineList =line.split(",");
            Section section = new Section(lineList); 
            allSections.add(section);
        }

    }
    catch(IOException e){System.out.println(e);}

    }

    
    public void addFinshedCourse(FinishedCourse finishedCourse){
        finishedCourses.add(finishedCourse);
    }
    public void removeFinshedCourse(FinishedCourse finishedCourse){
        finishedCourses.remove(finishedCourse);
    }
     
    public void removeCourse(Section section){
        basket.remove(section);
    }

    public ArrayList<Section> getCanBeTakSections() {
        return canBeTakSections;
    }

   

// reading the file and creating objects for  courses
    public void readAllCourse(BufferedReader buff){ 

        try{
         buff.readLine(); // no need for first line
         String line = "";
 
         while((line = buff.readLine()) != null ){ 
 
             String[] lineList =line.split(",");
             Course course = new Course(lineList); 
             allCourses.add(course);
         }
 
     }
     catch(IOException e){System.out.println(e);}
 
     }

     // reading the file and creating objects for finished courses
     public void readAllFinishedCourses(BufferedReader buff){ 

        try{
         buff.readLine(); // no need for first line
         String line = "";
 
         while((line = buff.readLine()) != null ){ 
 
             String[] lineList =line.split(",");
             FinishedCourse finishedCourse = new FinishedCourse(lineList); 
             finishedCourses.add(finishedCourse);
         }
 
     }
     catch(IOException e){System.out.println(e);}
 
     }

     // updating the finished courses 
     public void updateFinishedCourses(BufferedReader buff){ 

        finishedCourses.removeAll(finishedCourses); 
        readAllFinishedCourses(buff);
     }


    public int getNumberOfSections(){ 
        return allSections.size();
    }
    public ArrayList<FinishedCourse> getFinishedCourses() {
        return finishedCourses;
    }

    public int getNumberOfCourses(){ 
        return allCourses.size();
    }

    public int getNumberOfFinishedCourse(){ 
        return finishedCourses.size();
    }



    
    // A method to find the courses that its prerequisite is satisfied, and its corequisite are taken or can be taken know
    // for example,COE203 can be taken only when COE202 is finished or can be taken now 
    public void findCanBeTakenCourses(){ 

        // to iterate over each course
        for(int i =0 ; i <allCourses.size(); i++){ 

            // assumptions
            boolean taken = false; 
            boolean prerequisiteSatisfied = true; 


            // to check whether the course is taken or not 
            for(int j=0; j <finishedCourses.size(); j++){ 

                // comparing the codes of the course with the finshed courses code
                if(allCourses.get(i).getCourseCode().equals( finishedCourses.get(j).getCourseCode())){ 

                    taken = true; // no need to break since the course are unique 
                }

            }

            if(!taken){ // if the course is no taken 


                // when the course has prerequisite
                if( !( allCourses.get(i).getPrerequisite()[0].equals( "None"))){  // use equals

                    // assumption 
                  boolean  previousPrerequisiteSatisfied = true; 

                  // to iterate over each prerequisite, can be entered onlyy when the previous prerequisite is satisfied
                    for(int j =0 ; j < allCourses.get(i).getPrerequisite().length && previousPrerequisiteSatisfied; j++ ){
                        previousPrerequisiteSatisfied = false;


                        // to iterate over all finshed courses
                        for(int k = 0; k < finishedCourses.size(); k++){ 

                            // comparing the prerequesite with the finished ccourses name 
                            if(allCourses.get(i).getPrerequisite()[j].equals(finishedCourses.get(k).getCourseCode() )){ 

                               previousPrerequisiteSatisfied= true; // no need fo break since it is unique
                            }
                        }

                    }

                    if(! previousPrerequisiteSatisfied){ 

                        prerequisiteSatisfied = false;


                    }

                }


                
            }


            if(!taken && prerequisiteSatisfied){ 

                canBeTakenCourses.add(allCourses.get(i));
            }

        }

        // to cehck whether the corequeisite exist in the list or not 
        for(int i=0 ;i<canBeTakenCourses.size(); i++){ 
            boolean corequeisiteSatisfied = true;
            
    
            if( !( canBeTakenCourses.get(i).getCorequisite()[0].equals( "None"))){ 
    
                boolean previousCorequisiteSatisfied = true;
                boolean previousCorequisiteFinished = true;
    
                for(int j=0; j< canBeTakenCourses.get(i).getCorequisite().length && (previousCorequisiteSatisfied || previousCorequisiteFinished); j++){ 
    
                    // when the corequisist is taken
    
                    if(previousCorequisiteFinished){ 
    
                        previousCorequisiteFinished = false;
                        for(int k = 0; k < finishedCourses.size(); k++){ 
    
                            // comparing the prerequesite with the finished ccourses name 
                            if(canBeTakenCourses.get(i).getCorequisite()[j].equals(finishedCourses.get(k).getCourseCode() )){ 
    
                               previousCorequisiteFinished= true; // no need fo break since it is unique
                            }
                        }
    
    
                    }
    
                    if(previousCorequisiteSatisfied){
    
                        previousCorequisiteSatisfied = false;
    
                        for(int k =0 ; k < canBeTakenCourses.size(); k++){ 
                             if(canBeTakenCourses.get(i).getCorequisite()[j].equals(canBeTakenCourses.get(k).getCourseCode() ))
                                 previousCorequisiteSatisfied = true;
    
                
                        }
                    }
    
                    if( ! (previousCorequisiteSatisfied || previousCorequisiteFinished))
                         corequeisiteSatisfied= false; 
    
                }
            }
    
    
    
            if(! corequeisiteSatisfied){ 
    
                canBeTakenCourses.remove(i); 
            canBeTakenCourses.trimToSize();
            }
        }

       
       
}

// to find the section the students can be taken 
public void findCanBeTakenSections(){ 

    for(int i=0 ; i< allSections.size(); i++){ 

        for(int j =0 ; j < canBeTakenCourses.size(); j++){ 

            if(allSections.get(i).getCourseCode().equals(canBeTakenCourses.get(j).getCourseCode())){ 

                canBeTakSections.add(allSections.get(i));
            }
            
        }
       
        
    }
}

// to update can be taken courses
public void updateCanBeTakenCourses(){ 

    canBeTakenCourses.removeAll(canBeTakenCourses);
    findCanBeTakenCourses();
}

// to update can be taken sections
public void updateCanBeTakenSections(){ 

    canBeTakSections.removeAll(canBeTakSections);
    findCanBeTakenSections();
}

public ArrayList<Course> getCanBeTakenCourses(){ 
    return canBeTakenCourses;
}



// to get the departments name from can be taken caourses
public String[] getDepartments(){ 

    ArrayList<String> departments = new ArrayList<>(); 
    departments.add("All");

    for(int i=0 ; i< canBeTakSections.size(); i++){ 

        if(!( departments.contains(canBeTakSections.get(i).getDepartment()))){

            departments.add(canBeTakSections.get(i).getDepartment());
        }
    }

    String[] departmentsArray = new String[departments.size()];
    for(int i=0 ; i< departments.size(); i++){ 

        departmentsArray[i] = departments.get(i);
    }


    return departmentsArray;

   


}

// to get the courses name from can be taken caourses based on department selection
public String[] getCoursesForDepartment(String department){

    ArrayList<String> departmentCourses = new ArrayList<>();
    departmentCourses.add("All");

    if( department.equals("All")){ 
   
    for(int i=0 ; i< canBeTakenCourses.size(); i++){ 

       
       
        if(!( departmentCourses.contains(canBeTakenCourses.get(i).getCourseCode()))){

            departmentCourses.add(canBeTakenCourses.get(i).getCourseCode());
        }
    
    }

}

else{

    for(int i=0 ; i< canBeTakenCourses.size(); i++){ 

        if(canBeTakenCourses.get(i).getCourseCode().contains(department)){
       
       
            if(!( departmentCourses.contains(canBeTakenCourses.get(i).getCourseCode()))){

                departmentCourses.add(canBeTakenCourses.get(i).getCourseCode());
            }

         }
    }

}

    String[] coursesArray = new String[departmentCourses.size()];
    for(int i=0 ; i< departmentCourses.size(); i++){ 

        coursesArray[i] = departmentCourses.get(i);
    }


    return coursesArray;



}


// to get the sections that can be shown based on the deoartment and course selection
public void findShownSections(String department, String course){ 

     ArrayList<Section> selectedSections= new ArrayList<>(); 

    if(course.equals("All") && department.equals("All")){ 

        for(int i=0 ; i< canBeTakSections.size(); i++){ 

            if(! (selectedSections.contains(canBeTakSections.get(i)))){ 

                selectedSections.add(canBeTakSections.get(i)); 
            }
        }
    }

    else if( course.equals("All") && ! department.equals("All")){ 

        for(int i=0 ; i< canBeTakSections.size(); i++){ 

            if(canBeTakSections.get(i).getDepartment().equals(department)){ 

                selectedSections.add(canBeTakSections.get(i)); 
            }
        }


    }


    else{ 

        for(int i=0 ; i< canBeTakSections.size(); i++){ 

            if(canBeTakSections.get(i).getCourseCode().equals(course)){ 

                selectedSections.add(canBeTakSections.get(i));
            }
        }

        
    }

    shownSections = FXCollections.observableArrayList(selectedSections);

    
   
}


public ObservableList<Section> getShownSections(){ 

    return shownSections;
}

public ObservableList<Section> getBasket(){ 
    return basket;
}

// a method for the event in the list view of available sections 
public void clickOnSectionList(ListView<Section> listView){

    basket.add(listView.getSelectionModel().getSelectedItem());
    shownSections.remove(listView.getSelectionModel().getSelectedItem());
    


}

// a method for the event in the list view of taken sections 
public void clickOnBasketList(ListView<Section> listView){ 

    shownSections.add(listView.getSelectionModel().getSelectedItem());
    basket.remove(listView.getSelectionModel().getSelectedItem());
}
// to get all courses
public ArrayList<Course> getCourseArray(){
    return allCourses;
}


}






    



   



        
    


    




    
    

