package org.example.EldenRing.Characters.Guerriero;



import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;

import java.util.List;

public class HardGuerrieroItemSelector extends GuerrieroItemSelector{

    public List<Item> getHardSamuraiItems(){
        List<Item> items = ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO);
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO).get(1));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO).get(3));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO).get(5));
        items.remove(ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO).get(4));
        return items;
    }

    @Override
    public Item getRandomItem() {
        return null;
    }

    @Override
    public int getHealth() {
        return 25;
    }

    @Override
    public int getAgility() {
        return 7;
    }
}
