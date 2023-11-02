package org.example.EldenRing.isaac;

import org.example.EldenRing.isaac.models.characters.type.MainUnit;
import org.example.EldenRing.isaac.factory.PianoFactory;
import org.example.EldenRing.isaac.piano.Piano;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<MainUnit> character;
    private Piano piano;

    public Game(List<MainUnit> starterCharacter) {
        this.character = starterCharacter ;
        //TODO aaggiungere eccezione se non si possiede il character o se è null o per altre cose
        this.piano = new PianoFactory().createPiano();
    }

    public List<MainUnit> getCharacter() {
        return character;
    }

    public Piano getPiano() {
        return piano;
    }

    public void startGame() {
        int agilty = 4;
        List<MainUnit> characters = new LinkedList<>();
    }
}
