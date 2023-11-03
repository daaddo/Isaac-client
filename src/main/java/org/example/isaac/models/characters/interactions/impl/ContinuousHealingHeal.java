package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.HealInteraction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContinuousHealingHeal<T extends Unit>  implements HealInteraction<T> {

    private int turnsLeft;
    private Skill.TargetType targetType;
    private int amount;
    private String imgPath = "/images/icon1NoBg.png";
    List<T> allies = new ArrayList<>();

    public ContinuousHealingHeal(int turnsLeft, int amount, Skill.TargetType targetType, T ... allies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.allies.addAll(List.of(allies));
        this.targetType = targetType;
    }

    public void setAllies(List<T> allies) {
        this.allies = allies;
    }

    @Override
    public boolean heal() {
        if (turnsLeft == 0) return false;
        for (Unit ally : allies) {
            ally.setCurrentHealth(ally.getCurrentHealth()+amount);
        }
        if (turnsLeft == 0) return false;
        turnsLeft--;
        return true;
    }


    @Override
    public Optional<String> getImgPath() {
        return Optional.of(imgPath);
    }

    @Override
    public boolean use() {
        return heal();
    }

    @Override
    public void setTargets(List<T> targets) {
        setAllies(targets);
    }

    @Override
    public Skill.TargetType getTargetType() {
        return targetType;
    }


}
