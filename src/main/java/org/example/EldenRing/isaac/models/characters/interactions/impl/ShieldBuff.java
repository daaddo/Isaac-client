package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class ShieldBuff implements BuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";
    private List<Character> allies = new ArrayList<>();


    public ShieldBuff(int turnsLeft, int amount, Character ... allies) {
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
        for (Character ally : allies) {
            ally.setMaxHealth(ally.getCurrentHealth()+10);
        }
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
