package org.example.EldenRing.isaac.manager;

import org.example.EldenRing.isaac.models.bosses.Boss;

public class PersonManager {
    private static PersonManager instance = null;

    private PersonManager() {
    }

    public static PersonManager getInstance() {
        if (instance == null) {
            instance = new PersonManager();
        }
        return instance;
    }
    public Boss getRandomBoss(){
        return DatabaseManager.getInstance().getRandomBoss();
    }
}
