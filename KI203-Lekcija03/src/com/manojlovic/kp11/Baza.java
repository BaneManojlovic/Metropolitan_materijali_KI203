/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.kp11;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manojlovic
 */
public class Baza {

    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/Proba02";
    private static String username = "root";
    private static String password = "";

    //metoda za dodavanje automobila u bazu
    public static void addAuto(Automobili auto) {
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement st = (Statement) con.createStatement();
            st.execute("INSERT INTO automobili (ID,NAZIV,GODISTE,CENA) "
                    + "" + "VALUES ('" + auto.getID() + "','" + auto.getNAZIV()
                    + "','" + auto.getGODISTE() + "','" + auto.getCENA() + "')");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    //metoda za ispis svih automobila koji se nalaze u bazi
    public static List<Automobili> getAllAutomobili() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM automobili";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String naziv = rs.getString("NAZIV");
                int godiste = rs.getInt("GODISTE");
                int cena = rs.getInt("CENA");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;
    }
  
    //metoda za ispis-filtriranje automobila prema zadatom kriterijumu
    public static List<Automobili> getGodisteIzmedju1990i2010() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM automobili WHERE GODISTE >= 1990 AND GODISTE <= 2000";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String naziv = rs.getString("NAZIV");
                int godiste = rs.getInt("GODISTE");
                int cena = rs.getInt("CENA");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;
    }
    
    //metoda za dodavanje automobila u bazu
    public static void updateAuto(Automobili auto) {
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement st = (Statement) con.createStatement();
            st.execute("UPDATE automobili SET "
                    + "" + "VALUES ('" + auto.getID() + "','" + auto.getNAZIV()
                    + "','" + auto.getGODISTE() + "','" + auto.getCENA() + "')");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    //metoda za brisanje automobila iz baze
    public static void deleteAuto(int auto) throws SQLException{
        try{
        con = DriverManager.getConnection(url, username, password);
            Statement st = (Statement) con.createStatement();
            st.execute("DELETE FROM automobili WHERE ID = '?' ");
            con.close();
             } catch (SQLException ex) {
            ex.printStackTrace();
        }          
    }
    

}