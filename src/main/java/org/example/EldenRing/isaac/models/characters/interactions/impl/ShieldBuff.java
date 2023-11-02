package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class ShieldBuff<T extends Character> implements BuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";
    private List<T> allies = new ArrayList<>();


    public ShieldBuff(int turnsLeft, int amount, T ... allies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.allies.addAll(Arrays.asList(allies));
    }

    public void setAllies(List<T> allies) {
        this.allies = allies;
    }

    @Override
    public boolean buff() {
        if (turnsLeft == 0) return false;
        for (Character ally : allies) {
            ally.setCurrentHealth(ally.getCurrentHealth()+amount);
        }
        if (turnsLeft == 0) return false;
        turnsLeft--;
        return true;
    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public  boolean use() {
        return buff();
    }

    @Override
    public void setTargets(List<T> targets) {
        setAllies(targets);
    }


}
