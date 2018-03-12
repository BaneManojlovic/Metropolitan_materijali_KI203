/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

/**
 *
 * @author Branislav
 */
public class CeneAutomobila {
    
    public String cena=null;

    public CeneAutomobila() {
    }

    public CeneAutomobila(String cena) {
        this.cena = cena;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return ") " + cena + ".";
}
}