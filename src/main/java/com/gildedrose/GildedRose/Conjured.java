package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class Conjured extends InventoryItem {

    public static final String NAME = "Conjured";
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        getItem().quality = Math.max(0, getItem().quality - 2);

    }
}
