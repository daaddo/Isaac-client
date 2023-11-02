package org.example.isaac.rooms.models;

import org.example.isaac.models.items.Item;
import org.example.isaac.rooms.Buy.NoBuyBehaviour;
import org.example.isaac.manager.PersonManager;
import org.example.isaac.rooms.fight.FightingBehaviour;
import org.example.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.isaac.RoomCoordinates;

import java.util.List;

public class BossRoom extends Room{
    private FightingBehaviour FightingBehaviour;
    private NoBuyBehaviour noBuyBehaviour;
    private org.example.isaac.models.bosses.Boss Boss;

    public BossRoom(RoomCoordinates coords) {
        super(coords, new NormalFightingBehaviour());
        this.Boss = PersonManager.getInstance().getRandomBoss();
        this.FightingBehaviour = new NormalFightingBehaviour();
        this.noBuyBehaviour = new NoBuyBehaviour();
    }



    @Override
    public List<Item> getItems() {
        return null;
    }


}
