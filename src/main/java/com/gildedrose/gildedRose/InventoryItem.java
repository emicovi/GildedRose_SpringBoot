package com.gildedrose.gildedRose;


public abstract class InventoryItem {


    public abstract boolean accept(Item item);

    public void dailyUpdate(Item item) {
        updateQuality(item);
        updateExpiration(item);
        if (isExpired(item)) {
            processExpired(item);
        }
    }

    protected void updateExpiration(Item item) {
        item.sellIn--;
    }

    protected void updateQuality(Item item) {
            decreaseQuality(item);

    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    protected void processExpired(Item item) {
        decreaseQuality(item);
    }


    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public String getName(Item item) {
        return item.name;

    }
}
