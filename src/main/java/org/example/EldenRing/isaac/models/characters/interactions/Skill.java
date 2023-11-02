package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.EldenRing.isaac.models.characters.type.Unit;
import org.example.EldenRing.isaac.models.characters.interactions.type.Interaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public List<Optional<AttackInteraction>> getAttackInteractions(){
        return interactions.stream().filter(interaction -> interaction instanceof AttackInteraction).map(interaction -> Optional.of((AttackInteraction) interaction)).toList();
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
    public abstract void skillUsage(Unit unit);
    public final void activate(Unit unit){

        skillUsage(unit);
    }
}
