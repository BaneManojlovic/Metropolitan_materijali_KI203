/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri06;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author manojlovic
 */
public class Zadatak02TrkaAutomobila extends JFrame{
    public static void main(String[] args) {
        new Zadatak02TrkaAutomobila();
    }
    
    public Zadatak02TrkaAutomobila() {
        setSize(500, 500);
        setContentPane(new MyPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
