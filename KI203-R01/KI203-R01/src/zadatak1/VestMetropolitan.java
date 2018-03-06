/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Comparator;

/**
 *
 * @author ladmin
 */
public class VestMetropolitan{
    private String naslov, slika, link;

    public VestMetropolitan() {
    }

    public VestMetropolitan(String naslov, String slika, String link) {
        this.naslov = naslov;
        this.slika = slika;
        this.link = link;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return  naslov + " " + slika + " " + link ;
    }

   
    
}
