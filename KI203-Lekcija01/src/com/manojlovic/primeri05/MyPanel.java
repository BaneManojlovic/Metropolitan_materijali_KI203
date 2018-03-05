/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri05;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author manojlovic
 */
public class MyPanel extends JPanel{
    
    ThreadMove nit3;

    public MyPanel() {
        nit3 = new ThreadMove(this);
        nit3.start();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillRect(nit3.getX(), nit3.getY(), 50, 50);
    }
}
