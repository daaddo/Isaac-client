package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContinuousHealingBuff implements BuffInteraction {

    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";
    List<Character> allies = new ArrayList<>();

    public ContinuousHealingBuff(int turnsLeft, int amount, Character ... allies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        for (Character ally : allies) {
            this.allies.add(ally);
        }
    }

    public void setAllies(List<Character> allies) {
        this.allies = allies;
    }

    @Override
    public void buff() {
        if (turnsLeft == 0) return;
        for (Character ally : allies) {
            ally.setCurrentHealth(ally.getCurrentHealth()+amount);
        }
        turnsLeft--;

    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public void use() {
        buff();
    }



}
