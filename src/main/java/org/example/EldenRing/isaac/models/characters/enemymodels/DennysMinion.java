package org.example.EldenRing.isaac.models.characters.enemymodels;

import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.skills.DeBuffAllEnemiesSkillInteraction;
import org.example.EldenRing.isaac.models.characters.interactions.skills.StroncaturaSkillInteraction;
import org.example.EldenRing.isaac.models.characters.type.NormalEnemy;
import org.example.EldenRing.isaac.models.characters.Special;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

import java.util.List;

public class DennysMinion extends NormalEnemy {
    public DennysMinion(Special enemytipe) {
        super("Dennys", 15, 15, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG]: Ghost ha attaccato");
            }
        },"/images/dennys.png",enemytipe,2,5, List.of(new DeBuffAllEnemiesSkillInteraction(2,3,2,3),new StroncaturaSkillInteraction(2,3,2,3)));
    }
}
