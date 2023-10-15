package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public abstract class NormalEnemy extends Enemy{
    private Special enemytipe;



    public NormalEnemy(String name,
                       int maxHealth,
                       int currentHealth,
                       FightingBehaviour fightingBehaviour,
                       String imgPath,
                       Special enemytipe,
                       int difficulty,
                       int agilty
    ) {
        super(name, (int) (maxHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                (int) (currentHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                fightingBehaviour,
                (int) (difficulty*enemytipe.getMultiplyier()/1.2),
                agilty,
                imgPath
        );
        this.enemytipe= enemytipe;

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
