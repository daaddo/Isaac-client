package org.example.EldenRing.Characters.Samurai;


import org.example.EldenRing.other.*;

import java.util.ArrayList;
import java.util.List;

public abstract class SamuraiItemSelector implements ItemSelector, StatsSelector {
    @Override
    public List<Item> getItems(){
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI);
    }
    public List<Weapon> getWeapons(){
            List<Weapon> allWeapons = new ArrayList<>();
            allWeapons.add(ItemManager.getInstance().getAllWeapons().get(0));
            return allWeapons;
    }
    public int getAgility(){
        return 6;
    }
    public int getHealth(){
        return 30;
    }
}
