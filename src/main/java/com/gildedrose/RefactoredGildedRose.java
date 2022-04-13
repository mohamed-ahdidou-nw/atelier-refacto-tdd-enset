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
                    switch(item.name){
                        case "Aged Brie":
                            item.quality += 1;
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert" :
                            if (item.sellIn > 10)
                                item.quality += 1;
                            else if (item.sellIn > 5)
                                item.quality += 2;
                            else if (item.sellIn > 0)
                                item.quality += 3;
                            break;
                        case "Sulfuras, Hand of Ragnaros" :
                            break; // "Sulfuras", being a legendary item,never has to be sold or decreases in Quality
                        default:
                            item.quality -= 1;
                    }
                }

                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))  //if item.sellIn = 0 & item is "Backstage passes"
                    item.quality = 0;
                else
                    item.quality = item.quality>=2?item.quality-2:0;
            }
        }
    }


}
