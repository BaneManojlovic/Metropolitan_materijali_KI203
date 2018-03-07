/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.util.concurrent.*;
import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author Branislav
 */
public class Zadatak3 {
    public static void main(String[] args) {
        ///kreiram niz nasumicnih stringova duzine 6 miliona karaktera 
        final int SIZE = 6000000;
        byte[] lista1 = new byte[SIZE];
        new Random().nextBytes(lista1);
        String generisaniString = new String(lista1, Charset.forName("UTF-8"));

        long startTime = System.currentTimeMillis();

        int brojac = 0;
        for (int i = 0; i < lista1.length; i++) {
            if (lista1[i] == 'a' || lista1[i] == 'e' || lista1[i] == 'i' || lista1[i] == 'o' || lista1[i] == 'u'
             || lista1[i] == 'A' || lista1[i] == 'E' || lista1[i] == 'I' || lista1[i] == 'O' || lista1[i] == 'U') {
                brojac++;
            } else {
            }
        }
        System.out.println("Broj samoglasnika je: " + brojac);

        long endTime = System.currentTimeMillis();
        System.out.println("Broj procesora: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Vreme izvrsenja " + (endTime - startTime) + " milisekundi.");    
    }
    
    public static void samoglasnici(byte[] lista1) {
        RecursiveAction zad = new Zadatak(lista1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(zad);
    }
      
    private static class Zadatak extends RecursiveAction {
    private final static int THRESHOLD = 10000;
    private byte[] lista1;
    
       public Zadatak(byte[] lista1) {
            this.lista1 = lista1;
       }
    
        @Override
        protected void compute() {
            if(lista1.length < THRESHOLD){
                  byte a = "a".getBytes(Charset.forName("UTF-8"))[0];
                  byte e = "e".getBytes(Charset.forName("UTF-8"))[0];
                  byte i = "i".getBytes(Charset.forName("UTF-8"))[0];
                  byte o = "o".getBytes(Charset.forName("UTF-8"))[0];
                  byte u = "u".getBytes(Charset.forName("UTF-8"))[0];
                  byte A = "A".getBytes(Charset.forName("UTF-8"))[0];
                  byte E = "E".getBytes(Charset.forName("UTF-8"))[0];
                  byte I = "I".getBytes(Charset.forName("UTF-8"))[0];
                  byte O = "O".getBytes(Charset.forName("UTF-8"))[0];
                  byte U = "U".getBytes(Charset.forName("UTF-8"))[0];
                  java.util.Arrays.binarySearch(lista1, a);
                  java.util.Arrays.binarySearch(lista1, e);
                  java.util.Arrays.binarySearch(lista1, i);
                  java.util.Arrays.binarySearch(lista1, o);
                  java.util.Arrays.binarySearch(lista1, u);
                  java.util.Arrays.binarySearch(lista1, A);
                  java.util.Arrays.binarySearch(lista1, E);
                  java.util.Arrays.binarySearch(lista1, I);
                  java.util.Arrays.binarySearch(lista1, O);
                  java.util.Arrays.binarySearch(lista1, U);
                  System.out.println("Rez je: " + 
                          (java.util.Arrays.binarySearch(lista1, a) +
                           java.util.Arrays.binarySearch(lista1, e) +
                           java.util.Arrays.binarySearch(lista1, i) +
                           java.util.Arrays.binarySearch(lista1, o) +
                           java.util.Arrays.binarySearch(lista1, u) +
                           java.util.Arrays.binarySearch(lista1, A) +
                           java.util.Arrays.binarySearch(lista1, E) +
                           java.util.Arrays.binarySearch(lista1, I) +
                           java.util.Arrays.binarySearch(lista1, O) +
                           java.util.Arrays.binarySearch(lista1, U)));
            }else{             
                // Dobijnje prve polovine
                byte[] firstHalf = new byte[lista1.length / 2];
                System.arraycopy(lista1, 0, firstHalf, 0, lista1.length / 2);

                // Dobijanje druge polovine
                int secondHalfLength = lista1.length - lista1.length / 2;
                byte[] secondHalf = new byte[secondHalfLength];
                System.arraycopy(lista1, lista1.length / 2, secondHalf, 0, secondHalfLength);
                
                // Rekurzivno izvrsavanje zadatka u dve polovine
                invokeAll(new Zadatak(firstHalf),
                new Zadatak(secondHalf));

                // Spajanje prve polovine sa drugom polovinom u listu
                byte[] listaKombinovana = new byte[firstHalf.length + secondHalf.length];
            }
        }
    }
}