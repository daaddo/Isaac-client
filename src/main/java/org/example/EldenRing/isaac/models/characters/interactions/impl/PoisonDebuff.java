package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.DebuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

public class PoisonDebuff implements DebuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon2";
    @Override
    public void debuff(Character enemy) {

    }
}
