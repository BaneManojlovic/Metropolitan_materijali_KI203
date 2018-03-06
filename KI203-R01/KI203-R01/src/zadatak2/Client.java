/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ladmin
 */
public class Client {

    static DataOutputStream writter;
    static Socket socket;
    static DataInputStream reader;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 6000);
            Scanner input = new Scanner(System.in);
            System.out.println("Unesite element");
            int el = input.nextInt();

            writter = new DataOutputStream(socket.getOutputStream());
            writter.write(el);

            reader = new DataInputStream(socket.getInputStream());
            int e = reader.read();
            System.out.println(e);

            reader.close();
            writter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
