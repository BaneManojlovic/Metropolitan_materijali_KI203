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
public class PrintRandomChars implements Runnable{

    //metoda koja ispisuje 1000 nasumicnih slova abecede
    @Override
    public void run() {
        System.out.println("\n------------------------------------------------");
        for(int i=1; i<=1000; i++){
            Random rnd = new Random();
            char slovo = (char)(rnd.nextInt(26) + 'a');
            System.out.print(slovo + " ");
            
        }
    }
}