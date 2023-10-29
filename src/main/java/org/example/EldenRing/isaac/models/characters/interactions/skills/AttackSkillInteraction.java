package org.example.EldenRing.isaac.models.characters.interactions.skills;

import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingBuff;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeakenDebuff;
import org.example.EldenRing.isaac.models.characters.interactions.impl.WeaponAttackAttack;
import org.example.EldenRing.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.EldenRing.isaac.models.characters.interactions.type.Interaction;
import org.example.EldenRing.isaac.models.characters.type.Character;

public class AttackSkillInteraction extends Skill {


    public AttackSkillInteraction() {
        super("SkillTEST ATTACK", TargetType.ENEMY,
                new WeaponAttackAttack(3), new WeakenDebuff(5,5), new ContinuousHealingBuff(5,5), new WeaponAttackAttack(4));
    }

    @Override
    public void skillUsage(Character character) {
        character.setCurrentHealth(character.getCurrentHealth()-5);
    }
}
