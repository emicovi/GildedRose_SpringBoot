package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class AgedBrie extends InventoryItem {
    public static final String NAME = "Aged Brie";

    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

    @Override
    protected void updateQuality(Item item) {
        increaseQuality(item);
    }

    @Override
    protected void processExpired(Item item) {
        increaseQuality(item);
    }
}
