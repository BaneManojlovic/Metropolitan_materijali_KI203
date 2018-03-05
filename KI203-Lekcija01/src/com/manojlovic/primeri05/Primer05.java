/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri05;

import javax.swing.JFrame;

/**
 *
 * @author manojlovic
 */
public class Primer05 extends JFrame{
    
    public static void main(String[] args) {
        new Primer05();
    }
    
    public Primer05() {
        setSize(500, 500);
        setContentPane(new MyPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
