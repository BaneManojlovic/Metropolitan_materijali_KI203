/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.zadatak01;

/**
 *
 * @author manojlovic
 */
public class PrintUpperCase implements Runnable{
    //metoda koja stampa redom sva velika slova alfabeta 100 puta
    @Override
    public void run() {
        int j=0;
        while(j<100){
        for(char i='A'; i<='Z'; i++){
            System.out.print(i + " ");
        }
        j++;
            System.out.println(" -- " + j);
        }
    }
}
