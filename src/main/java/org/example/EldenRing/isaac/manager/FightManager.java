package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;
import org.example.EldenRing.isaac.models.characters.MainCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightManager {
    private static FightManager instance = null;

    private FightManager() {
    }
    private Map<Fightable,Integer> allyAgilityMap = new HashMap();
    private Map<Fightable,Integer> enemyAgilityMap = new HashMap<>();

    public static FightManager getInstance() {
        if (instance == null) {
            instance = new FightManager();
        }
        return instance;
    }

    private void init(List<Fightable> ally,List<Fightable> enemy){
        for (Fightable fightable : ally) {
            this.allyAgilityMap.put(fightable, fightable.getAgility());
        }
        for (Fightable fightable : enemy) {
            this.enemyAgilityMap.put(fightable, fightable.getAgility());
        }
    }
    public void combatAllyVSenemies(List<Fightable> ally, List<Fightable> enemy){
            init(ally, enemy);
            HashMap<Fightable, Boolean> agilityOver100AndIsAllyMap = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            while (agilityOver100AndIsAllyMap.size() == 0) {
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
            HashMap<Fightable, Boolean> sortedMapByAgility = sortMap(agilityOver100AndIsAllyMap);
            sortedMapByAgility.forEach((key, value) -> System.out.println("" + key.getNome() + "  " + value));
            for (Fightable fightable : sortedMapByAgility.keySet()) {
                GameManager.getInstance().giveTurn(fightable,true);

            }
            //TODO AGGIUNGERE UTILIZZO DELL ABILITà E FAR PARTITRE UIN EVENTO PER CUI VIENE SELEZIONATO ILK GIOCATORE CORRENTE
            agilityOver100AndIsAllyMap.clear();
        }
    }
    public  HashMap<Fightable,Boolean> sortMap(HashMap<Fightable,Boolean> toSort){
        HashMap<Fightable,Boolean> agilityOver100AndIsAllyMapAfterSort = new HashMap<>();
        for (Fightable fightable : toSort.keySet()) {
            int max = 0;
            for (Fightable fightable1 : toSort.keySet()) {
                if(fightable1.getAgility()>max){
                    agilityOver100AndIsAllyMapAfterSort.put(fightable1,toSort.get(fightable1));
                }

            }

        }
        toSort =  agilityOver100AndIsAllyMapAfterSort;
        return toSort;
    }

    public static void main(String[] args) {
        List<Fightable> ally = new ArrayList<>();
        List<Fightable> enemy = new ArrayList<>();

        ally.add(new MainCharacter("asd",null,4));
        ally.add(new MainCharacter("da",null,6));
        ally.add(new MainCharacter("asdaad",null,8));
        ally.add(new MainCharacter("asdssd",null,10));
        enemy.add(new MainCharacter("susu",null,4));
        enemy.add(new MainCharacter("susu",null,9));
        enemy.add(new MainCharacter("susu",null,3));
        enemy.add(new MainCharacter("susu",null,7));
        FightManager.getInstance().combatAllyVSenemies(ally,enemy);
    }
}
