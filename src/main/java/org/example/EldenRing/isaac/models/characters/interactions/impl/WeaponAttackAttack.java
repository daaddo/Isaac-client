package org.example.EldenRing.isaac.models.characters.interactions.impl;

import org.example.EldenRing.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeaponAttackAttack implements AttackInteraction {

    private int damage;



    private List<Character> enemies = new ArrayList<>();
    public WeaponAttackAttack(int damage, Character ... enemies) {
        this.damage = damage;
        for (Character enemy : enemies) {
            this.enemies.add(enemy);
        }
    }

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void attack(Character enemy) {
        for (Character character : enemies) {
            character.setCurrentHealth(character.getCurrentHealth()-damage);
        }
    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.empty();
    }

    @Override
    public void use() {

    }



}
