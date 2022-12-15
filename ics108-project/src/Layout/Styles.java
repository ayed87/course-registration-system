package Layout;
// this class is for clors and designs

import java.util.Random;

import javafx.scene.control.skin.ChoiceBoxSkin;

public class Styles {
    static String[] courseColors = {
        "-fx-background-color: #7C2D12; -fx-background-radius: 6 ",

        "-fx-background-color: #1C1917; -fx-background-radius: 6; ",
        "-fx-background-color: #14532D; -fx-background-radius: 6; ",
        "-fx-background-color: #0C4A6E; -fx-background-radius: 6; ",
        "-fx-background-color: #581C87; -fx-background-radius: 6; ",
        "-fx-background-color: #831843; -fx-background-radius: 6; ",
        "-fx-background-color: #713F12; -fx-background-radius: 6; ",
        "-fx-background-color: #7F1D1D; -fx-background-radius: 6; "
    };
    public static String mainStyle(){
        return "-fx-background-color: #D7F4F4;";
    }
    public static String mainStyleDark(){
        return "-fx-background-color: #33B6B6;";
    }
    
    public static String daysStyle(){
        return "-fx-background-color: #175252; -fx-text-fill: white; ";
    }
    public static String green(){
        return "-fx-background-color: green;";
    }
    public static String pink(){
        return "-fx-background-color: pink;";
    }
    public static String blue(){
        return "-fx-background-color: blue;";
    }
    public static String v(){
        return """
            -fx-background-color: #39CCCC ; 
            -fx-text-fill: white; 
                
                """;
    }
    // to picck a color for sections that are rigesterd
    public static String pickColor(){
        Random random = new Random();
        int chosedColorindex = random.nextInt(courseColors.length-1);
        return courseColors[chosedColorindex];
    }
    public static String backButtonStyle(){
        return """
            -fx-background-color: #873838 ; 
            -fx-border-radius: 15;
            -fx-text-fill: white;
            -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );
            -fx-font: bold italic 8pt "Arial";
                
                """;
    } 
    public static String nextButtonStyle(){
        return """
            -fx-background-color: #385F87 ; 
            -fx-border-radius: 15;
            -fx-text-fill: white;
            -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );
            -fx-font: bold italic 8pt "Arial";
                
                """;
    } 
    public static String saveButtonStyle(){
        return """
            -fx-background-color: #B387C4 ; 
            -fx-border-radius: 15;
            -fx-text-fill: white;
            -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );
            -fx-font: bold italic 8pt "Arial";
                
                """;
    }
    public static String buttonsStyle(){
        return """
            -fx-background-color: #D7F4F4,
            linear-gradient(#d6d6d6 50%, white 100%),
            radial-gradient(center 50% -40%, radius 200%, #D7F4F4 45%, D7F4F4 80%);
            -fx-background-radius: 30;
            -fx-background-insets: 0,1,1;
            -fx-text-fill: black;
            -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );
                """;
    }

    public static void main(String[] args) {

        System.out.println(pickColor());
    }
} 


// #1C1917
// #14532D
// #0C4A6E
// #581C87
// #831843
// #713F12
// #7F1D1D
