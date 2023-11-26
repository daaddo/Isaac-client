package org.example.isaac.models.characters.interactions.skills;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.isaac.models.characters.interactions.impl.WeakenDebuff;

public class StroncaturaSkillInteraction extends Skill {
    public StroncaturaSkillInteraction(int contininuousHealingBuffDuration, int contininuousHealingBuffAmount, int weakenDebuffDuration, int weakenDebuffAmount) {
        super("Stroncatura",
                new ContinuousHealingHeal(contininuousHealingBuffDuration,contininuousHealingBuffAmount,TargetType.SELF),
                new WeakenDebuff(weakenDebuffAmount,weakenDebuffDuration,TargetType.ENEMYTEAM));
    }


    @Override
    public void skillUsage(Unit unit) {
        unit.setCurrentHealth(unit.getCurrentHealth()-5);
    }
}
