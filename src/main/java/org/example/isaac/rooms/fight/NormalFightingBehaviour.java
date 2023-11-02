package org.example.isaac.rooms.fight;

public class NormalFightingBehaviour implements FightingBehaviour {


    @Override
    public void fight(int piano) {
        System.out.println("ci sono nemici");
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        // Poiché NoFightingBehaviour non ha attributi specifici da confrontare,
        // puoi considerarli uguali se sono dello stesso tipo.
        return true;
    }
}
