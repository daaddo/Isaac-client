package org.example.isaac.rooms.models;

import org.example.isaac.models.items.Item;
import org.example.isaac.rooms.fight.FightingBehaviour;
import org.example.isaac.RoomCoordinates;

import java.util.List;

public class NormalPrizeRoom extends Room {
    public NormalPrizeRoom(RoomCoordinates coords, FightingBehaviour fightingBehaviour) {
        super(coords, fightingBehaviour);
    }




    @Override
    public List<Item> getItems() {
        return null;
    }
}
