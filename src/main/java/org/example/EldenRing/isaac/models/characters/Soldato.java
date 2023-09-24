package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public abstract class Soldato extends Character {

    public Soldato(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, fightingBehaviour);
    }

    @Override
    public int getValue() {
        return 0;
    }
}
