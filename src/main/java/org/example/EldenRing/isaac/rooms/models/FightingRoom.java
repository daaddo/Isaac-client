package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.items.Item;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.EldenRing.other.RoomCoordinates;

import java.util.List;

public class FightingRoom extends Room implements FightingBehaviour{
    FightingBehaviour fightingBehaviour = new NormalFightingBehaviour();


    public FightingRoom(RoomCoordinates coords, FightingBehaviour fightingBehaviour) {
        super(coords);
        this.fightingBehaviour = fightingBehaviour;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public void fight(Character enemy) {

    }

}
