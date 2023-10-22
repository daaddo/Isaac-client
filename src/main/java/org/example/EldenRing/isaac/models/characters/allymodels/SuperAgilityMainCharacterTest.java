package org.example.EldenRing.isaac.models.characters.allymodels;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;
import org.example.EldenRing.isaac.models.characters.MainCharacter;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;
import org.example.EldenRing.isaac.models.characters.interactions.impl.ContinuousHealingBuff;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;

import java.util.List;

public class SuperAgilityMainCharacterTest extends MainCharacter {
    private List<Skill> skills;
    public SuperAgilityMainCharacterTest(String name, List<Skill> interactions) {
        super(name, interactions,30,"/images/isaac.png");
        this.skills = interactions;
    }


}
