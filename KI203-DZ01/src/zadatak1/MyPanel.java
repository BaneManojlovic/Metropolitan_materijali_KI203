/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Branislav
 */
public class MyPanel extends JPanel{
    
    ThreadMove nit3;

    public MyPanel() {
        nit3 = new ThreadMove(this);
        nit3.start();
    }

    @Override
    public void paint(Graphics page) {
        Canvas canvas = new Canvas();

        Graphics g = canvas.getGraphics();

        Random rnd = new Random();

        for (int i = 1; i < 50; i++) {
            //----------------------------------------------------
            int poluprecnik = rnd.nextInt(60);//ok
            //----------------------------------------------------
            int x = rnd.nextInt(500);
            int y = rnd.nextInt(500);
            page.setColor(new java.awt.Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));  //ok
            page.fillOval(x, y, poluprecnik, poluprecnik);//ok
        }    
}
}
