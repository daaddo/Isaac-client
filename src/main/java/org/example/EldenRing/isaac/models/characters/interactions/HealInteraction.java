package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;

public interface HealInteraction extends Interaction{
    void heal(Character character);
}
