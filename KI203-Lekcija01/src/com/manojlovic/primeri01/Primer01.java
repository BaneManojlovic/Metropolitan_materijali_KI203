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
public class Primer01 {
    public static void main(String[] args) {
        
        //kreiram objekte tipa klase koje je zadatak koji se resava
        PrintA zadatak1 = new PrintA();
        PrintB zadatak2 = new PrintB();
        PrintBroj zadatak3 = new PrintBroj();
        
        //kreiram niti
        Thread nit1 = new Thread(zadatak1);
        Thread nit2 = new Thread(zadatak2);
        Thread nit3 = new Thread(zadatak3);
        
        
        //startujem niti
        nit1.start();
        nit2.start();
        nit3.start();
    }
}

/*
    Kada kreiram niti u kojima ne postavljam pauziranje pri izvrsavanju istih,
    onda mi se sve niti izvrsavaju istovremeno i gaze jedna drugu, cime mi se 
    rezultati prepilcu. Zato je potrebno staviti startovannje niti u try-catch
    blok koji se diktirati kada se koja nit pokrece.

*/