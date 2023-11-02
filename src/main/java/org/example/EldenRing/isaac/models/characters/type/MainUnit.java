package org.example.EldenRing.isaac.models.characters.type;

import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;

import java.util.Collections;
import java.util.List;

public class MainUnit extends Unit implements Fightable {
    private List<Skill> skills;
    public MainUnit(String name, List<Skill> interactions, int agilty, String avatarPath) {
        super(name, 30, 30, new NormalFightingBehaviour(), agilty,avatarPath);
        this.skills = interactions;
    }

    @Override
    public int getValue() {
        return 0;
    }


    @Override
    public int getAgility(){
        return this.agility;
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}
