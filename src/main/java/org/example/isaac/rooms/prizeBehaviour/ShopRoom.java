package org.example.isaac.rooms.prizeBehaviour;

import org.example.isaac.models.items.Item;
import org.example.isaac.rooms.fight.NoFightingBehaviour;
import org.example.isaac.rooms.models.Room;
import org.example.isaac.RoomCoordinates;

import java.util.List;

public class ShopRoom extends Room {
    public ShopRoom(RoomCoordinates coords) {
        super(coords, new NoFightingBehaviour());
    }

    @Override
    public List<Item> getItems() {
        return null;
    }
}
