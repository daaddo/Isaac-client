package org.example.isaac.events;

import org.example.isaac.models.characters.Target;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

public interface CharactersEventListner<T extends Unit> {
    void setInteractionsToOtherCharacters(Skill.TargetType type, Interaction<T> interaction);
}