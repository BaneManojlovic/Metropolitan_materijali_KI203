/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri04;

/**
 *
 * @author manojlovic
 */
public class NitNiskogPrioriteta extends Thread {

    //ovo sam generisao pomocu: Source -> Insert code -> Construktor -> Thread (String name)
    public NitNiskogPrioriteta(String name) {
        super(name);
        setPriority(MIN_PRIORITY);
    }
    //izvrsava nit 10 puta 
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.getName() + " " + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }    
}
