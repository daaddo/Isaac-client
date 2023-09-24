package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.rooms.Buy.BuyBehaviour;
import org.example.EldenRing.other.RoomCoordinates;
import org.example.EldenRing.isaac.models.characters.Character;

//TODO cambiare da behaviour in strategy, aggiungere una caratteristica Found
public abstract class Room implements BuyBehaviour {

    protected RoomCoordinates coords;
    public RoomCoordinates getCoords() {
        return coords;
    }

    public Room(RoomCoordinates coords) {
        this.coords = coords;

    }
}
