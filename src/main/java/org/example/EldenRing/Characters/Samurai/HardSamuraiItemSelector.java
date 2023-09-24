package org.example.EldenRing.Characters.Samurai;



import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;

import java.util.List;

public class HardSamuraiItemSelector extends SamuraiItemSelector {

    @Override
    public Item getRandomItem() {
        return null;
    }
    public List<Item> getHardSamuraiItems(){
        List<Item> items = ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI);
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI).get(1));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI).get(3));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI).get(5));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI).get(4));
        return items;
    }

    @Override
    public int getHealth() {
        return 22;
    }

    @Override
    public int getAgility() {
        return 6;
    }
}
