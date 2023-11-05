package org.example.isaac.models.characters.interactions.skills;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.impl.ContinuousHealingHeal;
import org.example.isaac.models.characters.interactions.impl.WeakenDebuff;
import org.example.isaac.models.characters.interactions.impl.WeaponAttackAttack;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

import java.util.Arrays;

public class AttackSkillInteraction extends Skill {


    public AttackSkillInteraction(int damage, int weakenDebuffDuration, int weakenDebuffAmount, int contininuousHealingBuffDuration, int contininuousHealingBuffAmount) {
        super("Attack",
                new WeakenDebuff(weakenDebuffAmount,weakenDebuffDuration,TargetType.ENEMY),
                new WeaponAttackAttack(damage,TargetType.ENEMYTEAM),
                new ContinuousHealingHeal(contininuousHealingBuffAmount,contininuousHealingBuffDuration,TargetType.SELF));
    }
    @Override
    public void skillUsage(Unit unit) {
    }
}
