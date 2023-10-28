package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface DebuffInteraction extends Interaction{
    void debuff(Character enemy);
}
