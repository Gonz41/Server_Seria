package com.example;

import java.util.ArrayList;

public class Aula {
    ArrayList<Studente> alunni;
    String nome;
    
    public Aula(String nome) {
        this.alunni = new ArrayList<>();
        this.nome = nome;
    }

    public void addStudente(Studente s){
        alunni.add(s);
    }
    @Override
    public String toString(){
        String st;
        st = "Classe:"+nome+",";
        for(int i=0; i<alunni.size();i++){
            st = st + alunni.get(i).toString();
        }

        return st;
    }
}
