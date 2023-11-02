package org.example.isaac.factory;

import org.example.isaac.rooms.Factory.RoomFactory;
import org.example.isaac.rooms.fight.NoFightingBehaviour;
import org.example.isaac.rooms.models.NormalPrizeRoom;
import org.example.isaac.rooms.models.Room;
import org.example.isaac.RoomCoordinates;

public class NormalPrizeRoomFactory implements RoomFactory {


    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new NormalPrizeRoom(roomCoordinates, new NoFightingBehaviour());
    }
}
