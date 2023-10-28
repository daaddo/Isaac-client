package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;
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

