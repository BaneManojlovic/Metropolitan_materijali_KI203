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
public class PrintRandomNumbers implements Runnable{

    //metoda koja ispisuje 1000 random brojeva u opsegu od 100 do 10000
    @Override
    public void run() {
        for(int i=1; i<=1000; i++){
            Random rnd = new Random();
            //ovde setujem da budu samo pozitivni brojevi i setujem da opseg bude od 100 do 10000
            int broj = Math.abs(rnd.nextInt(10000 - 100 + 1) + 100);
            System.out.println(broj + " " + i);
    }
    }
}
