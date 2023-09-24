package org.example.EldenRing.other;

public class StatsManager {
    private static StatsManager instance;
    public enum ItemSelector{
        ALL,
        SAMURAI,
        GUERRIERO,
        MERCANTE,
        NPC;
    }
    private StatsManager(){

    }
    public static StatsManager getInstance(){
        if(instance == null){
            instance = new StatsManager();
        }
        return instance;
    }

}
