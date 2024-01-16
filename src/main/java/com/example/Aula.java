package com.example;

import java.util.ArrayList;

public class Aula {
    ArrayList<Studente> alunni;
    Integer numero;
    String sezione;
    String aula;
    
    public Aula(Integer numero, String sezione, String aula) {
        this.alunni = new ArrayList<>();
        this.numero = numero;
        this.sezione = sezione;
        this.aula = aula;
    }

    public void addStudente(Studente s){
        alunni.add(s);
    }
    @Override
    public String toString(){
        String st;
        st = "Classe:"+sezione+",";
        for(int i=0; i<alunni.size();i++){
            st = st + alunni.get(i).toString();
        }

        return st;
    }
}
