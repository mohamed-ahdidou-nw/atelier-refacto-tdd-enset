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
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if(!items[i].name.equals("Sulfuras, Hand of Ragnaros") && items[i].quality > 0){
                    items[i].quality = items[i].quality - 1;
                }

            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && items[i].sellIn < 11) {
                        ifNot50Increse(items[i]);
                        if (items[i].sellIn < 6) {
                            ifNot50Increse(items[i]);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0 ) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros"))  {
                                items[i].quality = items[i].quality - 1;
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
