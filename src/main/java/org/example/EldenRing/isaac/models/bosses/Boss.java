package org.example.EldenRing.isaac.models.bosses;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.other.Weapon;

public abstract class Boss extends Character {
    protected int maxHealth;
    protected int actualHealth;
    protected String name;
    protected Weapon weapon;

    public Boss(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, fightingBehaviour, 3);

    }


    protected abstract void prepare(Piano piano);

}
