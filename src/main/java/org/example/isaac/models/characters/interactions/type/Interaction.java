package org.example.isaac.models.characters.interactions.type;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.type.Unit;

import java.util.List;
import java.util.Optional;


public interface Interaction<T extends Unit>{
    Optional<String> getImgPath();
    boolean use();
    void setTargets( List<T> targets);
    Skill.TargetType getTargetType();
}
