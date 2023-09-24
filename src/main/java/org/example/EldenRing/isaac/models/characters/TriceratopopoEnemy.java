package org.example.EldenRing.isaac.models.characters;

import org.example.EldenRing.isaac.factory.TriceratopopoFightingBehaviour;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;

public class TriceratopopoEnemy extends Soldato {
    public TriceratopopoEnemy(String name, int maxHealth, int currentHealth) {
        super(name, maxHealth, currentHealth, new TriceratopopoFightingBehaviour());
    }

    public TriceratopopoEnemy(String name, int maxHealth, int currentHealth, FightingBehaviour fightingBehaviour) {
        super(name, maxHealth, currentHealth, fightingBehaviour);
    }
}
