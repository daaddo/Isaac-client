package org.example.isaac.models.characters.type;

import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.rooms.fight.FightingBehaviour;
import org.example.isaac.rooms.prizeBehaviour.Droppable;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements Droppable {
    private String name;
    private int maxHealth;
    private int currentHealth;
    protected FightingBehaviour fightingBehaviour;
    protected String avatarPath;
    protected int agility;
    protected List<Interaction<? extends Unit>> activeInteractions = new ArrayList<>();


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


    public Unit(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour, int agility, String avatarPath) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.fightingBehaviour = fightingBehaviour;
        this.agility = agility;
        this.avatarPath = avatarPath;
    }
    public String getAvatarPath() {
        return avatarPath;
    }
    public int getAgility() {
        return agility;
    }

    public List<Interaction<? extends Unit>> getActiveInteractions() {
        return activeInteractions;
    }

    public void setActiveInteractions(List<Interaction<? extends Unit>> activeInteractions) {
        this.activeInteractions = activeInteractions;
    }
}
