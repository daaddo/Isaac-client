package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

public class ShieldBuff implements BuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";

    @Override
    public void buff(Character self) {

    }
}
