package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.isaac.rooms.prizeBehaviour.Droppable;

public abstract class Character implements Droppable {
    private String name;
    private int maxHealth;
    private int currentHealth;
    protected FightingBehaviour fightingBehaviour;
    protected String avatarPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Character(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.fightingBehaviour = fightingBehaviour;
    }
}
