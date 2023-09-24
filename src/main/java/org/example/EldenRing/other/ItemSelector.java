package org.example.EldenRing.other;

import java.util.List;

public interface ItemSelector {
    List<Item> getItems();
    List<Weapon> getWeapons();
    Item getRandomItem();
}
