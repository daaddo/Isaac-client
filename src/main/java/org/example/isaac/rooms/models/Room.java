package org.example.isaac.rooms.models;

import org.example.isaac.rooms.Buy.BuyBehaviour;
import org.example.isaac.rooms.fight.FightingBehaviour;
import org.example.isaac.RoomCoordinates;

//TODO cambiare da behaviour in strategy, aggiungere una caratteristica Found
public abstract class Room implements BuyBehaviour, FightingBehaviour {

    protected RoomCoordinates coords;
    private FightingBehaviour fightingBehaviour;


    public Room(RoomCoordinates coords, FightingBehaviour fightingBehaviour) {
        this.coords = coords;
        this.fightingBehaviour = fightingBehaviour;

    }
    public RoomCoordinates getCoords() {
        return coords;
    }




    public FightingBehaviour getFightingBehaviour() {
        return fightingBehaviour;
    }

    @Override
    public void fight(int piano){

    }
}
