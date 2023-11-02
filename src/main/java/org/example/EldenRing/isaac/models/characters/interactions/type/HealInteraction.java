package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Unit;

public interface HealInteraction<T extends Unit> extends Interaction<T>{
    boolean heal();

}
