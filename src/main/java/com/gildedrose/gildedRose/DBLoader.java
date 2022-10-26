package com.gildedrose.gildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBLoader {

    @Autowired
    private ItemRepository itemRepository;

    public void loadItems() {
        itemRepository.save(new Item("Aged Brie", 2, 0));
        itemRepository.save(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemRepository.save(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        itemRepository.save(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        itemRepository.save(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        itemRepository.save(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        itemRepository.save(new Item("Conjured Mana Cake", 3, 6));
    }

}
