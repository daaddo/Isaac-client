package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface BuffInteraction<T extends Character> extends Interaction<T>{
    boolean buff();

}
