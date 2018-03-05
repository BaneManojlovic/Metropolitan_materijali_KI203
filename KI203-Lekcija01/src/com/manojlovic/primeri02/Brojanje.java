/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri02;

/**
 *
 * @author manojlovic
 */
public class Brojanje implements Runnable{

    private int x;

    public Brojanje(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public void run() {
        try {
            for(int i=1; i<=x; i++){
                System.out.println(i);
                Thread.sleep(1000);  
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
