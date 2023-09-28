package org.example.EldenRing.isaac.factory;

import org.example.EldenRing.isaac.models.characters.*;
import org.example.EldenRing.isaac.piano.Piano;

import java.util.ArrayList;
import java.util.List;

public class RandomEnemiesForARoomFactory {
    public List<NormalEnemy> normalEnemiesGenerator(){
        int difficultyMultiplyier = (int) ((10*Math.random()+5)* Piano.getNumero());
        int actualDifficulty= 0;
        List<NormalEnemy> enemies = new ArrayList<>();
        while(actualDifficulty < difficultyMultiplyier && enemies.size()<4){
            double random = Math.random();
            if (random<0.5) {
                enemies.add(new GhostMinion(Special.getRandomSpecial()));
                System.out.println("[DEBUG] ho aggiunto un GHOST");
            }if (random>0.5) {
                enemies.add(new SkeletonMinion(Special.getRandomSpecial()));
                System.out.println("[DEBUG] ho aggiunto uno SKELETON");
            }
            actualDifficulty= 0;
            for (NormalEnemy enemy : enemies) {
                actualDifficulty+=enemy.getDifficultyPoint();
                if (actualDifficulty>difficultyMultiplyier-2 && actualDifficulty<difficultyMultiplyier+2) {
                    break;
                }
                if (actualDifficulty>difficultyMultiplyier+2) {
                    while(actualDifficulty>difficultyMultiplyier+2){
                        enemies.remove(enemies.size());
                    }
                }
            }

        }
        System.out.println(actualDifficulty+" "+difficultyMultiplyier);
        return enemies;
    }
}
