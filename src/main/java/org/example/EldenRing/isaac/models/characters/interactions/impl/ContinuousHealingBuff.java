package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;

public class ContinuousHealingBuff implements BuffInteraction {

    private int turnsLeft;
    @Override
    public void buff(Character self) {
        self.setMaxHealth(self.getCurrentHealth()+10);
    }
}
