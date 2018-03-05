/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri01;

/**
 *
 * @author manojlovic
 */
public class PrintBroj implements Runnable{

    @Override
    public void run() {
        
        for(int i=1; i<=100; i++){
            System.out.print(i + " ");
        }
    }
    
}
