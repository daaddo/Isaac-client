package org.example.isaac.models.characters.interactions;

import org.example.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.interactions.type.Interaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Skill<T extends Unit> {
    private String name;
    private List<Interaction<T>> interactions;
    private TargetType targetType;
    public enum TargetType{
        SELF,
        ENEMY,
        DEAD,
        ALLYTEAM,
        ENEMYTEAM,
        ALL;
    }

    public List<Interaction<T>> getInteractions() {
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

    public Skill(String name, TargetType targetType, Interaction<T> ... interactions) {
        this.name = name;
        this.interactions = Arrays.stream(interactions).toList();
        this.targetType = targetType;
    }
    public abstract void skillUsage(Unit unit);
    public final void activate(Unit unit){

        skillUsage(unit);
    }
}
