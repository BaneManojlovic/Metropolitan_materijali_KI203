/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak01;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manojlovic
 */
public class DBUtil {
    
    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/katalog_automobila";
    private static String user = "root";
    private static String password = "";
    //otvaranje konekcije
    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
    }
    //zatvaranje konekcije
    public static void closeConnection() throws SQLException {
        con.close();
    }
    
    //1. Metoda za kreiranje tabele
    public static void createTable() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        sql.execute("create table if not exists katalog_automobila( id int auto_increment, "
                + "model varchar(100), godiste int, cena double, primary key(id))");
        closeConnection();
    }
    
    //2. Metoda za unos automobila u bazu
    public static void addAuto(Automobili auto) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("INSERT INTO `katalog_automobila`( `model`, `godiste`, `cena`) VALUES (?,?,?)");
        sql.setString(1, auto.getModel());
        sql.setInt(2, auto.getGodiste());
        sql.setDouble(3, auto.getCena());
        sql.execute();
        closeConnection();
    }

    //3. Metoda za ispis podataka iz baze
    public static List<Automobili> getAll() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet rs = sql.executeQuery("select * from katalog_automobila order by id asc");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        List<Automobili> automobili = new ArrayList<>();
        while (rs.next()) {
            for(int i = 1 ; i <= columnsNumber; i++){
                System.out.print(rs.getString(i) + " ");                
            }
            System.out.println();
       //     automobili.add(new Automobili(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
        }
        closeConnection();
        return automobili;
    }

    //4. Metoda za brisanje podataka iz baze
    public static void deleteAuto(int name) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection connection = DriverManager.getConnection(url, username, password);
            openConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM `katalog_automobila` WHERE id = ?");
            st.setInt(1, name);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //5. Metoda za izmenu podataka u bazi, tj. za update
    public static void editAuto(Automobili karta) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("UPDATE `katalog_automobila` SET  (`id` = ?, `model` = ?, `godiste`=?, `cena`=?) WHERE id = ?");
        sql.setInt(1, karta.getId());
        sql.setString(2, karta.getModel());
        sql.setInt(3, karta.getGodiste());
        sql.setDouble(4, karta.getCena());
        
        sql.execute();
        closeConnection();
    }
    
    //6. Metoda za filtriranje automobila po jednom kriterijumu - stavi neka bude prema godistu.
     //metoda za ispis-filtriranje automobila prema zadatom kriterijumu
    //metoda za ispis-filtriranje automobila prema zadatom kriterijumu
    public static List<Automobili> getGodisteIzmedju1990i2000() {
        ArrayList<Automobili> listaAutomobila = new ArrayList<Automobili>();
        try {
            
            con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM katalog_automobila WHERE godiste >= 1990 AND godiste <= 1999";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("model");
                int godiste = rs.getInt("godiste");
                double cena = rs.getDouble("cena");
                listaAutomobila.add(new Automobili(id, naziv, godiste, cena));
            }
            st.close();
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAutomobila;
    }

}
