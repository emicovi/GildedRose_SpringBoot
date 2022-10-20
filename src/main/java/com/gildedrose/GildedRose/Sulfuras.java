package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sulfuras extends InventoryItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";


    @Override
    public void decreaseQuality(Item item) {
        return;
    }

    @Override
    public void increaseQuality(Item item) {
        // do nothing
    }

    @Override
    public void updateQuality(Item item) {
        // do nothing
    }

    @Override
    public boolean accept(Item item) {
        return item.name.equals(NAME);
    }

}
