package com.gildedrose.GildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemFactory implements GildedItemFactory {


    @Override
    public InventoryItem getInventoryItem(Item item) {
            if (item.name.equals(AgedBrie.NAME)) {
                return new AgedBrie(item);
            } else if (item.name.equals(BackstagePasses.NAME)) {
                return new BackstagePasses(item);
            } else if (item.name.equals(Sulfuras.NAME)) {
                return new Sulfuras(item);
            } else if (item.name.equals(Conjured.NAME)) {
                return new Conjured(item);
            } else {
                return new StandardItem(item);
            }
        }

}
