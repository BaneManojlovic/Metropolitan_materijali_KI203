/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.zadatak01;

import java.util.Random;

/**
 *
 * @author manojlovic
 */
public class PrintEvenNumbers implements Runnable{

    @Override
    public void run() {
        for(int i=10; i<=50000; i++){
            
            if(i%2==0){
                System.out.println( " " + i);
            }     
    }
    }
}
