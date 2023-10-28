package org.example.EldenRing.isaac.models.characters.allymodels;

import org.example.EldenRing.isaac.models.characters.type.MainCharacter;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;

import java.util.List;

public class SuperAgilityMainCharacterTest extends MainCharacter {
    private List<Skill> skills;
    public SuperAgilityMainCharacterTest(String name, List<Skill> interactions) {
        super(name, interactions,7,"/images/isaac.png");
        this.skills = interactions;
    }


}
