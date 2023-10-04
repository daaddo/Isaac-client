package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;

public interface DebuffInteraction extends Interaction{
    void debuff(Character enemy);
}
