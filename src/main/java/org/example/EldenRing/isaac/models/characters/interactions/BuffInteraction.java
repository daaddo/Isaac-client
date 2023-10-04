package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;

public interface BuffInteraction extends Interaction{
    void buff(Character self);
}
