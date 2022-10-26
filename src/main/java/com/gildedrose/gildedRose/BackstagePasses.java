package com.gildedrose.gildedRose;

import org.springframework.stereotype.Component;

@Component
public class BackstagePasses extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

    @Override
    protected void updateQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    @Override
    protected void processExpired(Item item) {
        item.quality = 0;
    }
}
