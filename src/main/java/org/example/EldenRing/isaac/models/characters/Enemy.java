package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class Enemy extends Character {
    private int difficultyPoint;
    public Enemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour, int difficultyPoint) {
        super(name, maxHealth, currentHealth, fightingBehaviour);
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
}
