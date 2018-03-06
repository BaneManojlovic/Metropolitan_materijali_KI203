/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 implements Runnable{

    public void paint(Graphics page) {

        Canvas canvas = new Canvas();

        Graphics g = canvas.getGraphics();

        Random rnd = new Random();

        for (int i = 1; i < 50; i++) {
            //----------------------------------------------------
            int poluprecnik = rnd.nextInt(60);//ok
            //----------------------------------------------------
            int x = rnd.nextInt(300);
            int y = rnd.nextInt(500);
            page.setColor(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));  //ok
            page.fillOval(x, y, poluprecnik, poluprecnik);//ok

        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
