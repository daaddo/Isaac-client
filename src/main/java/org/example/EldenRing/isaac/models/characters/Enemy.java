package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class Enemy extends Character implements Fightable {
    private int difficultyPoint;
    public Enemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour, int difficultyPoint, int agilty) {
        super(name, maxHealth, currentHealth, fightingBehaviour, agilty);
        this.difficultyPoint = difficultyPoint;
    }
    public String getAvatarPath(){
        return this.avatarPath;
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
        return this.getAgility();
    }

    @Override
    public String getNome() {
        return getName();
    }
}
