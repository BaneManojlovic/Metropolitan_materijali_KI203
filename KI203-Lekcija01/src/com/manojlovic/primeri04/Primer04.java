/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri04;

/**
 *
 * @author manojlovic
 */
public class Primer04 {
    public static void main(String[] args) {
         //kreiram 100 visokoprioritetnih i niskoprioritetnih niti
         for(int i=1; i<=100; i++){
             NitVisokogPrioriteta vpNit = new NitVisokogPrioriteta("Visoka ");
             NitNiskogPrioriteta npNit = new NitNiskogPrioriteta("Niska ");
            //startujem niti
            vpNit.start();
            npNit.start();
         }
    }
}
