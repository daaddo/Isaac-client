package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;
import org.example.EldenRing.isaac.models.characters.Target;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;

public interface FightEventListner <T extends Character>{
    void startTurn(T character, Boolean isally);
    @Deprecated(forRemoval = true)
    void setColor(Skill.TargetType targetType);
    void setTarget(Target target);
    void resetTarget();
}
