package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.events.FightEventListner;
import org.example.EldenRing.isaac.models.characters.*;
import org.example.EldenRing.isaac.models.characters.Character;
import org.example.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightManager {
    private static FightManager instance = null;

    private FightManager() {
    }
    private Map<MainCharacter,Integer> allyAgilityMap = new HashMap();
    private Map<Enemy,Integer> enemyAgilityMap = new HashMap<>();

    public static FightManager getInstance() {
        if (instance == null) {
            instance = new FightManager();
        }
        return instance;
    }
    public void addEnemy(Enemy enemy){
        this.enemyAgilityMap.put(enemy,enemy.getAgility());
    }
    public boolean isAllDead (Map<? extends Fightable,Integer> map){
        for (Fightable fightable : map.keySet()) {
            if(fightable.getCurrentHealth()>0){
                return false;
            }
        }
        return true;
    }
    public void init(List<? extends MainCharacter> ally,List<? extends Enemy> enemy){
        for (MainCharacter fightable : ally) {
            addAlly(fightable);
        }
        for (Enemy fightable : enemy) {
            addEnemy(fightable);
        }
    }

    public void initializedMaps (){
        if(allyAgilityMap.isEmpty() || enemyAgilityMap.isEmpty()){
            throw new NullPointerException("Maps are not initialized");
        }
    }

    public HashMap<Character,Boolean> nextTurn(){
        initializedMaps();
        HashMap< Character, Boolean> agilityOver100AndIsAllyMap = new HashMap<>();
            while (agilityOver100AndIsAllyMap.isEmpty()) {
                allyAgilityMap.forEach((key, value) -> {
                    if (value >= 100) {
                        agilityOver100AndIsAllyMap.put(key, true);
                        allyAgilityMap.replace(key, value - 100);
                    } else {
                        allyAgilityMap.replace(key, value + key.getAgility());
                    }
                });
                enemyAgilityMap.forEach((key, value) -> {
                    if (value >= 100) {
                        agilityOver100AndIsAllyMap.put(key, false);
                        enemyAgilityMap.replace(key, value - 100);
                    } else {
                        enemyAgilityMap.replace(key, value + key.getAgility());
                    }
                });
            }
            HashMap<Character, Boolean> sortedMapByAgility = sortMap(agilityOver100AndIsAllyMap);
            sortedMapByAgility.forEach((key, value) -> System.out.println(key.getName() + "  " + value));
            return sortedMapByAgility;
    }
    public  HashMap<Character,Boolean> sortMap(HashMap<Character,Boolean> toSort){
        HashMap<Character,Boolean> agilityOver100AndIsAllyMapAfterSort = new HashMap<>();
        for (Character fightable : toSort.keySet()) {
            int max = 0;
            for (Character fightable1 : toSort.keySet()) {
                if(fightable1.getAgility()>max){
                    agilityOver100AndIsAllyMapAfterSort.put(fightable1,toSort.get(fightable1));
                }
            }
        }
        toSort =  agilityOver100AndIsAllyMapAfterSort;
        return toSort;
    }


    public void addAlly(MainCharacter ally) {
        this.allyAgilityMap.put(ally, ally.getAgility());
    }
}
