package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory category = categorize(item);
            category.updateOneItem(item);
        }
    }
    private ItemCategory categorize(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Legendary();
        }
        if (item.name.equals("Aged Brie")) {
            return new Cheese();
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePass();
        }
        if (item.name.startsWith("Conjured"))
            return new Conjured();
        return new ItemCategory();
    }
    private class ItemCategory {
        protected void incrementQuality(Item item) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        protected void decrementQuality(Item item) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
        protected void updateExpired(Item item) {
            decrementQuality(item);
        }
        protected void updateSellIn(Item item) {
            item.sellIn = item.sellIn - 1;
        }
        protected void updateQuality(Item item) {
            decrementQuality(item);
        }
        private void updateOneItem(Item item) {
            updateQuality(item);
            updateSellIn(item);
            if (item.sellIn < 0) {
                updateExpired(item);
            }
        }
    }
    private class Legendary extends ItemCategory {
        protected void updateExpired(Item item) {}
        protected void updateSellIn(Item item) {}
        protected void updateQuality(Item item) {}
    }
    private class Cheese extends ItemCategory {
        protected void updateExpired(Item item) {
            incrementQuality(item);
        }
        protected void updateQuality(Item item) {
            incrementQuality(item);
        }
    }
    private class BackstagePass extends ItemCategory {
        protected void updateExpired(Item item) {
            item.quality = 0;
        }
        protected void updateQuality(Item item) {
            incrementQuality(item);
            if (item.sellIn <= 10) {
                incrementQuality(item);
            }
            if (item.sellIn <= 5) {
                incrementQuality(item);
            }
        }
    }
    private class Conjured extends ItemCategory {
        protected void updateExpired(Item item) {
            decrementQuality(item);
            decrementQuality(item);
        }
        protected void updateQuality(Item item) {
            decrementQuality(item);
            decrementQuality(item);
        }
    }
}
