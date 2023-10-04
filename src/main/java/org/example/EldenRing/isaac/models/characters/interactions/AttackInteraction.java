package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;

public interface AttackInteraction extends Interaction{
    void attack(Character enemy);
}
