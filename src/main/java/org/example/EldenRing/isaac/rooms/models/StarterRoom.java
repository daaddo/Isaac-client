package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.models.items.Item;
import org.example.EldenRing.isaac.rooms.fight.NoFightingBehaviour;
import org.example.EldenRing.other.RoomCoordinates;

import java.util.List;

public class StarterRoom extends Room {
    private int piano;
    public StarterRoom(int piano, RoomCoordinates coords) {
        super(coords, new NoFightingBehaviour());
        // this.nextToRooms = new RoomsFactory().starterRoomRooms();
        this.piano = piano;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }
}
