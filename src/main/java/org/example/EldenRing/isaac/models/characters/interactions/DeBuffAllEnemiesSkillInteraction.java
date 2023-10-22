package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingBuff;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;

public class DeBuffAllEnemiesSkillInteraction extends Skill {
    public DeBuffAllEnemiesSkillInteraction() {
        super("DebuffAllEnemies",TargetType.ENEMYTEAM, new WeakenDebuff(), new ContinuousHealingBuff());
    }

    @Override
    public void skillUsage(Character character) {

    }
}

