package com.gildedrose.gildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFactory implements GildedItemFactory {

    @Autowired
    private List<InventoryItem> itemList;



    @Override
    public InventoryItem getInventoryItem(Item item) {
        for (InventoryItem inventoryItem : itemList) {
            if (inventoryItem.accept(item)) {
                return inventoryItem;
            }
        }
        return new StandardItem();
    }
}
