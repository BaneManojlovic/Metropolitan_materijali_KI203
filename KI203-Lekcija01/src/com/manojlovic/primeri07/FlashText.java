/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri07;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author manojlovic
 */
public class FlashText extends Application{
    
    private String text = " ";
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        Label labela = new Label("Jedite kod Dzoa!");
        
        pane.getChildren().add(labela);

        new Thread(() -> { // lambda izraz
            try {
                while (true) {
                    if (labela.getText().trim().length() == 0) {
                        text = "Jedite kod Dzoa!";
                    } else {
                        text = "";
                    }
                    Platform.runLater(() -> labela.setText(text)); // lambda izraz
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
            }
        }).start();

        Scene scena = new Scene(pane, 250, 150);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Primer Teksta");
        primaryStage.centerOnScreen();
        primaryStage.show();
    } 
}