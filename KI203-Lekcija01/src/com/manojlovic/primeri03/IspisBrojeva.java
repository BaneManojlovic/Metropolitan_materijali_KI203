/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri03;

/**
 *
 * @author manojlovic
 */
public class IspisBrojeva implements Runnable{
    //morao sam da ubacim promenljivu x kao atribut u ovoj klasi da bih mogao iz main
    //metode da saljem i primam x poslat iz poziva metode. Ovo nije trazeno u zadatku
    //ali se ovako zadatak bolje izvrsava.
    private int x;

    public IspisBrojeva(int x) {
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
        for (int i = 1; i <= 10; i++) {
            System.out.println(x + " ");
        }
        //try-catch blok sam stavio izvan for petlje kako bi se metoda sleep()
        //izvrsavala iskljucivo nakon zavrsenog zadatka.
        try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    }
}