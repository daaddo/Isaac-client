package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.rooms.Buy.BuyBehaviour;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.other.RoomCoordinates;
import org.example.EldenRing.isaac.models.characters.Character;

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
    public void fight(Character enemy){

    }
}
