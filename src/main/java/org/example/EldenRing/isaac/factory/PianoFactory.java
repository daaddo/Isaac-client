package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.models.StarterRoom;
import org.example.EldenRing.other.RoomCoordinates;

public class PianoFactory {
    public Piano createPiano(){
        int[][] ints = new RoomsFactory().matrixOfRooms();
        return new Piano(new StarterRoom(Piano.getNumero(),new RoomCoordinates((ints.length/2), (ints.length/2 ))),ints);

    }
}
