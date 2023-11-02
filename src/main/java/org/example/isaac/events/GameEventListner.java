package org.example.isaac.events;

import org.example.isaac.models.characters.type.MainUnit;
import org.example.isaac.piano.Piano;
import org.example.isaac.RoomCoordinates;

import java.util.List;

public interface GameEventListner {
    void newGame(Piano piano) ;

    void move(RoomCoordinates roomCoordinates);
    void enteredRoom();
    void selectCharacter(List<MainUnit> character);

}
