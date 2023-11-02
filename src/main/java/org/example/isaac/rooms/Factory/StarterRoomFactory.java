package org.example.isaac.rooms.Factory;

import org.example.isaac.piano.Piano;
import org.example.isaac.rooms.models.Room;
import org.example.isaac.rooms.models.StarterRoom;
import org.example.isaac.RoomCoordinates;

public class StarterRoomFactory implements RoomFactory{
    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new StarterRoom(Piano.getNumero(),roomCoordinates);

    }
}
