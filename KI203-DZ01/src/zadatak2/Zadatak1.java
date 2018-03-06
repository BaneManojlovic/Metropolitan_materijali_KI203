/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 extends Application{
    
    public Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }

    @Override
    public void start(Stage primaryStage) {

        FlowPane pane = new FlowPane();
        
        for(int i=1; i<=50; i++){
            Circle krug = new Circle();
            krug.setCenterX(Math.random());
            krug.setCenterY(Math.random());
            krug.setRadius(Math.random()*49+1);
            krug.setFill(randomColor());
            pane.getChildren().add(krug);
            
        }
        
        Scene scena = new Scene(pane, 600, 500);
        primaryStage.setScene(scena);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
