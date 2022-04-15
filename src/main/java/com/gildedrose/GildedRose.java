package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            switch (item.name){
                case "Backstage passes to a TAFKAL80ETC concert":
                    backstagePasses(item);
                    break;
                case "Aged Brie":
                    agedBrie(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    normalItem(item);
            }
        }
    }

    private void agedBrie(Item item) {
        if (item.sellIn <= 0) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
        item.sellIn--;
    }

    private void backstagePasses(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn <= 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
        item.sellIn--;
    }

    private void normalItem(Item item) {
        if (item.sellIn <= 0) {
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item, 1);
        }
        item.sellIn--;
    }

    public void increaseQuality(Item item, int amount) {
        if (item.quality<50){
            item.quality += amount;
        }
    }

    public void decreaseQuality(Item item, int amount) {
        if (item.quality > 0){
            item.quality -= amount;
        }
    }

}
