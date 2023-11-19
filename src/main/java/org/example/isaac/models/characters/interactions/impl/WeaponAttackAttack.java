package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WeaponAttackAttack<T extends Unit> implements AttackInteraction<T> {

    private int damage;
    private Skill.TargetType targetType;


    private List<Unit> enemies = new ArrayList<>();
    public WeaponAttackAttack(int damage, Skill.TargetType targetType, T ... enemies) {
        this.damage = damage;
        this.targetType = targetType;
        Collections.addAll(this.enemies, enemies);
    }

    public void setEnemies(List<Unit> enemies) {
        this.enemies = enemies;
    }

    @Override
    public boolean attack() {
        for (Unit unit : enemies) {
            unit.setCurrentHealth(unit.getCurrentHealth()-damage);
        }
        return true;
    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.empty();
    }

    @Override
    public  boolean use() {
        return attack();
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
