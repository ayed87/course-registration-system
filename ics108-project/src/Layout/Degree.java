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
import java.net.URI;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Parent;


public class Degree extends Application{
    Button b6 = new Button("Next");
    Button b7 = new Button("Back");
    Button b8 = new Button("Save the changes");
    public void start(Stage primaryStage) throws Exception {
        Label label =new Label();
        CheckBox taken= new CheckBox("Taken");
        // GridPane gride=new GridPane();
        // ScrollPane scrollPane = new ScrollPane(gride);
                // gride.setAlignment(Pos.CENTER);
        // gride.setPadding(new Insets(11.5,12.5,13.5,14.5));
        // gride.setHgap(5.5);
        // gride.setVgap(5.5);
        // ComboBox<String> combo=new ComboBox<>();


        

        // Image flowChartImage = new Image("COE-Summer-New.png");
        //vbox for the left side which have flowchart and a title
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        Label label2 = new Label("ICS flowchart");

        label2.setFont(new Font("Arial", 30));
        label2.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView();
        Image flowChartImage = new Image("http://www.kfupm.edu.sa/departments/ics/PublishingImages/Pages/Forms/AllItems/BS_CS_summerTraining.JPG");

        imageView.setImage(flowChartImage);
        
        vBox1.getChildren().addAll(label2,imageView);

  
        

        // My goal to make vboxs inside a single hbox in right side

        // vbox for class
        VBox vbox2= new VBox();
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(5,5,5,5));
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(new Label("ics104"),new Label("ics108"));
        

        // credit 
        VBox vbox3= new VBox();
        vbox3.setSpacing(10);
        vbox3.setPadding(new Insets(5,5,5,5));
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().addAll(new Label("3"),new Label("4"));
        
        //checkbox
        VBox vbox4= new VBox();
        vbox4.setSpacing(10);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().add(taken);



        HBox Rightpart= new HBox();
        vbox4.setSpacing(10);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(vbox2,vbox3,vbox4);

        // hbox for button
        HBox buttonClick= new HBox();
        vbox4.setSpacing(10);
        vbox4.setPadding(new Insets(5,5,5,5));
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().addAll(b6,b7,b8);
        
        //courseDiscribtBox.setStyle(Styles.blue());


        //HBox mainArea = new HBox();
        
        //mainArea.setSpacing(30);

        //mainArea.getChildren().addAll(vBox1,courseDiscribtBox);
        //Scene scene = new Scene(mainArea);

        

        
        //String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"};   
        BorderPane paneDegree= new  BorderPane();
        paneDegree.setLeft(vBox1);   
        paneDegree.setRight(Rightpart);  
        paneDegree.setBottom(buttonClick); 
        
        Scene scene2=new Scene(paneDegree,900,900);



        primaryStage.setTitle("Degree Plan");
        primaryStage.setScene(scene2);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch();
    }


        
}



