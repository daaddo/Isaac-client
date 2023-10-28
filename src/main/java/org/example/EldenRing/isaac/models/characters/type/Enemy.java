package org.example.EldenRing.isaac.models.characters.type;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class Enemy extends Character implements Fightable {
    private int difficultyPoint;
    public  Enemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour, int difficultyPoint, int agilty, String avatarPath) {
        super(name, maxHealth, currentHealth, fightingBehaviour, agilty,avatarPath);
        this.difficultyPoint = difficultyPoint;
    }

    @Override
    public int getValue() {
        return 0;
    }
    public int getDifficultyPoint() {
        return difficultyPoint;
    }
    @Override
    public int getAgility(){
        return this.agility;
    }


}
