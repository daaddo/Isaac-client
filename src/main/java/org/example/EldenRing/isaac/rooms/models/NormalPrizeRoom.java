package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.items.Item;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.other.RoomCoordinates;

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
