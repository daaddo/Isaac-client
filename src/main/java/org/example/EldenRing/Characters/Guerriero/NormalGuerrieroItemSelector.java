package org.example.EldenRing.Characters.Guerriero;


import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;

import java.util.List;

public class NormalGuerrieroItemSelector extends GuerrieroItemSelector {
    @Override
    public Item getRandomItem() {
        return null;
    }
    public List<Item> getNormalSamuraiItems(){
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.GUERRIERO);
    }

    @Override
    public int getHealth() {
        return 34;
    }

    @Override
    public int getAgility() {
        return 5;
    }

}
