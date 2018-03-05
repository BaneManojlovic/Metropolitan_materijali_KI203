/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri06;

/**
 *
 * @author manojlovic
 */
public class ThreadZuti extends Thread{
    Integer x = 0, y = 100;
    MyPanel p = null;

    public ThreadZuti(MyPanel p) {
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
            x += 15;
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
