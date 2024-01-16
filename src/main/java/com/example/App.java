package com.example;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Aula classe = new Aula("5DIA");
        Studente s1 = new Studente("Pippo", "Cocaina", "1/1/2005");
        Studente s2 = new Studente("Alessio", "Pitone", "2/2/2005");
        Studente s3 = new Studente("Alessandro", "Marp", "3/3/2005");
        classe.addStudente(s1);
        classe.addStudente(s2);
        classe.addStudente(s3);
        
        try{
            ServerSocket server = new ServerSocket(3000);
            while (true) {
                Socket s = server.accept();
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                System.out.println("Client - Connessione effettuata.\n");
                out.writeBytes(classe.toString()+"\n");
                System.out.println("Invio lista alunni.");
            }   
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza.");
            System.exit(1);
        }
    }
}
