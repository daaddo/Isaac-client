package org.example.EldenRing.isaac.rooms.prizeBehaviour;

import org.example.EldenRing.isaac.models.items.Item;
import org.example.EldenRing.isaac.rooms.fight.NoFightingBehaviour;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.RoomCoordinates;

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
