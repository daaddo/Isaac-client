package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class Enemy extends Character {
    public Enemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, fightingBehaviour);
    }
    public String getAvatarPath(){
        return this.avatarPath;
    }
    @Override
    public int getValue() {
        return 0;
    }
}
