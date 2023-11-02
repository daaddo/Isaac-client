package org.example.isaac.rooms.models;

import org.example.isaac.models.items.Item;
import org.example.isaac.rooms.fight.FightingBehaviour;
import org.example.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.isaac.RoomCoordinates;

import java.util.List;

public class FightingRoom extends Room implements FightingBehaviour{
    FightingBehaviour fightingBehaviour = new NormalFightingBehaviour();


    public FightingRoom(RoomCoordinates coords, FightingBehaviour fightingBehaviour) {
        super(coords, fightingBehaviour);
        this.fightingBehaviour = fightingBehaviour;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public void fight(int piano) {

    }

}
