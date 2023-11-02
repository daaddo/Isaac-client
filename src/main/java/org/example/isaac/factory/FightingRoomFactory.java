package org.example.isaac.factory;

import org.example.isaac.rooms.Factory.RoomFactory;
import org.example.isaac.rooms.models.FightingRoom;
import org.example.isaac.rooms.models.Room;
import org.example.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.isaac.RoomCoordinates;

public class FightingRoomFactory implements RoomFactory {
    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new FightingRoom(roomCoordinates, new NormalFightingBehaviour());
    }
}
