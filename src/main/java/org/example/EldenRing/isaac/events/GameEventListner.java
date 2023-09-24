package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.RoomNotValidExc;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.other.RoomCoordinates;

public interface GameEventListner {
    void newGame(Piano piano) ;

    void move(RoomCoordinates roomCoordinates);
    void enteredRoom();
}
