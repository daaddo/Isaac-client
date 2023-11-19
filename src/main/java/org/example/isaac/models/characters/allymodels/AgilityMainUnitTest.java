package org.example.isaac.models.characters.allymodels;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.type.MainUnit;

import java.util.List;

public class AgilityMainUnitTest extends MainUnit {
    private List<Skill> skills;
    public AgilityMainUnitTest(String name, List<Skill> interactions) {
        super(name, interactions,2,"/images/isaac.png");
        this.skills = interactions;
    }
}
