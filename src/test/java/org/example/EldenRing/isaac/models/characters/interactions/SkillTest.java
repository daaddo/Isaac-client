package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.characters.interactions.skills.AttackSkillInteraction;
import org.example.isaac.models.characters.interactions.skills.StroncaturaSkillInteraction;
import org.example.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.isaac.models.characters.type.MainUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInteractions() {
    }

    @Test
    void getAttackInteractions() {
        MainUnit mainCharacter = new MainUnit("Test", List.of(new AttackSkillInteraction(3,5,3,2,3),
                new StroncaturaSkillInteraction(5,4,5,4)), 20, "asdad");
        List<Skill> skills = mainCharacter.getSkills();
        List<Optional<AttackInteraction>> attackInteractions = skills.get(0).getAttackInteractions();
        assertEquals(2, attackInteractions.size());
    }

    @Test
    void getName() {
    }

    @Test
    void getTarget() {
    }

    @Test
    void skillUsage() {
    }

    @Test
    void activate() {
    }
}