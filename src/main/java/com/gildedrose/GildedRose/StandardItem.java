package com.gildedrose.GildedRose;

import org.springframework.stereotype.Component;

@Component
public class StandardItem extends InventoryItem {
    protected StandardItem(Item item) {
        super(item);
    }
}
