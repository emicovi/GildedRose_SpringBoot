package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GildedRose {
    protected Item[] items;

    @Autowired
    protected GildedItemFactory itemFactory;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            itemFactory.getInventoryItem(item).dailyUpdate();
        }
    }

}
