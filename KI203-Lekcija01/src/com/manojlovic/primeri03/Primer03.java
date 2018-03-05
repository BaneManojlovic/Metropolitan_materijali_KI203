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
public class Primer03 {
    public static void main(String[] args) {
        
        //kreiram objekte tipa zadataka
        IspisBrojeva zadatak1 = new IspisBrojeva(1);
        IspisBrojeva zadatak2 = new IspisBrojeva(2);
        IspisBrojeva zadatak3 = new IspisBrojeva(3);
        
        //kreiram niti
        Thread nit1 = new Thread(zadatak1);
        Thread nit2 = new Thread(zadatak2);
        Thread nit3 = new Thread(zadatak3);
        
        //startujem niti
        nit1.start();
        try{
            nit1.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        nit2.start();
        try{
            nit2.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        nit3.start();
        try{
            nit3.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}

/*
    Napraviti 3 niti koje će se izvršavati po 3 sekunde jedna za drugom. 
    Koristiti join metodu za uvezivanje niti.
*/