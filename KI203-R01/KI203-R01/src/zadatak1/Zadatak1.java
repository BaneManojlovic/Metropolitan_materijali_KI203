/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ladmin
 */
public class Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DBUtil.createTable();

              Document doc = Jsoup.connect("http://www.metropolitan.edu.rs/teme/novosti/").get();
            Elements elems = doc.select(".post-title.entry-title > a");
            for (Element e : elems) {
                VestMetropolitan vest = new VestMetropolitan();
                vest.setNaslov(e.text());
                vest.setLink(e.attr("href"));
                // System.out.println(e.attr("href"));
                Document docImage = Jsoup.connect(e.attr("href")).get();
                Elements elemsImg = docImage.select("body> #wrapper > #main > .avada-row > #content > .post > .flexslider.post-slideshow > ul > li:nth-child(1) > a> img");
                for (Element el : elemsImg) {
                    vest.setSlika(el.attr("src"));
                }
                System.out.println(vest.toString());
                DBUtil.addVest(vest);
                
            }
            System.out.println("___________________________________________________________________________________________");
            List<VestMetropolitan> vesti = DBUtil.selectVesti();
            /*Collections.sort(vesti, new Comparator<VestMetropolitan>() {
                @Override
                public int compare(VestMetropolitan o1, VestMetropolitan o2) {
                    return o1.getNaslov().compareTo(o2.getNaslov());
                }
            });*/
            for (VestMetropolitan v : vesti) {
                System.out.println(v.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
