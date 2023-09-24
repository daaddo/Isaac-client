package org.example.EldenRing.Characters.Samurai;


import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;

import java.util.List;

public class NormalSamuraiItemSelector extends SamuraiItemSelector {

    @Override
    public Item getRandomItem() {
        return null;
    }
    public List<Item> getNormalSamuraiItems(){
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.SAMURAI);
    }

    @Override
    public int getHealth() {
        return 29;
    }

    @Override
    public int getAgility() {
        return 4;
    }
}
