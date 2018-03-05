/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri06;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author manojlovic
 */
public class MyPanel extends JPanel{
     ThreadCrveni nit3;
     ThreadZuti nit2;

    public MyPanel() {
        nit3 = new ThreadCrveni(this);
        nit3.start();
        nit2 = new ThreadZuti(this);
        nit2.start();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;
        g2.fillRect(nit3.getX(), nit3.getY(), 50, 50);
        g1.fillRect(nit2.getX(), nit2.getY(), 50, 50);
    }
}
