/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author manojlovic
 */
public class ThreadMove extends Thread{
    
    int x, y=30, r;
    MyPanel p;

    public ThreadMove() {
    }

    public ThreadMove(int x, int y, int r, MyPanel p) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.p = p;
    }

    ThreadMove(MyPanel p) {
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public MyPanel getP() {
        return p;
    }

    public void setP(MyPanel p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            x += 20;
            p.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        System.out.println("Crtam krugove " + i + " put.");
        
        }
    }
}
