package org.example.EldenRing.isaac.models.bosses;

import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;



public class Godrick extends Boss{


    public Godrick(Piano piano) {
        super("Godrick", 100, 100, new FightingBehaviour() {
            @Override
            public void fight(int piano) {

            }
        });
    }


    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getAvatarPath() {
        return null;
    }
}
