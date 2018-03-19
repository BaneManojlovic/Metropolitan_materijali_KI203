/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak01;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 {
    public static void main(String[] args) {
        try{
            
            //kreiram tabelu
 /*           DBUtil.createTable();
            System.out.println("Tabela kreirana!");*/
            
            //dodajem novi automobil u bazu
/*            Automobili auto = new Automobili(1, "BMW 520i", 2001, 3500);
            DBUtil.addAuto(auto);
            System.out.println("Auto upisan u bazu!");*/
            
            //pozivam ispis iz baze
            List<Automobili> kola = DBUtil.getAll();
            for (Automobili a : kola) {
                System.out.println(a);
            }
            
            //pozivam brisanje automobila iz baze koji se nalazi na rednom broju 1 u bazi
 //           DBUtil.deleteAuto(kola.get(1));
 
            //pozivam metodu za azururanje podataka iz baze
            Automobili k = kola.get(0);
            k.setCena(1800);
            DBUtil.editAuto(k);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
