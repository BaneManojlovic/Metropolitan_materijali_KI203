/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ladmin
 */
public class Zadatak3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            DBUtil.createTable();
            long time = System.currentTimeMillis();
            AutobuskaKarta karta = new AutobuskaKarta("Nis", "Kopaonik", "Lasta", 10, 2000, new Timestamp(time));
            DBUtil.addKarta(karta);
            List<AutobuskaKarta> karte = DBUtil.getAll();
            for (AutobuskaKarta a : karte) {
                System.out.println(a);
            }
            
            DBUtil.deleteKarta(karte.get(2));
            
            AutobuskaKarta k = karte.get(0);
            k.setBrojSedista(55);
            DBUtil.editKarta(k);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
