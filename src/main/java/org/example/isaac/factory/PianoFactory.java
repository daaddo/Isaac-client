package org.example.isaac.factory;

import org.example.isaac.piano.Piano;
import org.example.isaac.rooms.models.StarterRoom;
import org.example.isaac.RoomCoordinates;

public class PianoFactory {
    public Piano createPiano(){
        int[][] ints = new RoomsFactory().matrixOfRooms();
        return new Piano(new StarterRoom(Piano.getNumero(),new RoomCoordinates((ints.length/2), (ints.length/2 ))),ints);

    }
}
