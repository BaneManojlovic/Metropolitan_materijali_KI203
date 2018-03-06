/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ladmin
 */
public class AutobuskaKarta {
    // mesto polaska, mesto dolaska, cena, datum, vreme, prevoznik, broj sedišta. 
    private long id;
    private String mestoPolaska, mestoDolaska, prevoznik;
    private int brojSedista;
    private double cena;
    private Timestamp datum;

    public AutobuskaKarta() {
    }

    
    public AutobuskaKarta(String mestoPolaska, String mestoDolaska, String prevoznik, int brojSedista, double cena, Timestamp datum) {
        this.mestoPolaska = mestoPolaska;
        this.mestoDolaska = mestoDolaska;
        this.prevoznik = prevoznik;
        this.brojSedista = brojSedista;
        this.cena = cena;
        this.datum = datum;
    }

    public AutobuskaKarta(long id, String mestoPolaska, String mestoDolaska, String prevoznik, int brojSedista, double cena, Timestamp datum) {
        this.id = id;
        this.mestoPolaska = mestoPolaska;
        this.mestoDolaska = mestoDolaska;
        this.prevoznik = prevoznik;
        this.brojSedista = brojSedista;
        this.cena = cena;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getMestoPolaska() {
        return mestoPolaska;
    }

    public void setMestoPolaska(String mestoPolaska) {
        this.mestoPolaska = mestoPolaska;
    }

    public String getMestoDolaska() {
        return mestoDolaska;
    }

    public void setMestoDolaska(String mestoDolaska) {
        this.mestoDolaska = mestoDolaska;
    }

    public String getPrevoznik() {
        return prevoznik;
    }

    public void setPrevoznik(String prevoznik) {
        this.prevoznik = prevoznik;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "AutobuskaKarta{" + "mestoPolaska=" + mestoPolaska + ", mestoDolaska=" + mestoDolaska + ", prevoznik=" + prevoznik + ", brojSedista=" + brojSedista + ", cena=" + cena + ", datum=" + datum + '}';
    }
    
    
    
    
}
