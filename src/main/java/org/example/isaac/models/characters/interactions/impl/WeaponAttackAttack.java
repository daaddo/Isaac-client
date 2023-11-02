package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeaponAttackAttack<T extends Unit> implements AttackInteraction<T> {

    private int damage;



    private List<T> enemies = new ArrayList<>();
    public WeaponAttackAttack(int damage, T ... enemies) {
        this.damage = damage;
        for (T enemy : enemies) {
            this.enemies.add(enemy);
        }
    }

    public void setEnemies(List<T> enemies) {
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
    public void setTargets(List<T> targets) {
        setEnemies(targets);
    }


}
