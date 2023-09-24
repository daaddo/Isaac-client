package org.example.EldenRing.Characters.Guerriero;


import org.example.EldenRing.other.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GuerrieroItemSelector implements ItemSelector, StatsSelector {
    @Override
    public List<Item> getItems(){
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO);
    }
    @Override
    public List<Weapon> getWeapons(){
        List<Weapon> allWeapons = new ArrayList<>();
        allWeapons.add(ItemManager.getInstance().getAllWeapons().get(0));
        allWeapons.add(ItemManager.getInstance().getAllWeapons().get(1));
        return allWeapons;
    }
    public int getAgility(){
        return 6;
    }
    public int getHealth(){
        return 30;
    }
}
