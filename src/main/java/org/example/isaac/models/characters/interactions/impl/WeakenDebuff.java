package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.type.DebuffInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeakenDebuff<T extends Unit> implements DebuffInteraction<T> {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";
    List<T> enemies = new ArrayList<>();

    public WeakenDebuff(int turnsLeft, int amount, T ... characters) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        for (T character : characters) {
            this.enemies.add(character);
        }
    }

    public void setEnemies(List<T> enemies) {
        this.enemies = enemies;
    }
    //TODO Refactorare Character in modo che accetti setAttack
    @Override
    public boolean debuff() {
        if (turnsLeft == 0) return false;
        for (Unit enemy : enemies) {
            enemy.setCurrentHealth(enemy.getCurrentHealth()-amount);
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
        return debuff();
    }

    @Override
    public void setTargets(List<T> targets) {
        setEnemies(targets);
    }


}
