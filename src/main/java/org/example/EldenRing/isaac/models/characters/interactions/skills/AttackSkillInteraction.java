package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeaponAttackAttack;
import org.example.EldenRing.isaac.models.characters.interactions.type.Interaction;
import org.example.EldenRing.isaac.models.characters.type.Character;

import java.util.Arrays;

public class AttackSkillInteraction extends Skill {


    public AttackSkillInteraction() {
        super("SkillTEST ATTACK", TargetType.ENEMY,
                new WeaponAttackAttack(3), new WeakenDebuff(5,5), new ContinuousHealingHeal(5,5), new WeaponAttackAttack(4));
    }
    public void setTargets(Character ... characters){
        for (Interaction interaction : getInteractions()) {
            interaction.setTargets(Arrays.stream(characters).toList());
        }
    }
    @Override
    public void skillUsage(Character character) {
    }
}
