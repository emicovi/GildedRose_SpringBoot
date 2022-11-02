package com.gildedrose.gildedRose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateItems {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void updateItems() {
        for (Item item : itemRepository.findAll()) {
            itemRepository.save(item);
        }
    }
}
