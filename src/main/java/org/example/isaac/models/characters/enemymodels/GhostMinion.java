package org.example.isaac.models.characters.enemymodels;

import org.example.isaac.models.characters.interactions.skills.DeBuffAllEnemiesSkillInteraction;
import org.example.isaac.models.characters.interactions.skills.StroncaturaSkillInteraction;
import org.example.isaac.models.characters.type.NormalEnemy;
import org.example.isaac.models.characters.Special;
import org.example.isaac.rooms.fight.FightingBehaviour;

import java.util.List;

public class GhostMinion extends NormalEnemy {
    public GhostMinion( Special special) {
        super("Ghost", 20, 20, new FightingBehaviour() {
            @Override
            public void fight(int piano) {
                System.out.println("[DEBUG]: Ghost ha attaccato");
            }
        },"/images/image-removebg-preview.png",special,2,4, List.of(
                new DeBuffAllEnemiesSkillInteraction(2,3),
                new StroncaturaSkillInteraction(2,3,2,3)));
    }
}
