package org.example.isaac.models.characters.interactions.skills;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.isaac.models.characters.interactions.impl.WeakenDebuff;

public class OnAlliesTestSkillInteraction extends Skill {
    public OnAlliesTestSkillInteraction(int weakenDebuffDuration, int weakenDebuffAmount, int contininuousHealingBuffDuration, int contininuousHealingBuffAmount) {
        super("TESTSKILL TYPE ALLY",
                new WeakenDebuff(weakenDebuffDuration , weakenDebuffAmount, TargetType.ENEMY),
                new ContinuousHealingHeal(contininuousHealingBuffDuration, contininuousHealingBuffAmount, TargetType.ALLYTEAM));
    }


    @Override
    public void skillUsage(Unit unit) {
        unit.setCurrentHealth(unit.getCurrentHealth()-5);
    }
}
