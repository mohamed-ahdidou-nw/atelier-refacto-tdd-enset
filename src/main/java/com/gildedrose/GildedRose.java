package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
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



    private void myUpdateitem1(Item it) {
        if (it.quality < 50) {
            it.quality ++;
        }
        if (it.sellIn < 11 && it.quality<50){
            it.quality ++;
            if (it.sellIn < 6) it.quality ++;
        }
        it.sellIn --;
        if(it.sellIn<0){
            it.quality = 0;
        }
    }
    private void myUpdateitem2(Item it) {
        if (it.quality < 50) {
            it.quality ++;
        }
        it.sellIn --;
        if ((it.sellIn < 0)&&(it.quality < 50)) {
            it.quality ++;
        }
    }
    private void myUpdateitem3(Item it) {
        //do nothing following the rule
    }
    private void myUpdateitem4(Item it) {
        if (it.quality > 0) it.quality --;
        it.sellIn --;
        if ( (it.sellIn < 0) && (it.quality > 0) ) it.quality --;
    }

    public void modifiedUpdateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Backstage passes to a TAFKAL80ETC concert" :
                    myUpdateitem1(item);
                case "Aged Brie" :
                    myUpdateitem2(item);
                case "Sulfuras, Hand of Ragnaros" :
                    myUpdateitem3(item);
                default: myUpdateitem4(item);
            }
        }
    }

}
