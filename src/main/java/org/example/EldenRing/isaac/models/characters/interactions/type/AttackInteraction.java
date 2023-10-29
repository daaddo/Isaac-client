package org.example.EldenRing.isaac.models.characters.interactions.type;

import org.example.EldenRing.isaac.models.characters.type.Character;

public interface AttackInteraction extends Interaction{
    void attack(Character enemy);

}
