package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.type.Character;
import org.example.EldenRing.isaac.models.characters.interactions.type.BuffInteraction;
import org.example.EldenRing.isaac.models.characters.interactions.type.Interaction;

import java.util.Arrays;
import java.util.List;

public abstract class Skill {
    private String name;
    private List<Interaction> interactions;
    private TargetType targetType;
    public enum TargetType{
        SELF,
        ENEMY,
        DEAD,
        ALLYTEAM,
        ENEMYTEAM,
        ALL;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public String getName() {
        return name;
    }

    public TargetType getTarget() {
        return this.targetType;
    }

    public Skill(String name, TargetType targetType, Interaction ... interactions) {
        this.name = name;
        this.interactions = Arrays.stream(interactions).toList();
        this.targetType = targetType;
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
