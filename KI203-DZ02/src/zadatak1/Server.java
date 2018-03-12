/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Branislav
 */
public class Server {
    
    static ServerSocket server;
    static Socket soket;
    static DataInputStream reader;
    static DataOutputStream writer;
    
    public static void main(String[] args) {
        try{
            //kreiram soket na serveru
            server = new ServerSocket(6000);
             //stavljam beskonacnu petlju da bi mi server stalno radio bez prestanka.
            while(true){
                //ovde kazemo da soket treba da ceka na zahtev od klijenta
                soket = server.accept();
                //citac koji cita podatke koji dodju od kijenta
                reader = new DataInputStream(soket.getInputStream());
                //program ceka da mu reader da broj i taj broj koji dobije, program smesta u promenljivu n.
                int n = reader.read();
                System.out.println("Sever je primio broj: " + n);
                //server poziva metodu koja izracunava fibonacijev broj
                String rez = pretvaranjeBroja(n);
                Integer rezultat = new Integer(rez);//pretvaram String rez u Integer rezultat
               
                //da bismo rezultat poslali ka klijentu moramo da u OutputStream upisemo rezultat pomocu:
                writer = new DataOutputStream(soket.getOutputStream());
                writer.writeInt(rezultat);   //server upisuje tipa int koji salje ka klijentu
                System.out.println("Binarni oblik: " + rezultat);
                writer.flush();   //komanda da ocisti smece pri nagomilavanju podataka
                break;
            }
            //zatvorimo citac i pisac da se memorija ne prepuni
            reader.close();
            writer.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    //metoda koja pretvara int broj u binarni
    private static String pretvaranjeBroja(int n) {
        Integer i = n;
        String rez;
        rez = Integer.toBinaryString(i);
        return rez;
    }
}