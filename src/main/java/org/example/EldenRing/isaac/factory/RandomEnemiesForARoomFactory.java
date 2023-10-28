package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.models.characters.*;
import org.example.EldenRing.isaac.models.characters.enemymodels.DennysMinion;
import org.example.EldenRing.isaac.models.characters.enemymodels.GhostMinion;
import org.example.EldenRing.isaac.models.characters.enemymodels.SkeletonMinion;
import org.example.EldenRing.isaac.models.characters.type.Enemy;
import org.example.EldenRing.isaac.models.characters.type.NormalEnemy;
import org.example.EldenRing.isaac.piano.Piano;

import java.util.ArrayList;
import java.util.List;

public class RandomEnemiesForARoomFactory {


    private NormalEnemy normalEnemyRandomGenerator() {
        double random = Math.random();
        if (random < 0.3) {
            return new GhostMinion(Special.getRandomSpecial());
        }
        if (random <0.6) {
            return new DennysMinion(Special.getRandomSpecial());
        } else {
            return new SkeletonMinion(Special.getRandomSpecial());
        }
    }

    public int calculateTotalDifficultyOfList(List<? extends Enemy> listToControl) {
        int totalDifficulty = 0;
        for (Enemy enemy : listToControl) {
            totalDifficulty += enemy.getDifficultyPoint();
        }
        return totalDifficulty;
    }

    public List<NormalEnemy> normalEnemiesRandomGenerator() {
        int difficultyMultiplyier = (int) ((10 * Math.random() + 5) * Piano.getNumero());
        List<NormalEnemy> enemies = new ArrayList<>();
        while (calculateTotalDifficultyOfList(enemies) < difficultyMultiplyier && enemies.size() < 4) {
            enemies.add(normalEnemyRandomGenerator());
            if (calculateTotalDifficultyOfList(enemies) > difficultyMultiplyier + 2) {
                //TODO refactor in modo da levare il doppio remove,
                // possibile sostituendo il +2 di difficultyMultiplyier con funzione o costante della difficoltà massima di un nemico
                enemies.remove(enemies.size());
                enemies.remove(enemies.size());
            }
        }
        return enemies;
    }
}
