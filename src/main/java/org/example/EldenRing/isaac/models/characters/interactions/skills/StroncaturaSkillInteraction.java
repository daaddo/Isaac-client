package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;

public class StroncaturaSkillInteraction extends Skill {
    public StroncaturaSkillInteraction(int contininuousHealingBuffDuration, int contininuousHealingBuffAmount, int weakenDebuffDuration, int weakenDebuffAmount) {
        super("Stroncatura",TargetType.ALL, new WeakenDebuff(weakenDebuffDuration,weakenDebuffAmount),
                new ContinuousHealingHeal(contininuousHealingBuffDuration, contininuousHealingBuffAmount));
    }


    @Override
    public void skillUsage(Character character) {
        character.setCurrentHealth(character.getCurrentHealth()-5);
    }
}
