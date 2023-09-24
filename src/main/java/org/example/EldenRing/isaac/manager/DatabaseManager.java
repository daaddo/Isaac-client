package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.models.bosses.Boss;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance = null;
    private DatabaseManager(){

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
