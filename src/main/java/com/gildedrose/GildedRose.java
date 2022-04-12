package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void modifiedUpdateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Backstage passes to a TAFKAL80ETC concert" :
                    myUpdateitem1(item);
                    break;

                case "Aged Brie" :
                    myUpdateitem2(item);
                    break;
                case "Sulfuras, Hand of Ragnaros" :
                    myUpdateitem3(item);
                    break;

                default: myUpdateitem4(item);
            }
        }
    }
     void myUpdateitem1(Item it) {
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
     void myUpdateitem2(Item it) {
        if (it.quality < 50) {

            it.quality ++;
        }
        it.sellIn --;
        if ((it.sellIn < 0)&&(it.quality < 50)) {
            it.quality ++;
        }

     }
     void myUpdateitem3(Item it) {
         it.sellIn = it.sellIn - 1;

     }
     void myUpdateitem4(Item it) {
        if (it.quality > 0) it.quality --;
        it.sellIn --;
        if ( (it.sellIn < 0) && (it.quality > 0) ) it.quality --;
    }
}
