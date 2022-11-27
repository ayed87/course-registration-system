

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Basket extends Application {
    
    public void start(Stage primaryStage) {

        // Pane used 
        BorderPane borderPane = new BorderPane();

      

        // Buttons to move between scenes
        Button previous = new Button("Previous");
        Button next =new Button("Next"); 

        previous.setMinSize(100, 20);
        next.setMinSize(100, 20);

        HBox hBox = new HBox(); 

        hBox.getChildren().addAll(previous,next); 

        hBox.setSpacing(100);

        hBox.setAlignment(Pos.CENTER);

        borderPane.setBottom(hBox);


        // Choice boxes to select department and courses

        Label department = new Label("Select Department: "); 
        Label courses = new Label("Select Course: ");
        ChoiceBox departmentChoice = new ChoiceBox<>();
        ChoiceBox coursesChoice = new ChoiceBox<>(); 

        departmentChoice.setPrefSize(100,10);
        coursesChoice.setPrefSize(100, 10);

        HBox departmentBox = new HBox(); 

        departmentBox.getChildren().addAll(department,departmentChoice);

        departmentBox.setSpacing(10);

        HBox courseBox = new HBox(); 

        courseBox.getChildren().addAll(courses,coursesChoice);
        
        courseBox.setSpacing(38);

        HBox coursesSelectionBox = new HBox(); 

        coursesSelectionBox.getChildren().addAll(departmentBox,courseBox);
        
        coursesSelectionBox.setSpacing(100);

        Label header = new Label("Sections' Basket"); 
        
        header.setFont(new Font("Arial", 30));

        header.setStyle(Styles.green());

       

        

        

        

        VBox topPart = new VBox(); 

        

        topPart.getChildren().addAll(header,coursesSelectionBox);

        topPart.setAlignment(Pos.CENTER);

        topPart.setSpacing(40);

        

      

        

        borderPane.setTop(topPart);

        // courses select list, need more improvement

        ScrollPane listScroll = new ScrollPane();
        listScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        ObservableList<String> books = FXCollections.observableArrayList(" Section 1   ICS108  UTR  7:00 - 7:50");
        ListView<String> sectionListView = new ListView<String>(books);

        listScroll.setContent(sectionListView);

       
        listScroll.setFitToWidth(true);

        

       

        borderPane.setCenter(listScroll);





        


        Scene scene1 = new Scene(borderPane,1000,500);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }

   
    
}
