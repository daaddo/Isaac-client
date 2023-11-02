package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;

public class DeBuffAllEnemiesSkillInteraction extends Skill {
    public DeBuffAllEnemiesSkillInteraction(int contininuousHealingBuffDuration, int contininuousHealingBuffAmount, int weakenDebuffDuration, int weakenDebuffAmount) {
        super("DebuffAllEnemies",TargetType.ENEMYTEAM,
                new ContinuousHealingHeal(contininuousHealingBuffAmount,contininuousHealingBuffDuration),
                new WeakenDebuff(weakenDebuffAmount,weakenDebuffDuration));
    }

    @Override
    public void skillUsage(Character character) {

    }
}

