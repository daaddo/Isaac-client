package org.example.EldenRing.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance;


    private DatabaseManager(){

    }

    public static DatabaseManager getInstance(){
        if(instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }
    public List<Weapon> getAllWeapons(){
        List<Weapon> armi = new ArrayList<>();
        armi.add(new Weapon(10,43,"Bang",Rarita.COMUNE));
        armi.add(new Weapon(10,43,"BaBung",Rarita.COMUNE));
        armi.add(new Weapon(10,43,"BangBung",Rarita.RARO));
        armi.add(new Weapon(10,43,"BangBung",Rarita.RARO));
        armi.add(new Weapon(10,43,"BangBung",Rarita.EPICO));
        armi.add(new Weapon(10,43,"BangBung",Rarita.EPICO));
        armi.add(new Weapon(10,43,"BangBung",Rarita.LEGGENDARIO));
        armi.add(new Weapon(10,43,"BangBung",Rarita.LEGGENDARIO));
        return armi;
    }
    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(Rarita.COMUNE,"Wanderweich",Tipo.ARMATURA ));//0
        items.add(new Item(Rarita.RARO,"Sakanade",Tipo.ARMATURA ));
        items.add(new Item(Rarita.EPICO,"Sakashima",Tipo.ARMATURA ));
        items.add(new Item(Rarita.LEGGENDARIO,"Kokujo",Tipo.ARMATURA ));
        items.add(new Item(Rarita.COMUNE,"Pozione di cura Comune",Tipo.POZIONE_CURATIVA ));//1 //7 //8
        items.add(new Item(Rarita.RARO,"Pozione di cura Rara",Tipo.POZIONE_CURATIVA ));//2
        items.add(new Item(Rarita.EPICO,"Pozione di cura Epica",Tipo.POZIONE_CURATIVA ));
        items.add(new Item(Rarita.COMUNE,"Pozione di Buff Comune",Tipo.POZIONE_BUFF ));//3 //9 //10
        items.add(new Item(Rarita.RARO,"Pozione di Buff Rara",Tipo.POZIONE_BUFF ));//4
        items.add(new Item(Rarita.EPICO,"Pozione di Buff Epica",Tipo.POZIONE_BUFF ));
        items.add(new Item(Rarita.COMUNE,"Pozione di Danno Comune",Tipo.POZIONE_DANNO));//5 //11 //12
        items.add(new Item(Rarita.RARO,"Pozione di Danno Rara",Tipo.POZIONE_DANNO ));//6
        items.add(new Item(Rarita.EPICO,"Pozione di Danno Epica",Tipo.POZIONE_DANNO ));
        return items;
    }
    public List<Item> getSamuraiItems(){
        List<Item> items = getAllItems();
        List<Item> items2 = getAllItems();
        items.remove(1);
        items.remove(2);
        items.remove(3);
        items.remove(6);
        items.remove(9);
        items.remove(12);
        items.add(items2.get(4));
        items.add(items2.get(4));
        items.add(items2.get(7));
        items.add(items2.get(7));
        items.add(items2.get(10));
        items.add(items2.get(10));
        return items;
    }
    public Item randomItem(Rarita rarita){
        List<Item> items1 = new LinkedList<>();
        int counter = 0;
        for (Item item : getAllItems()) {
            if(item.getRarita().equals(rarita)){
                items1.add(item);
                counter++;
            }
        }
        int a = (int) (Math.random()*counter);
        return items1.get(a);
    }

    public List<Item> getMercanteItems() {
        List<Item> items = new LinkedList<>();
        items.add(randomItem(Rarita.COMUNE));
        items.add(randomItem(Rarita.COMUNE));
        items.add(randomItem(Rarita.COMUNE));
        items.add(randomItem(Rarita.RARO));
        items.add(randomItem(Rarita.RARO));
        items.add(randomItem(Rarita.EPICO));
        items.add(randomItem(Rarita.EPICO));
        int seed = (int) (Math.random()*100);
        if (seed >80){
            items.add(randomItem(Rarita.LEGGENDARIO));
        }
        return items;
    }

    public List<Item> getGuerrieroItems() {
        List<Item> items = getAllItems();
        List<Item> items2 = getAllItems();
        items.remove(0);
        items.remove(2);
        items.remove(3);
        items.remove(6);
        items.remove(9);
        items.remove(12);
        items.add(items2.get(4));
        items.add(items2.get(4));
        items.add(items2.get(7));
        items.add(items2.get(7));
        items.add(items2.get(10));
        items.add(items2.get(10));
        return items;
    }
    public Weapon getGuerrieroWeapon(){
        return getAllWeapons().get(1);
    }
    public Weapon getSamuraiWeapon(){
        return getAllWeapons().get(0);
    }

    public List<Item> getNpcItems() {
        List<Item> items= new LinkedList<>();
        items.add(getAllItems().get(5));
        return items;
    }
}
