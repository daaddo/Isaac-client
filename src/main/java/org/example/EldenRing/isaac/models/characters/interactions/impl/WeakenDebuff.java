package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.DebuffInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeakenDebuff implements DebuffInteraction {
    private int turnsLeft;
    private int amount;
    private String imgPath = "/images/icon1";
    List<Character> enemies = new ArrayList<>();

    public WeakenDebuff(int turnsLeft, int amount, Character ... characters) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        for (Character character : characters) {
            this.enemies.add(character);
        }
    }

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void debuff() {
        for (Character character : enemies) {
            character.setCurrentHealth(character.getCurrentHealth()-10);
        }
    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public void use() {
        debuff();
    }


}
