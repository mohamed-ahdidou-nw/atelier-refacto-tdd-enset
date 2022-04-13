package com.gildedrose;

public class Item {

    public String name;

    public int sellIn; //the number of days to sell the item

    public int quality; //how valuable the item is

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
