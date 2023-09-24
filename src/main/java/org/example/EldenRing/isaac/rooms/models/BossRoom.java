package org.example.EldenRing.isaac.rooms.models;

import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.items.Item;
import org.example.EldenRing.isaac.rooms.Buy.NoBuyBehaviour;
import org.example.EldenRing.isaac.manager.PersonManager;
import org.example.EldenRing.isaac.rooms.fight.FightingBehaviour;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.EldenRing.other.RoomCoordinates;

import java.util.List;

public class BossRoom extends Room{
    private FightingBehaviour FightingBehaviour;
    private NoBuyBehaviour noBuyBehaviour;
    private org.example.EldenRing.isaac.models.bosses.Boss Boss;

    public BossRoom(RoomCoordinates coords) {
        super(coords);
        this.Boss = PersonManager.getInstance().getRandomBoss();
        this.FightingBehaviour = new NormalFightingBehaviour();
        this.noBuyBehaviour = new NoBuyBehaviour();
    }



    @Override
    public List<Item> getItems() {
        return null;
    }


}
