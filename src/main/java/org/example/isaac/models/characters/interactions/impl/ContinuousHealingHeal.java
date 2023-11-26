package org.example.isaac.models.characters.interactions.impl;

import org.example.isaac.TODO;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.type.HealInteraction;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContinuousHealingHeal<T extends Unit>  implements HealInteraction<T> {

    private int turnsLeft;
    private Skill.TargetType targetType;
    private int amount;
    private String imgPath = "/images/icon3NoBg.png";
    @TODO(todo = "refactor in modo che target sia singolo e non una lista")
    List< Unit> allies = new ArrayList<>();

    public ContinuousHealingHeal(int turnsLeft, int amount, Skill.TargetType targetType, Unit ... allies) {
        this.turnsLeft = turnsLeft;
        this.amount = amount;
        this.allies.addAll(List.of(allies));
        this.targetType = targetType;
    }

    public void setAllies(List<Unit> allies) {
        this.allies = allies;
    }

    @Override
    public boolean heal() {
        if (turnsLeft == 0) return false;
        for (Unit ally : allies) {
            ally.setCurrentHealth(ally.getCurrentHealth()+amount);
        }
        turnsLeft--;
        return turnsLeft != 0;
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
    public void setTargets(List< Unit> targets) {
        setAllies(targets);
    }
    @Override
    public Interaction clone() throws CloneNotSupportedException {
        ContinuousHealingHeal clonedObj =  (ContinuousHealingHeal) super.clone();
        clonedObj.turnsLeft = (this.turnsLeft);
        clonedObj.targetType =(this.targetType);
        clonedObj.amount = (this.amount);
        clonedObj.imgPath = (this.imgPath);
        return clonedObj;
    }
    @Override
    public List<Unit> getTargets() {
        return allies;
    }

    @Override
    public Skill.TargetType getTargetType() {
        return targetType;
    }


}
