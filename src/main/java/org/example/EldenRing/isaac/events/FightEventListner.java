package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.models.characters.Fightable;

public interface FightEventListner {
    void startTurn(Fightable fightable);
}
