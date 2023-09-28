package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class GhostMinion extends Enemy{
    public GhostMinion(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG]: Ghost ha attaccato");
            }
        });
    }
}
