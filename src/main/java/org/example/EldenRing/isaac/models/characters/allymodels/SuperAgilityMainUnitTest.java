package org.example.EldenRing.isaac.models.characters.allymodels;

import org.example.EldenRing.isaac.models.characters.type.MainUnit;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;

import java.util.List;

public class SuperAgilityMainUnitTest extends MainUnit {
    private List<Skill> skills;
    public SuperAgilityMainUnitTest(String name, List<Skill> interactions) {
        super(name, interactions,7,"/images/isaac.png");
        this.skills = interactions;
    }


}
