package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;
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
