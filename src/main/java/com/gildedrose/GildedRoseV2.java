package com.gildedrose;

class GildedRoseV2 {
    Item[] items;

    public GildedRoseV2(Item[] items) {
        this.items = items;
    }
    void ifNot50Increse(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros") && item.quality > 0) {
                    item.quality = item.quality - 1;
                }

            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn < 11) {
                        ifNot50Increse(item);
                        if (item.sellIn < 6) {
                            ifNot50Increse(item);
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.sellIn < 0) if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
