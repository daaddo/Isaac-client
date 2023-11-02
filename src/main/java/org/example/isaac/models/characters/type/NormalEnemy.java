package org.example.isaac.models.characters.type;

import org.example.isaac.models.characters.Special;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.piano.Piano;
import org.example.isaac.rooms.fight.FightingBehaviour;

import java.util.List;

public abstract class NormalEnemy extends Enemy{
    private Special enemytipe;
    private List<Skill> skills;


    public NormalEnemy(String name,
                       int maxHealth,
                       int currentHealth,
                       FightingBehaviour fightingBehaviour,
                       String imgPath,
                       Special enemytipe,
                       int difficulty,
                       int agilty,
                       List<Skill> skills
    ) {
        super(name, (int) (maxHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                (int) (currentHealth*enemytipe.getMultiplyier()*(Piano.getNumero()/1.2)),
                fightingBehaviour,
                (int) (difficulty*enemytipe.getMultiplyier()/1.2),
                agilty,
                imgPath
        );
        this.enemytipe= enemytipe;
        this.skills = skills;

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
