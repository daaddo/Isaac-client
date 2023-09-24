package org.example.EldenRing.Characters.Npc;


import org.example.EldenRing.other.Ability;
import org.example.EldenRing.Characters.Person;
import org.example.EldenRing.other.Weapon;

import java.util.List;

public class Npc extends Person {

    public Npc(String name, float health, int agility, int experience, Ability ability, List<Weapon> arma, int money, NpcItemSelector npcItemSelector) {
        super(name, npcItemSelector);
        this.npc=true;
        this.health=health;
        this.agility=agility;
        this.experience = experience;
        this.abilita.add(ability);
        this.armi = npcItemSelector.getWeapons();
        this.maxHealth = this.health;
        this.money = money;
    }
}
