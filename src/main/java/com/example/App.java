package com.example;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Aula classe = new Aula(5,"DIA","09-TW");
        Studente s1 = new Studente("Pippo", "Cocaina", "1/1/2005");
        Studente s2 = new Studente("Alessio", "Pitone", "2/2/2005");
        Studente s3 = new Studente("Alessandro", "Marp", "3/3/2005");
        classe.addStudente(s1);
        classe.addStudente(s2);
        classe.addStudente(s3);
        
        XmlMapper xmlMapper = new XmlMapper();
        String x1 = xmlMapper.writeValueAsString(s1);
        String x2 = xmlMapper.writeValueAsString(s2);
        String x3 = xmlMapper.writeValueAsString(s3);
        System.out.println(x1);


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
