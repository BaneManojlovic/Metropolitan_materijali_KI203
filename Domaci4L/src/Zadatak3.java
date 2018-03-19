import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilove
 */
public class Zadatak3 {
  /*Zadatak 3 Napraviti program koji traži od korisnika da unese broj artikala, a potom imena i cenu svih artikala. 
Na kraju program treba da ispiše sumu svih unetih artikala preko JOptionPane-a. Koristiti petlju za unos više artikala. */
public static void main(String[] args) {
   
        double suma = 0;
        int brArtikla = 1;
        if (brArtikla > 0) {
            brArtikla = Integer.parseInt(JOptionPane.showInputDialog("Unesite br artikla"));
            while (brArtikla > 0) {
                String nazivArtikla = JOptionPane.showInputDialog("Unesite naziv artikla: ");
                double cena = Double.parseDouble(JOptionPane.showInputDialog("Unesite cenu artikla: "));
                suma += cena;
                brArtikla--;
            }
        }
        System.out.println("Suma svih artikala je: " + suma);
    }

    
       
    }

 