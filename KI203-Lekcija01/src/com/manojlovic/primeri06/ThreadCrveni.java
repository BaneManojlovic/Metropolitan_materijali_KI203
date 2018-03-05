/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri06;

import java.awt.Color;

/**
 *
 * @author manojlovic
 */
public class ThreadCrveni extends Thread{
    
    Integer x = 0, y = 0;
    MyPanel p = null;

    public ThreadCrveni(MyPanel p) {
        this.p = p;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = 0; i < 22; i++) {
            x += 20;
            p.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
