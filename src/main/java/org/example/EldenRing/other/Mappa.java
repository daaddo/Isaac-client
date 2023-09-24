package org.example.EldenRing.other;

public class Mappa {
    private static Mappa instance = null;


    private Mappa(){
    }
    public Mappa getInstance(){
        if(instance==null){
            instance= new Mappa();
        }
        return instance;
    }
}
