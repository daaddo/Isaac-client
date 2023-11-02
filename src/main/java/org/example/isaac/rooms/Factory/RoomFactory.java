package org.example.isaac.rooms.Factory;

import org.example.isaac.rooms.models.Room;
import org.example.isaac.RoomCoordinates;

public abstract interface RoomFactory {
    public abstract Room createRoom(RoomCoordinates roomCoordinates);
}
