package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface BuffInteraction extends Interaction{
    void buff(Character self);
}
