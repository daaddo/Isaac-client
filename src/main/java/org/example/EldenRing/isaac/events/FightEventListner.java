package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;

public interface FightEventListner <T extends Character>{
    void startTurn(T character, Boolean isally);
}
