package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i<items.length; i++) {
            IUpdate iUpdate = null;

            if(items[i].name.equals("Aged Brie"))
                iUpdate = new AngedBrie();

            if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                iUpdate = new BackstagePasses();

            if(items[i].name.equals("Sulfuras, Hand of Ragnaros"))
                iUpdate = new Sulfuras();

            if(iUpdate == null){
                System.out.println("The Item specified is not yet added to our collection ");
            } else {
                Context context = new Context(items[i], iUpdate);
                context.updateAlgorithm.updateQuality(items[i]);
            }
        }
    }
}

