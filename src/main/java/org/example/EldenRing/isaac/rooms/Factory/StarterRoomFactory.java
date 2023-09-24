package org.example.EldenRing.isaac.rooms.Factory;

import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.rooms.models.StarterRoom;
import org.example.EldenRing.other.RoomCoordinates;

public class StarterRoomFactory implements RoomFactory{
    @Override
    public Room createRoom(RoomCoordinates roomCoordinates) {
        return new StarterRoom(Piano.getNumero(),roomCoordinates);

    }
}
