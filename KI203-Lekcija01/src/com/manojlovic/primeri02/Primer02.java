/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri02;

/**
 *
 * @author manojlovic
 */
public class Primer02 {
    public static void main(String[] args) {
        
        //kreiram objekte zadatka
        Brojanje zadatak1 = new Brojanje(20);
        Brojanje zadatak2 = new Brojanje(10);
        
        //kreiram niti
        Thread nit1 = new Thread(zadatak1);
        Thread nit2 = new Thread(zadatak2);
        
        //startujem niti
        
        nit1.start();
        nit2.start();
    }
}

/*
    Ovde se niti izvrsavaju paralelno i cilj je da se pokaze da je 
    moguce privremeno pauzirati izvrsenje.
*/