package org.example.EldenRing.isaac;

import org.example.EldenRing.isaac.models.characters.type.MainCharacter;
import org.example.EldenRing.isaac.factory.PianoFactory;
import org.example.EldenRing.isaac.piano.Piano;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<MainCharacter> character;
    private Piano piano;

    public Game(List<MainCharacter> starterCharacter) {
        this.character = starterCharacter ;
        //TODO aaggiungere eccezione se non si possiede il character o se è null o per altre cose
        this.piano = new PianoFactory().createPiano();
    }

    public List<MainCharacter> getCharacter() {
        return character;
    }

    public Piano getPiano() {
        return piano;
    }

    public void startGame() {
        int agilty = 4;
        List<MainCharacter> characters = new LinkedList<>();
    }
}
