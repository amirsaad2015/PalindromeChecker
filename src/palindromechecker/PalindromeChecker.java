/*
Author: Amir Saad
This program checks to see if your word is a palindrome
*/

package palindromechecker;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PalindromeChecker extends Application {
    //Initialize public nodes
    TextField name;
    Label label;
    String str;
    
    @Override
    public void start(Stage primaryStage) {
        //Create grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        
        //Create TextField
        name = new TextField();
        name.setPromptText("Enter your word.");
        name.setPrefColumnCount(10);
        name.getText();
                
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);
        
        //Create submit button
        Button submit = new Button("Submit");
        submit.setOnAction(new SubmitEvent());
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);
        
        //Create delete button
        Button clear = new Button("Clear");
        clear.setOnAction(new ClearEvent());
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        
        //Create label
        label = new Label();
        GridPane.setConstraints(label, 0, 1);
        grid.getChildren().add(label);
        
        //Set the scene
        Scene scene = new Scene(grid, 230, 100);
        
        //Set the stage
        primaryStage.setTitle("Palindrome Checker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class ClearEvent implements EventHandler {

        @Override
        //Create event for when user wants to delete contents
        public void handle(Event event) {
            label.setText(null);
        }
    }
    
    class SubmitEvent implements EventHandler {

        @Override
        //Create event for when user clicks on submit button
        public void handle(Event event) {
     
            str = name.getText();

            if(!str.isEmpty()) {
              boolean test = isPalindrome(str);
                if(test == true) {
                    label.setText("Your word is a palindrome.");
                } else {
                    label.setText("Your word is not a palindrome.");
                }
            } else {
                label.setText("No input read.");
            }
            name.clear();
        }
    }
    
    public static boolean isPalindrome(String str) {
        //Method to check if string is a palindrome
        char[] array = str.toCharArray();
        int j = array.length - 1;
        
        for(int i = 0; i < j; i++, j--) {
            if(array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
