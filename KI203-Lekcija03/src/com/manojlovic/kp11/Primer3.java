/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.kp11;

import java.sql.SQLException;

/**
 *
 * @author manojlovic
 */
public class Primer3 {
    
     public Primer3() throws SQLException {
       // System.out.println(Baza.getGodisteIzmedju1990i2010());
        Baza.deleteAuto(3);
    }
    
    
    
    public static void main(String[] args) throws SQLException {
        new Primer3();
    }
}
