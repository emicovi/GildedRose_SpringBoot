package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class StandardItem extends InventoryItem {

    @Override
    public boolean accept(Item item) {
        return false;
    }
}
