package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.BuffInteraction;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class ShieldBuff<T extends Unit> implements BuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1NoBg.png";
    private Skill.TargetType targetType;
    private List<Unit> allies = new ArrayList<>();


    public ShieldBuff(int turnsLeft, Skill.TargetType targetType, int amount, T ... allies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.targetType = targetType;
        this.allies.addAll(Arrays.asList(allies));
    }

    public void setAllies(List<Unit> allies) {
        this.allies = allies;
    }

    @Override
    public boolean buff() {
        if (turnsLeft == 0) return false;
        for (Unit ally : allies) {
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
    public void setTargets(List<Unit> targets) {
        setAllies(targets);
    }

    @Override
    public List<Unit> getTargets() {
        return allies;
    }

    @Override
    public Skill.TargetType getTargetType() {
        return targetType;
    }

    @Override
    public Interaction clone() throws CloneNotSupportedException {
        ShieldBuff clonedObj =  (ShieldBuff) super.clone();
        clonedObj.turnsLeft = (this.turnsLeft);
        clonedObj.targetType =(this.targetType);
        clonedObj.amount = (this.amount);
        clonedObj.imgPath = (this.imgPath);
        return clonedObj;
    }


}
