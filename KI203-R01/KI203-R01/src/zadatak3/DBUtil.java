/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import zadatak1.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ladmin
 */
public class DBUtil {

    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/autobuska_stanica";
    private static String user = "root";
    private static String password = "";

    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }

    public static void createTable() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        sql.execute("create table if not exists autobuska_karta( id int auto_increment, "
                + "mestoDolaska varchar(100), mestoPolaska varchar(100),	"
                + "prevoznik varchar(100), cena double, brojSedista int, datum timestamp,	primary key(id))");

        closeConnection();
    }

    public static void addKarta(AutobuskaKarta karta) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("INSERT INTO `autobuska_karta`( `mestoDolaska`, `mestoPolaska`,"
                + " `prevoznik`, `cena`, `brojSedista`, `datum`) VALUES (?,?,?,?,?,?)");
        sql.setString(1, karta.getMestoDolaska());
        sql.setString(2, karta.getMestoPolaska());
        sql.setString(3, karta.getPrevoznik());
        sql.setDouble(4, karta.getCena());
        sql.setInt(5, karta.getBrojSedista());
        sql.setObject(6, karta.getDatum());

        sql.execute();

        closeConnection();
    }

    public static List<AutobuskaKarta> getAll() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet rs = sql.executeQuery("select * from autobuska_karta order by mestoPolaska asc");
        List<AutobuskaKarta> karte = new ArrayList<>();

        while (rs.next()) {
           
            karte.add(new AutobuskaKarta(rs.getLong(1), rs.getString(3), rs.getString(2), rs.getString(4), 
                    rs.getInt(6), rs.getDouble(5), (Timestamp) rs.getObject(7)));
        }

        closeConnection();
        return karte;

    }
    
    
    public static ObservableList<AutobuskaKarta> getAllForTable() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet rs = sql.executeQuery("select * from autobuska_karta order by mestoPolaska asc");
        ObservableList<AutobuskaKarta> karte = FXCollections.observableArrayList();

        while (rs.next()) {
           
            karte.add(new AutobuskaKarta(rs.getLong(1), rs.getString(3), rs.getString(2), rs.getString(4), 
                    rs.getInt(6), rs.getDouble(5), (Timestamp) rs.getObject(7)));
        }

        closeConnection();
        return karte;

    }
    
    
    public static void deleteKarta(AutobuskaKarta karta) throws SQLException{
         openConnection();
        PreparedStatement sql = con.prepareStatement("DELETE FROM `autobuska_karta` WHERE id =? ");
        sql.setLong(1, karta.getId());

        sql.execute();

        closeConnection();
    }
    
    
        public static void editKarta(AutobuskaKarta karta) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("UPDATE `autobuska_karta` SET  `mestoDolaska` = ?, `mestoPolaska` = ?,"
                + " `prevoznik`=?, `cena`=?, `brojSedista`=?, `datum`=? WHERE id = ?");
        sql.setString(1, karta.getMestoDolaska());
        sql.setString(2, karta.getMestoPolaska());
        sql.setString(3, karta.getPrevoznik());
        sql.setDouble(4, karta.getCena());
        sql.setInt(5, karta.getBrojSedista());
        sql.setObject(6, karta.getDatum());
        sql.setLong(7, karta.getId());

        sql.execute();

        closeConnection();
    }
    
}
