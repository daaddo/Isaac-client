package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.DebuffInteraction;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class PoisonDebuff<T extends Unit> implements DebuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon2NoBg.png";
    private Skill.TargetType targetType;
    private List<Unit> enemies = new ArrayList<>();

    public PoisonDebuff(int turnsLeft, int amount, Skill.TargetType targetType, T ... enemies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.targetType = targetType;
        this.enemies.addAll(Arrays.asList(enemies));

    }

    public void setEnemies(List<Unit> enemies) {
        this.enemies = enemies;
    }

    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public  boolean use() {
        return debuff();
    }

    @Override
    public void setTargets(List<Unit> targets) {
        setEnemies(targets);
    }

    @Override
    public List<Unit> getTargets() {
        return enemies;
    }

    @Override
    public Skill.TargetType getTargetType() {
        return targetType;
    }

    @Override
    public Interaction clone() throws CloneNotSupportedException {
        PoisonDebuff clonedObj =  (PoisonDebuff) super.clone();
        clonedObj.turnsLeft = (this.turnsLeft);
        clonedObj.targetType =(this.targetType);
        clonedObj.amount = (this.amount);
        clonedObj.imgPath = (this.imgPath);
        return clonedObj;

    }


    @Override
    public boolean debuff() {
        if (turnsLeft == 0) return false;

        for (Unit enemy : enemies) {
            enemy.setCurrentHealth(enemy.getCurrentHealth()-10);
        }
        if (turnsLeft == 0) return false;
        turnsLeft--;
        return true;
    }
}
