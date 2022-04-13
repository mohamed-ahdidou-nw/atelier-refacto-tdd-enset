package com.gildedrose.item;

public class Item implements IItem {

    protected String name;
    protected int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.setQuality(quality);
    }

    @Override
    public void updateQuality() {
        // the quality should never be more than 50, we do nothing if it is already 50
        if(this.quality == 50) return;

        int newQuality = this.quality - 1;

        // when sell in date passed we degrades quality twice
        boolean isSellDatePassed = this.sellIn < 0;
        if(isSellDatePassed)
            newQuality--;

        // an item quality should never be less than 0, we replace it to 0 if it's the case
        boolean isNegativeQuality = newQuality < 0;
        if(isNegativeQuality) newQuality = 0;

        this.setQuality(newQuality);
        this.sellIn--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        if(quality < 0) throw new RuntimeException("Quality can't be negative");
        if(quality > 50) throw new RuntimeException("Quality can't be more than 50");
        this.quality = quality;
    }
}
