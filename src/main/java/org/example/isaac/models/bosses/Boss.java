package org.example.isaac.models.bosses;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.rooms.fight.FightingBehaviour;


public abstract class Boss extends Unit {
    protected int maxHealth;
    protected int actualHealth;
    protected String name;

    public Boss(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, fightingBehaviour, 3,"");

    }




}
