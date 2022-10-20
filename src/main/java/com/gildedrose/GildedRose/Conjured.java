package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class Conjured extends InventoryItem {

    public static final String NAME = "Conjured";

    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

    @Override
    protected void decreaseQuality(Item item) {
        item.quality = Math.max(0, item.quality - 2);

    }
}
