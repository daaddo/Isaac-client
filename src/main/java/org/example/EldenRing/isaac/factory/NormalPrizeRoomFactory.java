package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.rooms.Factory.RoomFactory;
import org.example.EldenRing.isaac.rooms.fight.NoFightingBehaviour;
import org.example.EldenRing.isaac.rooms.models.NormalPrizeRoom;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.RoomCoordinates;

public class NormalPrizeRoomFactory implements RoomFactory {


    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new NormalPrizeRoom(roomCoordinates, new NoFightingBehaviour());
    }
}
