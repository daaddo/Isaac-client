package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface HealInteraction extends Interaction{
    void heal(Character character);
}
