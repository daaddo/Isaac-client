package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Unit;

public interface BuffInteraction<T extends Unit> extends Interaction<T>{
    boolean buff();

}
