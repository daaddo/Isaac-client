package org.example.EldenRing.isaac.rooms.fight;

import org.example.EldenRing.isaac.models.characters.Character;

public class NoFightingBehaviour implements FightingBehaviour {
    public NoFightingBehaviour() {
    }

    @Override
    public void fight(int piano) {
        System.out.println("non ci sono nemici");
    }
}
