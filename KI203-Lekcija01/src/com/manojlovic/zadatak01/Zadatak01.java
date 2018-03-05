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
public class Zadatak01 {
    public static void main(String[] args) {
        
        //kreiram objekte tipa niti
        PrintUpperCase zadatak1 = new PrintUpperCase();
        PrintRandomNumbers zadatak2 = new PrintRandomNumbers();
        PrintRandomChars zadatak3 = new PrintRandomChars();
        PrintEvenNumbers zadatak4 = new PrintEvenNumbers();
        
        //kreiram niti
        Thread nit1 = new Thread(zadatak1);
        Thread nit2 = new Thread(zadatak2);
        Thread nit3 = new Thread(zadatak3);
        Thread nit4 = new Thread(zadatak4);
        
        //startujem izvrsavanje niti
        try{
            nit1.start();
            Thread.sleep(1000);
        }catch(InterruptedException ex){
        }
        
        try{
            nit2.start();
            Thread.sleep(1000);
        }catch(InterruptedException ex){
        }
        try{
            nit3.start();
            Thread.sleep(1000);
        }catch(InterruptedException ex){
        }
       
        nit4.start();
        
    }
}
