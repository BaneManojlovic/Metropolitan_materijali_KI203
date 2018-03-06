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

/**
 *
 * @author ladmin
 */
public class Server {

    static DataInputStream reader;
    static DataOutputStream writter;
    static ServerSocket server;
    static Socket socket;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            // TODO code application logic here
            server = new ServerSocket(6000);
            while (true) {
                socket = server.accept();
                reader = new DataInputStream(socket.getInputStream());

                int n = reader.read();
                System.out.println("Server je primio broj " + n);
                int fib = fibonaci(n);
                System.out.println("Server je izracunao " + fib);
                writter = new DataOutputStream(socket.getOutputStream());
                writter.write(fib);
                writter.flush();
                break;
            }

            reader.close();
            writter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int fibonaci(int n) {
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 0; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;

    }

}
