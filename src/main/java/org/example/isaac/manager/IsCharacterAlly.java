package org.example.isaac.manager;

import org.example.isaac.models.characters.type.Fightable;

public class IsCharacterAlly {
    private Fightable character;
    private boolean isAlly;

    public Fightable getCharacter() {
        return character;
    }

    public void setCharacter(Fightable character) {
        this.character = character;
    }

    public boolean isAlly() {
        return isAlly;
    }

    public void setAlly(boolean ally) {
        isAlly = ally;
    }

    public IsCharacterAlly(Fightable character, boolean isAlly) {
        this.character = character;
        this.isAlly = isAlly;
    }
}
