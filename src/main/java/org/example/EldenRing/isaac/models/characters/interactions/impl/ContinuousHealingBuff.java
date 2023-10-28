package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;

public class ContinuousHealingBuff implements BuffInteraction {

    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";

    public ContinuousHealingBuff(int turnsLeft, int amount) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
    }

    @Override
    public void buff(Character self) {
        if (turnsLeft > 0) {
            self.setMaxHealth(self.getCurrentHealth()+10);
        }
        turnsLeft--;
    }
}
