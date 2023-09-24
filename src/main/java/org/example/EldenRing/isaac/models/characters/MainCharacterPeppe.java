package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;

public class MainCharacterPeppe extends Character{
    public MainCharacterPeppe(String name) {
        super(name, 30, 30, new NormalFightingBehaviour());
    }

    @Override
    public int getValue() {
        return 0;
    }
}
