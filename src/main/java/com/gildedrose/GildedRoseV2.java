package com.gildedrose;

public class GildedRoseV2{
   Item items[];

    public GildedRoseV2(Item items[]) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name){
	            case "Aged Brie" :
	                updateQuality1(item);
                case "Backstage passes to a TAFKAL80ETC concert" :
                    updateQuality2(item);
                case "Sulfuras, Hand of Ragnaros" :
                    updateQuality3(item);
                default: updateQualityDefault(item);
            }
        }
    }
    private void updateQuality1(Item item) {
        if (item.quality < 50) 
        	item.quality++;
        item.sellIn--; //!items[i].name.equals("Sulfuras, Hand of Ragnaros")
        if (item.sellIn < 0 && item.quality < 50)
        	item.quality++;
    }
    private void updateQuality2(Item item) {
        if (item.quality < 50) 
        	item.quality++;
        if (item.sellIn < 11 && item.quality < 50){
        	item.quality++;
            if (item.sellIn < 6)
            	item.quality++;
        }
        item.sellIn--; // because !items[i].name.equals("Sulfuras, Hand of Ragnaros")
        if(item.sellIn < 0)
        	item.quality = 0; // items[i].quality = items[i].quality - items[i].quality;
    }
    private void updateQuality3(Item item) {
    	 if (item.quality < 50)  // the only condition available
    		 item.quality++;
    }
    private void updateQualityDefault(Item item) {
    	//!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")  && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) 
        if (item.quality > 0)
        	item.quality--;
        item.sellIn --; //!items[i].name.equals("Sulfuras, Hand of Ragnaros")
        if (item.sellIn < 0 && item.quality > 0){
        	item.quality--;
        }
    }
}
