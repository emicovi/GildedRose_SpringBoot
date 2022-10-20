package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface GildedItemFactory {

    InventoryItem getInventoryItem(Item item);
}
