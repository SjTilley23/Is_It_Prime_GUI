package com.example.project_8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import java.io.IOException;

//Samuel Tilley, Ciss-111-300, Program 07
public class TilleySamuelProgram07 extends Application {
    TextField iTextField;
    TextField oTextField;

    @Override
    public void start(Stage stage) throws IOException {

        //Setting Title
        stage.setTitle("Is it a Prime Number?");

        //Creating the button and label objects and defining the text field objects
        Button pbutton = new Button("Process Input");
        Button cbutton = new Button("Cancel");
        Label label = new Label("Number:");
        iTextField = new TextField();
        iTextField.setText("Enter a Number");
        oTextField = new TextField();

        //Creates the Grid pane and defines its features
        GridPane gridPane = new GridPane();
        gridPane.setHgap(4);
        gridPane.setVgap(4);
        gridPane.setAlignment(Pos.CENTER);

        //Adds our Objects to the Gridpane
        gridPane.add(label,0,0);
        gridPane.add(iTextField,1,0);
        gridPane.add(pbutton,0,1);
        gridPane.add(oTextField,1,1);
        gridPane.add(cbutton,0,2);

        //Uses handler to handle button clicks
        pbutton.setOnAction(new ProcessButtonHandler());
        cbutton.setOnAction(new CancelButtonHandler());

        //Sets the scene and renders
        Scene scene = new Scene(gridPane,300,200);
        stage.setScene(scene);
        stage.show();
    }

    //Handler if Process Number button is pressed
    private class ProcessButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try{
                int userInput = Integer.parseInt(iTextField.getText());

                //Throws exception if number is negative or 0
                if (userInput < 1) {
                    throw new Exception();
                }

                //If input is 1 says not prime
                if (userInput == 1) {
                    oTextField.setText(userInput + " is not prime");
                }

                //Brute forces to find prime numbers
                for (int i = 2; i <= userInput; i++) {
                    if (userInput == i) {
                        oTextField.setText(userInput + " is prime");
                    } else if (userInput % i == 0) {
                        oTextField.setText(userInput + " is not prime");
                        break;
                    }
                }
            }
            //Catches exceptions
            catch (Exception e) {
                oTextField.setText("That is not a Valid Input");
            }
        }
    }

    //Handler if Cancel button is pressed
    private class CancelButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
        }
    }

    //Main method
    public static void main(String[] args) {
        launch();
    }
}