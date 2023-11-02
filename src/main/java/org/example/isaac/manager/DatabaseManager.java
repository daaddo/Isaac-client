package org.example.isaac.manager;

import org.example.isaac.models.bosses.Boss;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance = null;
    private DatabaseManager() {
        String[] mesi = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto",
                "Settembre", "Ottobre", "Novembre", "Dicembre"};

    }

    public static DatabaseManager getInstance(){
        if (instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }
    private List<Boss> getAllBoss(){
        List<Boss> allboss= new ArrayList<>();
        return allboss;
    }
    public Boss getRandomBoss(){
        int a = (int) (Math.random()*getAllBoss().size());
        return getAllBoss().get(a);
    }
}
