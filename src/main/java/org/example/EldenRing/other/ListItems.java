package org.example.EldenRing.other;

import java.util.LinkedList;
import java.util.List;

public class ListItems {
    private List<Item> items = new LinkedList<>();
    private static ListItems instance = null;
    ListItems(){
        items.add(new Item(Rarita.COMUNE,"Wanderweich",Tipo.ARMATURA ));
        items.add(new Item(Rarita.RARO,"Sakanade",Tipo.ARMATURA ));
        items.add(new Item(Rarita.EPICO,"Sakashima",Tipo.ARMATURA ));
        items.add(new Item(Rarita.LEGGENDARIO,"Kokujo",Tipo.ARMATURA ));
        items.add(new Item(Rarita.COMUNE,"Pozione di cura Comune",Tipo.POZIONE_CURATIVA ));
        items.add(new Item(Rarita.RARO,"Pozione di cura Rara",Tipo.POZIONE_CURATIVA ));
        items.add(new Item(Rarita.EPICO,"Pozione di cura Epica",Tipo.POZIONE_CURATIVA ));
        items.add(new Item(Rarita.COMUNE,"Pozione di Buff Comune",Tipo.POZIONE_BUFF ));
        items.add(new Item(Rarita.RARO,"Pozione di Buff Rara",Tipo.POZIONE_BUFF ));
        items.add(new Item(Rarita.EPICO,"Pozione di Buff Epica",Tipo.POZIONE_BUFF ));
        items.add(new Item(Rarita.COMUNE,"Pozione di Danno Comune",Tipo.POZIONE_DANNO));
        items.add(new Item(Rarita.RARO,"Pozione di Danno Rara",Tipo.POZIONE_DANNO ));
        items.add(new Item(Rarita.EPICO,"Pozione di Danno Epica",Tipo.POZIONE_DANNO ));
    }
    //metodo per gettare l instanza
    public static ListItems getInstance(){
        if (instance==null){
            instance=new ListItems();
        }
        return instance;
    }
    public List<Item> getSamuraiItems(){
        if (instance==null){
            instance=new ListItems();
        }
        List<Item> item = new LinkedList<>();
        item.add(items.get(4));
        item.add(items.get(9));
        item.add(items.get(5));
        item.add(items.get(3));
        item.add(items.get(1));
        item.add(items.get(4));
        item.add(items.get(8));
        item.add(items.get(1));
        item.add(items.get(10));
        item.add(items.get(11));
        item.add(items.get(9));
        return item;
    }

    private Item randomItem(Rarita rarita, boolean mercant){
        List<Item> items1 = new LinkedList<>();
        int counter = 0;
        for (Item item : items) {
            if(item.getRarita().equals(rarita)){
                items1.add(item);
                counter++;
            }
        }
        if (mercant){
            int a = (int) (Math.random()*counter);
            return items1.get(a);
        }
        int a = (int) (Math.random()*counter);
        System.out.println("hai trovato "+items1.get(a).toString());
        return items1.get(a);
    }
    public Item randomItemGenerator(){
        float random = (float) Math.random() * 100;
            if (random <= 50) {
                return randomItem(Rarita.COMUNE,false);
            }
            if (random <= 75 ) {
                return randomItem(Rarita.RARO,false);
            }
            if (random <= 90) {
                return randomItem(Rarita.EPICO,false);
            }
            if (random <= 100 ) {
                return randomItem(Rarita.LEGGENDARIO,false);
            }
            System.out.println("hai ottenuto un oggetto");
        return null;
    }

    public List<Item> getMercanteItems(int livello) {
        List<Item> items = new LinkedList<>();
        items.add(randomItem(Rarita.COMUNE,true));
        items.add(randomItem(Rarita.COMUNE,true));
        items.add(randomItem(Rarita.COMUNE,true));
        items.add(randomItem(Rarita.RARO,true));
        items.add(randomItem(Rarita.RARO,true));
        items.add(randomItem(Rarita.EPICO,true));
        items.add(randomItem(Rarita.EPICO,true));
        int seed = (int) (Math.random()*100);
        if (seed >80){
            items.add(randomItem(Rarita.LEGGENDARIO,true));
        }
        return items;
    }
}
