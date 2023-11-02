package org.example.isaac.factory;

import org.example.isaac.rooms.Factory.RoomFactory;
import org.example.isaac.rooms.models.BossRoom;
import org.example.isaac.rooms.models.Room;
import org.example.isaac.RoomCoordinates;

public class BossRoomFactory implements RoomFactory {

    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return  new BossRoom(roomCoordinates);
    }
}
