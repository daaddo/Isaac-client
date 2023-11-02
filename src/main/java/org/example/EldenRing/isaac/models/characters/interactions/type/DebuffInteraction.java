package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface DebuffInteraction<T extends Character> extends Interaction<T>{
    boolean debuff();

}
