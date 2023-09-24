package org.example.EldenRing.isaac.rooms.Factory;

import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.other.RoomCoordinates;

public abstract interface RoomFactory {
    public abstract Room createRoom(RoomCoordinates roomCoordinates);
}
