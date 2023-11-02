package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeaponAttackAttack<T extends Character> implements AttackInteraction<T> {

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
        for (Character character : enemies) {
            character.setCurrentHealth(character.getCurrentHealth()-damage);
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
