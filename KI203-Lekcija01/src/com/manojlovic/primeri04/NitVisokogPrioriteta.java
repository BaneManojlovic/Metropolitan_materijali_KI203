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
public class NitVisokogPrioriteta extends Thread {

    public NitVisokogPrioriteta(String name) {
        super(name);
        setPriority(MAX_PRIORITY);
    }

    //izvrsava nit 1 put
    @Override
    public void run() {
        System.out.println(this.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
