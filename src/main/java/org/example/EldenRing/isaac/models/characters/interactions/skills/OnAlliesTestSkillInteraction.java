package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingBuff;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;

public class OnAlliesTestSkillInteraction extends Skill {
    public OnAlliesTestSkillInteraction() {
        super("TESTSKILL TYPE ALLY",TargetType.ALLYTEAM, new WeakenDebuff(), new ContinuousHealingBuff());
    }


    @Override
    public void skillUsage(Character character) {
        character.setCurrentHealth(character.getCurrentHealth()-5);
    }
}
