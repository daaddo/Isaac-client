package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.rooms.Factory.RoomFactory;
import org.example.EldenRing.isaac.rooms.models.FightingRoom;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.EldenRing.isaac.RoomCoordinates;

public class FightingRoomFactory implements RoomFactory {
    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new FightingRoom(roomCoordinates, new NormalFightingBehaviour());
    }
}
