package com.gildedrose;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            // check if the Quality is not less than 0 or higher than 50
            // I've noticed that the old code checks for quality:
            //  - is higher than 0 => 2 times
            //  - is less than 50 => 4 times

            if (item.quality < 50 && item.quality > 0) {
                this._updateQuality(item);
            }
        }
    }

    private void _updateQuality(Item item){

        switch (item.name){
            case ItemType.AGED_BRIE:
                if(item.sellIn < 1) item.quality = Math.min(50 , item.quality + 2);
                else item.quality = Math.min(50 , item.quality + 1);
                item.sellIn = item.sellIn - 1;
                break;
            case ItemType.BACKSTAGE_PASSES_TO_CONCERT:
                if (item.sellIn < 11) item.quality += 1;
                else item.quality += 1;
                item.sellIn = item.sellIn - 1;
                break;
            default:
                System.out.println("HERE");
                if(item.sellIn == 0) item.quality = Math.max(0,item.quality -2);
                else item.quality = Math.max(0,item.quality -1);
                item.sellIn = item.sellIn - 1;
        }

        /*
        // check if the category is Backstage passes to a TAFKAL80ETC concert
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            if (item.sellIn < 11) item.quality += 1;
            if (item.sellIn < 6) item.quality += 1;
        }

        if (!item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            //if (item.quality > 0) { // check if the Quality higher than 0 (1 time)
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
           // }
        } else {
           // if (item.quality < 50) { // check if quality is less than 50 (1 time)
                item.quality = item.quality + 1;

                /*
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        //if (item.quality < 50) { // check if quality is less than 50 (2 time)
                            item.quality = item.quality + 1;
                       // }
                    }

                    if (item.sellIn < 6) {
                        //if (item.quality < 50) { // check if quality is less than 50 (3 time)
                            item.quality = item.quality + 1;
                       // }
                    }
                }
           // }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // if (item.quality > 0) { // check if the Quality is higher than 0 (2 time)
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    // }
                } else {
                    // item.quality = item.quality - item.quality;
                    item.quality = 0;
                }
            } else {
                // if (item.quality < 50) { // check if quality is higher than 50 (4 time)
                    item.quality = item.quality + 1;
                //}
            }
        }
        */
    }
}
