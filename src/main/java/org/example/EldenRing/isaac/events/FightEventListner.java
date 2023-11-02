package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.models.characters.type.Unit;
import org.example.EldenRing.isaac.models.characters.Target;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;

import java.util.Optional;

public interface FightEventListner <T extends Unit>{
    void getNextTurns(T character, Boolean isally);

    void setTarget(Target target);
    void resetTarget(Target target);

    Boolean isInteractionActive();
    Optional<Skill> getActiveInteraction();

    void startTurn(T character, Boolean isally);
}
