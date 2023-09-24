package org.example.EldenRing.Characters.Npc;



import org.example.EldenRing.other.Item;
import org.example.EldenRing.other.ItemManager;
import org.example.EldenRing.other.ItemSelector;
import org.example.EldenRing.other.Weapon;

import java.util.List;

public class NpcItemSelector implements ItemSelector {
    @Override
    public List<Item> getItems() {
        return ItemManager.getInstance().getAllItems(ItemManager.ItemSelector.NPC);

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
