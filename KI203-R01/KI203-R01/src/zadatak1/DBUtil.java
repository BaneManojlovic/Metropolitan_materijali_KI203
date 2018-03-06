/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ladmin
 */
public class DBUtil {

    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/vesti";
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
        sql.execute("create table if not exists vest( id int auto_increment, "
                + "naslov varchar(400),	link varchar(400),	"
                + "slika varchar(300),	primary key(id))");

        closeConnection();
    }

    public static void addVest(VestMetropolitan vest) throws SQLException {
        openConnection();
        PreparedStatement sql = con.prepareStatement("INSERT INTO `vest`"
                + "(`naslov`, `link`, `slika`) VALUES (?,?,?)");
        sql.setString(2, vest.getNaslov());
        sql.setString(3, vest.getLink());
        sql.setString(4, vest.getSlika());

        sql.execute();

        closeConnection();
    }

    public static List<VestMetropolitan> selectVesti() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet rs = sql.executeQuery("select * from vest order by naslov asc");
        List<VestMetropolitan> vesti = new ArrayList<>();

        while (rs.next()) {
            String naslov = rs.getString(1);
            String link = rs.getString(2);
            String slika = rs.getString(3);
            vesti.add(new VestMetropolitan(naslov, slika, link));
        }

        closeConnection();
        return vesti;

    }
}
