/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.kp11;

/**
 *
 * @author manojlovic
 */
public class Primer1 {

    public Primer1() {
        Baza.addAuto(new Automobili(1, "Audi A6", 2017, 12000));
        Baza.addAuto(new Automobili(2, "BMW 518i", 1992, 1200));
        Baza.addAuto(new Automobili(3, "Mercedes S600", 1999, 10000));
        Baza.addAuto(new Automobili(4, "WW Golf 4", 2000, 2800));
        Baza.addAuto(new Automobili(5, "Toyota Yaris", 2001, 2000));
    }
    
    
    
    public static void main(String[] args) {
        new Primer1();
    }
}
