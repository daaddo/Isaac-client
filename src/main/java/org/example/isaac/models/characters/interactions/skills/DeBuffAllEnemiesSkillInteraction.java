package org.example.isaac.models.characters.interactions.skills;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.isaac.models.characters.interactions.impl.WeakenDebuff;

public class DeBuffAllEnemiesSkillInteraction extends Skill {
    public DeBuffAllEnemiesSkillInteraction(int weakenDebuffDuration, int weakenDebuffAmount) {
        super("DeBuffAllEnemies",
                new WeakenDebuff(weakenDebuffAmount,weakenDebuffDuration,TargetType.ENEMY));
    }

    @Override
    public void skillUsage(Unit unit) {

    }
}

