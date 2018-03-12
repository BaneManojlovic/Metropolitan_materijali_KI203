/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Branislav
 */
public class Client {
    static Socket soket; 
    public static Scanner sc = new Scanner(System.in);
    static DataOutputStream writter;
    static DataInputStream reader;
    public static void main(String[] args) {
         try{
            //kreiram soket korisnika.
            soket = new Socket("localhost", 6000); //umesto localhos ide IP adresa racunara na kom se nalazi pokrenut server
            //soket = new Socket("192.168.1.3", 6000);
            //unos korisnika
            System.out.println("Unesite broj:");
            int a = sc.nextInt();
            //pise podatak u izlazni tok ka serveru
            writter = new DataOutputStream(soket.getOutputStream());
            writter.write(a);
            writter.flush();
            
            //cita odgovor od servera u ispisuje ga na konzolu
            reader = new DataInputStream(soket.getInputStream());
            int e = reader.readInt();  //iscitavam int dobijen sa servera
            System.out.println("Binarni oblik: " + e);
            reader.close();
            writter.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}