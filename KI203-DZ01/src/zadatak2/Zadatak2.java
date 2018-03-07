/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 *
 * @author Branislav
 */
public class Zadatak2 extends Application{

    private String tekst = " ";
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane paneOrigin = new BorderPane();
         
        StackPane pane1 = new StackPane();
        Label labela1 = new Label("Jedite kod Džoa!");
        labela1.setPadding(new Insets(20, 20, 20, 20));
        labela1.setFont(new Font("Arial", 30));
        pane1.getChildren().add(labela1);
        //----------------------------------------------------------------------
        StackPane pane2 = new StackPane();
        Label labela2 = new Label("NE Jedite kod Džoa!");
        labela2.setPadding(new Insets(20, 20, 20, 20));
        labela2.setFont(new Font("Arial", 30));
        pane2.getChildren().add(labela2);
        //----------------------------------------------------------------------
        StackPane pane3 = new StackPane();
        Label labela3 = new Label("Ipak Jedite kod Džoa!");
        labela3.setPadding(new Insets(20, 20, 20, 20));
        labela3.setFont(new Font("Arial", 30));
        pane3.getChildren().add(labela3);
        
       //kreiram prvu nit-------------------------------------------------------
       new Thread(new Runnable(){
           //prvi zadatak - blinkanje teksta 
           @Override
           public void run(){
               try{
               while(true){
                   if(labela1.getText().trim().length() == 0){
                       tekst = "Jedite kod Džoa!";
                   }else{
                       tekst = " ";
                        }

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                labela1.setText(tekst);
                            }
                        });

                        Thread.sleep(500);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }).start();
       
       //kreiram drugu nit -----------------------------------------------------
        new Thread(new Runnable(){
           //drugi zadatak - rotacija labele
            @Override
            public void run() {
                try {
                    while (true) {
                        labela2.getTransforms().add(new Rotate(30, 150, 30));
                        Thread.sleep(100);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }).start();
        
       //kreiram trecu nit -----------------------------------------------------
      new Thread(new Runnable(){
          //treci zadatak - nasumicna promena boje teksta u labeli
           @Override
           public void run(){
               try{
               while(true){
                   if(labela3.getText().trim().length() == 0){
                       Random rnd = new Random();
                       labela3.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                       tekst = "Ipak Jedite kod Džoa!";
                   }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                labela3.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                                tekst = "Ipak Jedite kod Džoa!";
                            }
                        });
                        Thread.sleep(300);
                    }
                } catch (InterruptedException ex) {
                }               
            }
        }).start();
       
        //redjam elemente na osnovnu pozadinu (paneOrigin)
        paneOrigin.setTop(pane1);
        paneOrigin.setCenter(pane2);
        paneOrigin.setBottom(pane3);
        
        Scene scena = new Scene(paneOrigin, 400, 400);
        primaryStage.setScene(scena);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
