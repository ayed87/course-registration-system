package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Student {

    private ArrayList<Course> courses;

    private ArrayList<Section> allSections = new ArrayList<> (); 
    private ArrayList<Section> satisfyingConditionsSections = new ArrayList<>(); 
    private ArrayList<Section> showSections = new ArrayList<>();
    private int finishedCredits;


    public void readAllSections(BufferedReader courseOfferingScanner){ 

       try{
        courseOfferingScanner.readLine(); // no need for first line
        String line = "";

        while((line = courseOfferingScanner.readLine()) != null ){ 

            String[] lineList =line.split(",");
            Section section = new Section(lineList); 
            allSections.add(section);
        }

    }
    catch(IOException e){System.out.println(e);}

    }
    

    public int getNumberOfSections(){ 
        return allSections.size();
    }



    
    }


    




    
    

