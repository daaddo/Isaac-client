package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.DebuffInteraction;

public class WeakenDebuff implements DebuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";

    public WeakenDebuff(int turnsLeft, int amount) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
    }

    @Override
    public void debuff(Character enemy) {
        enemy.setCurrentHealth((int) (enemy.getCurrentHealth()*0.9));
    }
}
