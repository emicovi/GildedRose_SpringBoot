package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GildedRose {

    @Autowired
    protected ItemFactory itemFactory;

    public void updateInventory(Item[] items) {
        for (Item item : items) {
            itemFactory.getInventoryItem(item).dailyUpdate(item);
        }
    }

}
