package org.example.EldenRing.isaac.events;

import org.example.EldenRing.isaac.models.characters.type.MainCharacter;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.RoomCoordinates;

import java.util.List;

public interface GameEventListner {
    void newGame(Piano piano) ;

    void move(RoomCoordinates roomCoordinates);
    void enteredRoom();
    void selectCharacter(List<MainCharacter> character);

}
