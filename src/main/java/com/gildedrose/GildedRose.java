package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void Comparaison(Item a) {
        if (a.quality > 0 && a.quality < 50) {

            if (a.sellIn != 0) {
                switch (a.name) {
                    case "Aged Brie":
                        a.quality += 1;
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        if (a.sellIn > 10)
                            a.quality += 1;
                        else if (a.sellIn > 5)
                            a.quality += 2;
                        else if (a.sellIn > 0)
                            a.quality += 3;
                        break;
                    case "Sulfuras, Hand of Ragnaros":
                        break; // "Sulfuras", being a legendary item,never decreases in Quality
                    case "Conjured":
                        a.quality -= 2;   // "Conjured" items degrade in Quality twice as fast as normal items
                        break;
                    default:
                        a.quality -= 1;
                }

                if(!a.name.equals("Sulfuras, Hand of Ragnaros"))  // "Sulfuras", being a legendary item,never has to be sold
                    a.sellIn -= 1;

            }

            else if (a.name.equals("Backstage passes to a TAFKAL80ETC concert"))  //if item.sellIn = 0 & item is "Backstage passes"
                a.quality = 0;

            else if(!a.name.equals("Sulfuras, Hand of Ragnaros")){

                if(a.name.equals("Conjured"))
                    a.quality = a.quality >= 4 ? a.quality - 4 : 0; // "Conjured" items degrade in Quality twice as fast as normal items
                else
                    a.quality = a.quality >= 2 ? a.quality - 2 : 0;
            }
        }
    }





    public void updateQuality() {
        for (Item item : items) {
            Comparaison(item);
        }
    }
}
