package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.rooms.Factory.RoomFactory;
import org.example.EldenRing.isaac.rooms.models.BossRoom;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.other.RoomCoordinates;

public class BossRoomFactory implements RoomFactory {

    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return  new BossRoom(roomCoordinates);
    }
}
