/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import javax.swing.JFrame;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 extends JFrame {

    public static void main(String[] args) {
// TODO code application logic here
        new Zadatak1();
    }

    public Zadatak1() {
        setSize(500, 500);
        setContentPane(new MyPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
