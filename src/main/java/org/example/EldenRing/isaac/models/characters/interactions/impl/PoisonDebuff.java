package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.DebuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class PoisonDebuff<T extends Character> implements DebuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon2";
    private List<T> enemies = new ArrayList<>();

    public PoisonDebuff(int turnsLeft, int amount, T ... enemies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.enemies.addAll(Arrays.asList(enemies));

    }

    public void setEnemies(List<T> enemies) {
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
    public void setTargets(List<T> targets) {
        setEnemies(targets);
    }


    @Override
    public boolean debuff() {
        if (turnsLeft == 0) return false;

        for (Character enemy : enemies) {
            enemy.setCurrentHealth(enemy.getCurrentHealth()-10);
        }
        if (turnsLeft == 0) return false;
        turnsLeft--;
        return true;
    }
}
