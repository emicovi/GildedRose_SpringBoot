package com.gildedrose.gildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class GildedRose {

    @Autowired
    protected GildedItemFactory itemFactory;


    public void updateInventory(Item[] items) {
        for (Item item : items) {
            itemFactory.getInventoryItem(item).dailyUpdate(item);
        }
    }

}
