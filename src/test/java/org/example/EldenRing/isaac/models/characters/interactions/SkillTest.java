package org.example.EldenRing.isaac.models.characters.interactions;

import org.example.EldenRing.isaac.models.characters.interactions.skills.AttackSkillInteraction;
import org.example.EldenRing.isaac.models.characters.interactions.skills.StroncaturaSkillInteraction;
import org.example.EldenRing.isaac.models.characters.interactions.type.AttackInteraction;
import org.example.EldenRing.isaac.models.characters.type.MainCharacter;
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
        MainCharacter mainCharacter = new MainCharacter("Test", List.of(new AttackSkillInteraction(),
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