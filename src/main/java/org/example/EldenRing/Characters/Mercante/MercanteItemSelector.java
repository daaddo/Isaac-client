package org.example.EldenRing.Characters.Mercante;


import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;
import org.example.EldenRing.other.ItemSelector;
import org.example.EldenRing.other.Weapon;

import java.util.List;

public class MercanteItemSelector implements ItemSelector {
    @Override
    public List<Item> getItems() {
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.MERCANTE);
    }

    @Override
    public List<Weapon> getWeapons() {
        return null;
    }

    @Override
    public Item getRandomItem() {
        return null;
    }


}
