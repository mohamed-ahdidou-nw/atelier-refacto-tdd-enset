package com.gildedrose.item;

public class BackstagePasses extends AgedBrie{
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(this.sellIn <= 1)
            this.setQuality(0);
        else if (this.sellIn <= 5)
            this.setQuality(this.getQuality() + 3);
        else if(this.sellIn <= 10)
            this.setQuality(this.getQuality() + 2);
        else {
            super.updateQuality();
            return;
        }
        this.sellIn--;
    }
}
