package org.example.isaac.models.characters.interactions.skills;

import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.isaac.models.characters.interactions.impl.WeakenDebuff;

public class OnAlliesTestSkillInteraction extends Skill {
    public OnAlliesTestSkillInteraction(int contininuousHealingBuffDuration, int contininuousHealingBuffAmount, int weakenDebuffDuration, int weakenDebuffAmount) {
        super("TESTSKILL TYPE ALLY",TargetType.ALLYTEAM,
                new WeakenDebuff(weakenDebuffDuration , weakenDebuffAmount),
                new ContinuousHealingHeal(contininuousHealingBuffDuration, contininuousHealingBuffAmount));
    }


    @Override
    public void skillUsage(Unit unit) {
        unit.setCurrentHealth(unit.getCurrentHealth()-5);
    }
}