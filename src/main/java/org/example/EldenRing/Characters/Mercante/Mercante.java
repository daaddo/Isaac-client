package org.example.EldenRing.Characters.Mercante;


import org.example.EldenRing.Characters.Person;
import org.example.EldenRing.other.ListItems;

public class Mercante extends Person {
    public Mercante(String nome, int livello, MercanteItemSelector mercanteItemSelector){
        super(nome, mercanteItemSelector);
        this.oggetti= ListItems.getInstance().getMercanteItems(livello);
    }
}
