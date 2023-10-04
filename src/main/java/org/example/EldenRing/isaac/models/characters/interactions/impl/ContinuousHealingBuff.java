package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.interactions.BuffInteraction;

public class ContinuousHealingBuff implements BuffInteraction {
    @Override
    public void buff(Character self) {
        self.setMaxHealth(self.getCurrentHealth()+10);
    }
}
