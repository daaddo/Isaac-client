package org.example.EldenRing.other;

import java.util.LinkedList;
import java.util.List;

public class ItemManager{
    private static ItemManager instance;
    public enum ItemSelector{
        ALL,
        SAMURAI,
        GUERRIERO,
        MERCANTE,
        NPC;
    }
    private ItemManager(){

    }
    public static ItemManager getInstance(){
        if(instance == null){
            instance = new ItemManager();
        }
        return instance;
    }

    public List<Item> getAllItems(ItemSelector selector){
        return switch (selector){
            case MERCANTE -> DatabaseManager.getInstance().getMercanteItems();
            case NPC -> DatabaseManager.getInstance().getNpcItems();
            case ALL ->  DatabaseManager.getInstance().getAllItems();
            case SAMURAI -> DatabaseManager.getInstance().getSamuraiItems();
            case GUERRIERO -> DatabaseManager.getInstance().getGuerrieroItems();
        };
    }
    public Item randomItem(){
        List<Item> allItems = DatabaseManager.getInstance().getAllItems();
        float random = (float) Math.random() * 100;
        if (random <= 50) {
            return DatabaseManager.getInstance().randomItem(Rarita.COMUNE);
        }
        if (random <= 75 ) {
            return DatabaseManager.getInstance().randomItem(Rarita.RARO);

        }
        if (random <= 90) {
            return DatabaseManager.getInstance().randomItem(Rarita.EPICO);
        }
        if (random <= 100 ) {
            return DatabaseManager.getInstance().randomItem(Rarita.LEGGENDARIO);
        }
        return null;
    }
    public Weapon getRandoMWeapon(){
        List<Weapon> allWeapons = getAllWeapons();
        float random = (float) Math.random() * 100;
        if (random <= 50) {
            return randomWeapon(Rarita.COMUNE);
        }
        if (random <= 75 ) {
            return randomWeapon(Rarita.RARO);

        }
        if (random <= 92) {
            return randomWeapon(Rarita.EPICO);
        }
        if (random <= 100 ) {
            return randomWeapon(Rarita.LEGGENDARIO);
        }
        return null;
    }
    public Weapon randomWeapon(Rarita rarita){
        List<Weapon> weapons = new LinkedList<>();
        int counter = 0;
        for (Weapon item : getAllWeapons()) {
            if(item.getRarita().equals(rarita)){
                weapons.add(item);
                counter++;
            }
        }
        int a = (int) (Math.random()*counter);
        return weapons.get(a);
    }
    public Weapon getGuerrieroWeapon(){
        return DatabaseManager.getInstance().getGuerrieroWeapon();
    }
    public Weapon getSamuraiWeapon(){
        return DatabaseManager.getInstance().getSamuraiWeapon();
    }
    public List<Weapon> getAllWeapons(){
        return DatabaseManager.getInstance().getAllWeapons();
    }
}
