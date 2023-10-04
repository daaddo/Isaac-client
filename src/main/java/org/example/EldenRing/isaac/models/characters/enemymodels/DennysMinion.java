package org.example.EldenRing.isaac.models.characters.enemymodels;

import org.example.EldenRing.isaac.models.characters.NormalEnemy;
import org.example.EldenRing.isaac.models.characters.Special;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class DennysMinion extends NormalEnemy {
    public DennysMinion(Special enemytipe) {
        super("Dennys", 15, 15, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG]: Ghost ha attaccato");
            }
        },"C:/images/dennys.png",enemytipe,2,5);
    }
}
