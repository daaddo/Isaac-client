package org.example.EldenRing.isaac;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.MainCharacterPeppe;
import org.example.EldenRing.isaac.factory.PianoFactory;
import org.example.EldenRing.isaac.piano.Piano;

public class Game {
    private Character character;
    private Piano piano;

    public Game(Character starterCharacter) {
        this.character = starterCharacter ;
        //TODO aaggiungere eccezione se non si possiede il character o se è null o per altre cose
        this.piano = new PianoFactory().createPiano();
    }

    public Character getCharacter() {
        return character;
    }

    public Piano getPiano() {
        return piano;
    }

    public void startGame() {

        character = new MainCharacterPeppe("nome");
    }
}
