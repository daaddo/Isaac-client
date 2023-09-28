package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public abstract class NormalEnemy extends Enemy {
    private Special enemytipe;
    private int difficultyPoint;


    public NormalEnemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour, String imgPath, Special enemytipe, int difficulty) {
        super(name, (int) (maxHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                (int) (currentHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                fightingBehaviour);
        this.avatarPath=imgPath;
        this.enemytipe= enemytipe;
        this.difficultyPoint= (int) (difficulty*enemytipe.getMultiplyier()/1.2);
    }
    public int getDifficultyPoint() {
        return difficultyPoint;
    }

    @Override
    public String toString() {
        return "NormalEnemy{" +
                "enemytipe=" + enemytipe +
                '}';
    }

    @Override
    public int getValue() {
        return 0;
    }
}
