package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GildedRose {
    @Autowired
    protected Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            ItemFactory.getInventoryItem(item).dailyUpdate();
        }
    }


}
