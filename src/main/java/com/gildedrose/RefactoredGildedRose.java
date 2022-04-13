package com.gildedrose;

public class RefactoredGildedRose {
    Item[] items;

    public RefactoredGildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.quality > 0 && item.quality < 50) {

                if (item.sellIn != 0) {
                    switch (item.name) {
                        case "Aged Brie":
                            item.quality += 1;
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert":
                            if (item.sellIn > 10)
                                item.quality += 1;
                            else if (item.sellIn > 5)
                                item.quality += 2;
                            else if (item.sellIn > 0)
                                item.quality += 3;
                            break;
                        case "Sulfuras, Hand of Ragnaros":
                            break; // "Sulfuras", being a legendary item,never decreases in Quality
                        case "Conjured":
                            item.quality -= 2;   // "Conjured" items degrade in Quality twice as fast as normal items
                            break;
                        default:
                            item.quality -= 1;
                    }

                    if(!item.name.equals("Sulfuras, Hand of Ragnaros"))  // "Sulfuras", being a legendary item,never has to be sold
                        item.sellIn -= 1;

                }

                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))  //if item.sellIn = 0 & item is "Backstage passes"
                    item.quality = 0;

                else if(!item.name.equals("Sulfuras, Hand of Ragnaros")){

                    if(item.name.equals("Conjured"))
                        item.quality = item.quality >= 4 ? item.quality - 4 : 0; // "Conjured" items degrade in Quality twice as fast as normal items
                    else
                        item.quality = item.quality >= 2 ? item.quality - 2 : 0;
                }
            }
        }
    }


}
