package org.example.EldenRing.isaac.rooms.Buy;

import org.example.EldenRing.isaac.models.items.Item;

import java.util.List;

public class NoBuyBehaviour implements BuyBehaviour{
    @Override
    public List<Item> getItems() {
        return null;
    }

    public NoBuyBehaviour() {
    }
}
