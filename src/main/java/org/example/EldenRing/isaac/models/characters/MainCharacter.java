package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;

import java.util.Collections;
import java.util.List;

public class MainCharacter extends Character implements Fightable {
    private List<Skill> skills;
    public MainCharacter(String name, List<Skill> interactions, int agilty,String avatarPath) {
        super(name, 30, 30, new NormalFightingBehaviour(), agilty,avatarPath);
        this.skills = interactions;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getAvatarPath() {
        return this.avatarPath;
    }

    @Override
    public int getAgility(){
        return this.agility;
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }
}
