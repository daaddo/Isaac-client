package org.example.EldenRing.Characters.Guerriero;


import org.example.EldenRing.other.Ability;
import org.example.EldenRing.Characters.Person;
import org.example.EldenRing.other.ItemManager;
import org.example.EldenRing.other.ListItems;

import java.util.List;

public class Guerriero extends Person {

    public Guerriero(String name, GuerrieroItemSelector guerrieroSelector){
        super(name,guerrieroSelector );
        this.npc=false;
        this.abilita.add(new Ability(13,"Pippo",4));
        this.abilita.add(new Ability(10,"Papppappero",3));
        this.agility=(guerrieroSelector.getAgility());
        this.armi.add(ItemManager.getInstance().getGuerrieroWeapon());
        this.health= (guerrieroSelector.getHealth());
        this.experience=0;
        this.oggetti= ListItems.getInstance().getSamuraiItems();
        this.maxHealth = this.health;
    }

    public static String toStringStatic(GuerrieroItemSelector selector){
        Guerriero a = new Guerriero("asa",selector);
        List<String> nomiArmi = a.getNomiArmi();
        return "agility= " + a.agility + " health= " + a.health + " armi= " + nomiArmi+" abilita= " + a.abilita.toString();
    }

    @Override
    public String toString() {
        return "agility= " + agility +
                "\n health= " + health +
                "\n abilita= " + abilita +
                "\n armi= " + armi;
    }
    private void exp(){
        System.out.println("sono privato");
    }
}
