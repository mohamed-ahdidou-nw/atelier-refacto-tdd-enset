package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items){
            switch(item.name) {
                case "Aged Brie":
                    agedBrieItem(item) ;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    backstagePassesToATarkal80TCConcertItem(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    normalItem(item);
                    break;
            }
        }
        }

    public void increaseQuality(Item item, int nbr) {
        if (item.quality<50){
            item.quality += nbr;
        }
    }

    public void decreaseQuality(Item item, int nbr) {
        if (item.quality > 0){
            item.quality -= nbr;
        }
    }

    private void agedBrieItem(Item item) {
        item.sellIn--;
        increaseQuality(item,1);
        if ( item.quality < 50 && item.sellIn < 0 )
            item.quality++;
    }

    private void backstagePassesToATarkal80TCConcertItem(Item item) {
        increaseQuality(item,1);
        item.sellIn--;
        if (item.quality < 50 && item.sellIn < 11 ) {
            if(item.sellIn<0){
                item.quality = 0 ;
                    return ;
            }
            if (item.sellIn < 6)
                item.quality++;
            item.quality++;
        }
    }

    private  void normalItem(Item item){
        decreaseQuality(item,1);
        item.sellIn--;
        if (item.quality > 0 && item.sellIn < 0 )
            item.quality--;
    }
}
