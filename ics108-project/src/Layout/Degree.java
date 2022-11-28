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


public class Degree  extends Application{
    public Label label =new Label();
    public GridPane gride=new GridPane();
    public CheckBox box=new CheckBox();
    public String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"};
    public ComboBox<String> combo=new ComboBox<>();
    public void start(Stage primaryStage){
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
        


        degree.setTitle("COE flowchart");
        Image image= new Image("COE-Summer-New.png");
        degree.setImageView(new ImageView(image));
        Scene scene = new Scene(degree,600,600);
        primaryStage.setScene(scene);
     
        primaryStage.setTitle("Degree plan");
        primaryStage.show();


        


    }
    public void setTitle(String title){
        label.setText(title);
    }
    public void setImageView(ImageView picture){
        label.setGraphic(picture);
    }
}   
