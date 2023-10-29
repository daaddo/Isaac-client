package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.DebuffInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//TODO aggiungere costruttore
public class PoisonDebuff implements DebuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon2";
    private List<Character> enemies = new ArrayList<>();

    public PoisonDebuff(int turnsLeft, int amount, Character ... enemies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        for (Character enemy : enemies) {
            this.enemies.add(enemy);
        }

    }

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }

    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public void use() {
        debuff();
    }


    @Override
    public void debuff() {
        for (Character enemy : enemies) {
            enemy.setCurrentHealth(enemy.getCurrentHealth()-10);
        }
    }
}
