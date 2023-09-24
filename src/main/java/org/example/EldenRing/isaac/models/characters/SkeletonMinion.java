package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class SkeletonMinion extends Soldato {
    public SkeletonMinion(String name, int maxHealth, int currentHealth) {
        super(name, maxHealth, currentHealth, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("ahah sono uno scheletro e t attacco");
            }
        });
    }
    public void revive(){
        this.setCurrentHealth(this.getMaxHealth()/2);
    }
}
