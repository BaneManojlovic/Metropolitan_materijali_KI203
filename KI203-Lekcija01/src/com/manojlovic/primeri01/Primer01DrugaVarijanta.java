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
public class Primer01DrugaVarijanta {
     public static void main(String[] args) {
        
        //kreiram objekte tipa klase koje je zadatak koji se resava
        PrintAA zadatak1 = new PrintAA();
        PrintBB zadatak2 = new PrintBB();
        PrintBBroj zadatak3 = new PrintBBroj();
        
        //kreiram niti
        Thread nit1 = new Thread(zadatak1);
        Thread nit2 = new Thread(zadatak2);
        Thread nit3 = new Thread(zadatak3);
        
        
         //startujem niti
         try {
             nit1.start();
             Thread.sleep(100);
         } catch (InterruptedException ex) {
         }

         try {
             nit2.start();
             Thread.sleep(100);
         } catch (InterruptedException ex) {
         }
         nit3.start();
    }
}
//klasa koja stampa slovo A
class PrintAA implements Runnable{   
    //metoda koja stampa slovo a 1000 puta
    @Override
    public void run() {
        for(int i=1; i<=1000; i++){
            System.out.print("a ");
           
        }
    }
}
//klasa koja stampa slovo B
class PrintBB implements Runnable{   
    //metoda koja stampa slovo a 1000 puta
    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            System.out.print("b ");
        }
    }
}
//klasa koja stampa borjeve od 1 do 100
class PrintBBroj implements Runnable{
    //metoda koja stampa brojeve od 1 do 100
    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            System.out.print(i + " ");
        }
    }
}

/*
    Ovde sam sve stavio u jednu klasu i koristio sam try-catch blokove kako
    bih naredio nitima 1 i 2 da pauziraju sa izvrsenjem kako bi se dobio lep 
    ispis na ekranu.
*/