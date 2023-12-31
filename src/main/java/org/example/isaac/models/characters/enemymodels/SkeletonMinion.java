package org.example.isaac.models.characters.enemymodels;

import org.example.isaac.models.characters.interactions.skills.DeBuffAllEnemiesSkillInteraction;
import org.example.isaac.models.characters.interactions.skills.StroncaturaSkillInteraction;
import org.example.isaac.models.characters.type.NormalEnemy;
import org.example.isaac.models.characters.Special;
import org.example.isaac.rooms.fight.FightingBehaviour;

import java.util.List;

public class SkeletonMinion extends NormalEnemy {
    public SkeletonMinion(Special enemyType) {
        super("SkElEtoon", 10, 10, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG] SKELETON ATTACKS");
            }
        }, "/images/image-removebg-preview(1).png",enemyType,1,6, List.of(
                new DeBuffAllEnemiesSkillInteraction(2,3),
                new StroncaturaSkillInteraction(2,3,2,3)));
    }
    public void revive(){
        this.setCurrentHealth(this.getMaxHealth()/2);
    }

}
