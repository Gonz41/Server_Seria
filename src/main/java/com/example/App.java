package com.example;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * Hello world!
 *
 */
public class App 
{
    static ArrayList<Aula> classi = new ArrayList<Aula>();
    public static void main( String[] args )
    {   
        try{
            ServerSocket server = new ServerSocket(3000);
            XmlMapper mapper = new XmlMapper();

            Aula classe1 = new Aula(5,"DIA","09-TW");
            Studente s1 = new Studente("Pippo", "Cocaina", "1/1/2005");
            Studente s2 = new Studente("Alessio", "Pitone", "2/2/2005");
            Studente s3 = new Studente("Alessandro", "Marp", "3/3/2005");
            classe1.addStudente(s1);
            classe1.addStudente(s2);
            classe1.addStudente(s3);
            classi.add(classe1);

            while(true) {
                System.out.println("Il Server in attesa.\n");
                Socket s = server.accept();
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                System.out.println("Client - Connessione effettuata.\n");
                for(Aula c : App.classi){
                    out.writeBytes(mapper.writeValueAsString(c) + "\n");
                }
                System.out.println("Invio lista alunni.\n");
            }
            //server.close();
            //System.out.println("Chiuso Server");  
        } catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
