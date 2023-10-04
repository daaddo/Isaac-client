package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.interactions.DebuffInteraction;

public class WeakenDebuff implements DebuffInteraction {
    @Override
    public void debuff(Character enemy) {
        enemy.setCurrentHealth((int) (enemy.getCurrentHealth()*0.9));
    }
}
