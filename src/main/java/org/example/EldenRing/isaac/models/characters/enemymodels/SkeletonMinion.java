package org.example.EldenRing.isaac.models.characters.enemymodels;

import org.example.EldenRing.isaac.models.characters.NormalEnemy;
import org.example.EldenRing.isaac.models.characters.Special;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class SkeletonMinion extends NormalEnemy {
    public SkeletonMinion(Special enemyType) {
        super("SkElEtoon", 10, 10, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG] SKELETON ATTACKS");
            }
        },"C:/images/image-removebg-preview (1).png",enemyType,1,6);
    }
    public void revive(){
        this.setCurrentHealth(this.getMaxHealth()/2);
    }

}
