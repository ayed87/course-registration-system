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
    
    public void start(Stage primaryStage) throws Exception {
        Label label =new Label();
        // GridPane gride=new GridPane();
        // ScrollPane scrollPane = new ScrollPane(gride);
                // gride.setAlignment(Pos.CENTER);
        // gride.setPadding(new Insets(11.5,12.5,13.5,14.5));
        // gride.setHgap(5.5);
        // gride.setVgap(5.5);
        // ComboBox<String> combo=new ComboBox<>();


        CheckBox box=new CheckBox();

        // Image flowChartImage = new Image("COE-Summer-New.png");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        Label label2 = new Label("course offring");

        label2.setFont(new Font("Arial", 30));
        label2.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView();
        Image flowChartImage = new Image("http://www.kfupm.edu.sa/departments/ics/PublishingImages/Pages/Forms/AllItems/BS_CS_summerTraining.JPG");

        imageView.setImage(flowChartImage);
        
        vBox1.getChildren().addAll(label2,imageView);

  
        



        // k 
        HBox hbox2= new HBox();
        hbox2.setSpacing(10);
        hbox2.setPadding(new Insets(5,5,5,5));
        hbox2.setAlignment(Pos.CENTER);
        //hbox2.getChildren().add();
        //hbox2.getChildren().add(b4);



        HBox courseDiscribtBox = new HBox();
        
        courseDiscribtBox.setStyle(Styles.blue());


        HBox mainArea = new HBox();
        
        mainArea.setSpacing(30);

        mainArea.getChildren().addAll(vBox1,courseDiscribtBox);
        Scene scene = new Scene(mainArea);

        

        
        String[] grade= {"+A","A","+B","B","+C","C","+D","D","F"};

        BorderPane paneDegree= new  BorderPane();

        



        primaryStage.setTitle("Degree Plan");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch();
    }


        
}



