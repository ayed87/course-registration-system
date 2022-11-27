package Layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;


public class Degree  extends BorderPane{
    public Label label =new Label();
    public GridPane gride=new GridPane();
    public CheckBox box=new CheckBox();
    public String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"};
    public ComboBox<String> combo=new ComboBox<>();
    public Degree(){
        label.setContentDisplay(ContentDisplay.TOP);
        label.setPrefSize(200,100 );
        
        ScrollPane scrollPane = new ScrollPane(gride);
        setLeft(label);
        setCenter(scrollPane);
        setPadding(new Insets(5,5,5,5));


        gride.setAlignment(Pos.CENTER);
        gride.setPadding(new Insets(11.5,12.5,13.5,14.5));
        gride.setHgap(5.5);
        gride.setVgap(5.5);
        
        //Subject column
        gride.add(new Label("Course"),0,1);
        gride.add(new Label("MATH101"),0,2);
        gride.add(new Label("PHYS101"),0,3);
        gride.add(new Label("CHEM101"),0,4);
        gride.add(new Label("ENGL101"),0,5);
        gride.add(new Label("ICS104"),0,6);
        gride.add(new Label("MATH102"),0,6);
        gride.add(new Label("PHYS102"),0,7);
        gride.add(new Label("ENGL102"),0,8);
        gride.add(new Label("ICS108"),0,9);
        gride.add(new Label("IAS101"),0,10);
        gride.add(new Label("PE101"),0,11);
        gride.add(new Label("MATH201"),0,12);
        gride.add(new Label("COE202"),0,13);
        gride.add(new Label("COE203"),0,14);
        gride.add(new Label("ISE291"),0,15);
        gride.add(new Label("ICS202"),0,16);
        gride.add(new Label("IAS121"),0,17);
        gride.add(new Label("STAT319"),0,18);
        gride.add(new Label("COE241"),0,19);
        gride.add(new Label("COE301"),0,20);
        gride.add(new Label("COE292"),0,21);
        gride.add(new Label("ICS253"),0,22);
        gride.add(new Label("MATH208"),0,23);
        gride.add(new Label("COE344"),0,24);
        gride.add(new Label("COE302"),0,25);
        gride.add(new Label("ENGL214"),0,26);
        gride.add(new Label("EE236"),0,27);
        gride.add(new Label("EE237"),0,28);
        gride.add(new Label("COE384"),0,29);
        gride.add(new Label("COE346"),0,30);
        gride.add(new Label("COE306"),0,31);
        gride.add(new Label("BUS200"),0,32);
        gride.add(new Label("CGS392"),0,33);
        gride.add(new Label("COE399"),0,34);
        gride.add(new Label("COE4XX"),0,35);
        gride.add(new Label("COE4XX"),0,36);
        gride.add(new Label("XXX"),0,37);
        gride.add(new Label("ICS433"),0,38);
        gride.add(new Label("IAS212"),0,39);
        gride.add(new Label("COE485"),0,40);
        gride.add(new Label("COE4XX"),0,41);
        gride.add(new Label("COE4XX"),0,42);
        gride.add(new Label("COE4XX"),0,43);
        gride.add(new Label("IASXX"),0,44);
        gride.add(new Label("GSXXX"),0,45);
        
        

        //cerdit column
        gride.add(new Label("Cerdit"),1,0);
        gride.add(new Label("4"),1,1);
        gride.add(new Label("4"),1,2);
        gride.add(new Label("4"),1,3);
        gride.add(new Label("3"),1,4);
        gride.add(new Label("3"),1,5);
        gride.add(new Label("4"),1,6);
        gride.add(new Label("4"),1,7);
        gride.add(new Label("3"),1,8);
        gride.add(new Label("4"),1,9);
        gride.add(new Label("2"),1,10);
        gride.add(new Label("1"),1,11);
        gride.add(new Label("3"),1,12);
        gride.add(new Label("3"),1,13);
        gride.add(new Label("1"),1,14);
        gride.add(new Label("3"),1,15);
        gride.add(new Label("4"),1,16);
        gride.add(new Label("2"),1,17);
        gride.add(new Label("3"),1,18);
        gride.add(new Label("3"),1,19);
        gride.add(new Label("4"),1,20);
        gride.add(new Label("3"),1,21);
        gride.add(new Label("3"),1,22);
        gride.add(new Label("3"),1,23);
        gride.add(new Label("4"),1,24);
        gride.add(new Label("3"),1,25);
        gride.add(new Label("3"),1,26);
        gride.add(new Label("3"),1,27);
        gride.add(new Label("1"),1,28);
        gride.add(new Label("4"),1,29);
        gride.add(new Label("3"),1,30);
        gride.add(new Label("3"),1,31);
        gride.add(new Label("3"),1,32);
        gride.add(new Label("1"),1,33);
        gride.add(new Label("no cerdit"),1,34);
        gride.add(new Label("3"),1,35);
        gride.add(new Label("3"),1,36);
        gride.add(new Label("3"),1,37);
        gride.add(new Label("3"),1,38);
        gride.add(new Label("2"),1,39);
        gride.add(new Label("3"),1 ,40);
        gride.add(new Label("3"),1,41);
        gride.add(new Label("3"),1,42);
        gride.add(new Label("3"),1,43);
        gride.add(new Label("2"),1,44);
        gride.add(new Label("3"),1,45);
        
        //checkbox column
        gride.add(new Label("Taken"),2,0);
        gride.add(new CheckBox(),2,1);
        gride.add(new CheckBox(),2,2);
        gride.add(new CheckBox(),2,3);
        gride.add(new CheckBox(),2,4);
        gride.add(new CheckBox(),2,5);
        gride.add(new CheckBox(),2,6);
        gride.add(new CheckBox(),2,7);
        gride.add(new CheckBox(),2,8);
        gride.add(new CheckBox(),2,9);
        gride.add(new CheckBox(),2,10);
        gride.add(new CheckBox(),2,11);
        gride.add(new CheckBox(),2,12);
        gride.add(new CheckBox(),2,13);
        gride.add(new CheckBox(),2,14);
        gride.add(new CheckBox(),2,15);
        gride.add(new CheckBox(),2,16);
        gride.add(new CheckBox(),2,17);
        gride.add(new CheckBox(),2,18);
        gride.add(new CheckBox(),2,19);
        gride.add(new CheckBox(),2,20);
        gride.add(new CheckBox(),2,21);
        gride.add(new CheckBox(),2,22);
        gride.add(new CheckBox(),2,23);
        gride.add(new CheckBox(),2,24);
        gride.add(new CheckBox(),2,25);
        gride.add(new CheckBox(),2,26);
        gride.add(new CheckBox(),2,27);
        gride.add(new CheckBox(),2,28);
        gride.add(new CheckBox(),2,29);
        gride.add(new CheckBox(),2,30);
        gride.add(new CheckBox(),2,31);
        gride.add(new CheckBox(),2,32);
        gride.add(new CheckBox(),2,33);
        gride.add(new CheckBox(),2,34);
        gride.add(new CheckBox(),2,35);
        gride.add(new CheckBox(),2,36);
        gride.add(new CheckBox(),2,37);
        gride.add(new CheckBox(),2,38);
        gride.add(new CheckBox(),2,39);
        gride.add(new CheckBox(),2,40);
        gride.add(new CheckBox(),2,41);
        gride.add(new CheckBox(),2,42);
        gride.add(new CheckBox(),2,43);
        gride.add(new CheckBox(),2,44);
        gride.add(new CheckBox(),2,45);


        //Grades column
        //gride.add(new Label("Grades"),3,0);
        //gride.add(new CheckBox(),3,1);
        //gride.add(new CheckBox(),3,2);
        //gride.add(new CheckBox(),3,3);
        //gride.add(new CheckBox(),3,4);
        //gride.add(new CheckBox(),3,5);
       // gride.add(new CheckBox(),3,6);
      //  gride.add(new CheckBox(),3,7);
     //   gride.add(new CheckBox(),3,8);
       // gride.add(new CheckBox(),3,9);
       // gride.add(new CheckBox(),3,10);
    //    gride.add(new CheckBox(),3,11);
      //  gride.add(new CheckBox(),3,12);
        //gride.add(new CheckBox(),3,13);
    //    gride.add(new CheckBox(),3,14);
    //    gride.add(new CheckBox(),3,15);
    //    gride.add(new CheckBox(),3,16);
    // /   gride.add(new CheckBox(),3,17);
     //   gride.add(new CheckBox(),3,18);
      //  gride.add(new CheckBox(),3,19);
        //gride.add(new CheckBox(),3,20);
       // gride.add(new CheckBox(),3,21);
       // gride.add(new CheckBox(),3,22);
       // gride.add(new CheckBox(),3,23);
       // gride.add(new CheckBox(),3,24);
        //gride.add(new CheckBox(),3,25);
        //gride.add(new CheckBox(),3,26);
        //gride.add(new CheckBox(),3,27);
        //gride.add(new CheckBox(),3,28);
        //gride.add(new CheckBox(),3,29);
        //gride.add(new CheckBox(),3,30);
        //gride.add(new CheckBox(),3,31);
        //gride.add(new CheckBox(),3,32);
        //gride.add(new CheckBox(),3,33);
        //gride.add(new CheckBox(),3,34);
        //gride.add(new CheckBox(),3,35);
        //gride.add(new CheckBox(),3,36);
       // gride.add(new CheckBox(),3,37);
        //gride.add(new CheckBox(),3,38);
        //gride.add(new CheckBox(),3,39);
        //gride.add(new CheckBox(),3,40);
        //gride.add(new CheckBox(),3,41);
        //gride.add(new CheckBox(),3,42);
        //gride.add(new CheckBox(),3,43);
        //gride.add(new CheckBox(),3,44);
        //gride.add(new CheckBox(),3,45);
        setRight(gride);


        


    }
    public void setTitle(String title){
        label.setText(title);
    }
    public void setImageView(ImageView picture){
        label.setGraphic(picture);
    }
}   
