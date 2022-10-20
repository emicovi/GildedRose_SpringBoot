package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class AgedBrie extends InventoryItem {
    public static final String NAME = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void processExpired() {
        increaseQuality();
    }
}
