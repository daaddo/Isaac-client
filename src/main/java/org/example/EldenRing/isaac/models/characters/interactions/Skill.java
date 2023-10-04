package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.Character;

import java.util.Arrays;
import java.util.List;

public abstract class Skill {
    private String name;
    private List<Interaction> interactions;
    public enum Target{
        SELF,
        ENEMY,
        DEAD,
        ALLYTEAM,
        ENEMYTEAM,
        ALL;
    }
    public Skill(String name,Interaction ... interactions) {
        this.name = name;
        this.interactions = Arrays.stream(interactions).toList();
    }
    public abstract void skillUsage(Character character);
    public final void activate(Character character){
        for (Interaction interaction : interactions) {
            if (interaction instanceof BuffInteraction buff) {
                buff.buff(character);
            }
        }
        skillUsage(character);
    }
}
