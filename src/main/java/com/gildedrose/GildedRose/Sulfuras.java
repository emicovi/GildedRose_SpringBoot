package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sulfuras extends InventoryItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";


    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

    @Override
    public void updateQuality(Item item) {
        // do nothing
    }
    @Override
    public void increaseQuality(Item item) {
        // do nothing
    }
    @Override
    public void updateExpiration(Item item) {
        // do nothing
    }
    @Override
    public void decreaseQuality(Item item) {
        // do nothing
    }
}
