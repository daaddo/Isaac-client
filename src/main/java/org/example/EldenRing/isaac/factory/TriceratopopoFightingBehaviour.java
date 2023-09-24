package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class TriceratopopoFightingBehaviour implements FightingBehaviour {
   @Override
    public void fight(Character enemy) {
        System.out.println("attacco del triceratopo");
    }
}
