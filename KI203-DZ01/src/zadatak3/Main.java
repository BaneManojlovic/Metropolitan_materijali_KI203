/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import javax.swing.JFrame;

/**
 *
 * @author manojlovic
 */
public class Main{
    public static void main(String[] args) {
        
        //Kreiram objekat 
        Zadatak1 zadatak = new Zadatak1();
        
        //kreiram nit
        Thread nit = new Thread(zadatak);
        
        //startujem nit
        nit.start();
    }
}
