package com.gildedrose;

public class RefactoredGildedRose {
    public Item[] items;

    public RefactoredGildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.quality > 0 && item.quality < 50) {
                if (item.sellIn != 0) {
                    if (item.name.equals("Aged Brie"))
                        item.quality = item.quality + 1;
                    else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn > 10)
                            item.quality += 1;
                        else if (item.sellIn > 5)
                            item.quality += 2;
                        else if (item.sellIn > 0)
                            item.quality += 3;
                    }

                    else if(!item.name.equals("Sulfuras, Hand of Ragnaros"))
                        item.quality -= 1;

                    // "Sulfuras", being a legendary item,never has to be sold or decreases in Quality
                }
                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    item.quality = 0;
                else
                    item.quality = item.quality>=2?item.quality-2:0;
            }
        }
    }


}
