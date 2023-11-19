package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.type.DebuffInteraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WeakenDebuff<T extends Unit> implements DebuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1NoBg.png";
    private Skill.TargetType targetType;
    List<Unit> enemies = new ArrayList<>();

    public WeakenDebuff(int turnsLeft, int amount, Skill.TargetType targetType, T ... characters) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.targetType = targetType;
        Collections.addAll(this.enemies, characters);

    }

    public void setEnemies(List<Unit> enemies) {
        this.enemies = enemies;
    }
    //TODO Refactorare Character in modo che accetti setAttack
    @Override
    public boolean debuff() {
        if (turnsLeft == 0) return false;
        for (Unit enemy : enemies) {
            enemy.setCurrentHealth(enemy.getCurrentHealth()-amount);
        }
        turnsLeft--;
        return turnsLeft != 0;
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


}
