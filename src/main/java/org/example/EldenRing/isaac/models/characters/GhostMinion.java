package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class GhostMinion extends NormalEnemy {
    public GhostMinion( Special special) {
        super("Ghost", 20, 20, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG]: Ghost ha attaccato");
            }
        },"C:/images/image-removebg-preview.png",special,2);
    }
}
