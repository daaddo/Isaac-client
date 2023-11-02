package org.example.isaac.rooms.models;

import org.example.isaac.models.items.Item;
import org.example.isaac.rooms.fight.NoFightingBehaviour;
import org.example.isaac.RoomCoordinates;

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
