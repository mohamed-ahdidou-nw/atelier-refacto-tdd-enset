package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 7, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    //	- Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void onceTheSellDateHasPassedQualityDecreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    //	- The Quality of an item is never negative
    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 7, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //	- "Aged Brie" actually increases in Quality the older it gets
    @Test
    void agedBrieIncreasesInQualityAsItAges() {
        Item[] items = new Item[] { new Item("Aged Brie", 7, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue( app.items[0].quality > 5);
    }

    //	- The Quality of an item is never more than 50
    @Test
    void qualityOfAnItemIsNeverAboveFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 7, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    //	- "Sulfuras", being a legendary item, never has to decrease in Quality
    @Test
    void sulfurasNeverDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 7, 99) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(99, app.items[0].quality);
    }

    //	- "Sulfuras", being a legendary item, never has to be sold
    @Test
    void sulfurasIsNeverSold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 99) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    //	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    @Test
    void agedBrieIncreasesInQualityAsItsSellInValueApproches() {
        Item[] items = new Item[] { new Item("Aged Brie", 77, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue( app.items[0].quality > 5);
    }

    //	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //  - Quality increases by 2 when there are 10 days or less
    @Test
    void agedBrieIncreasesInQualityByTwoWhenThereAreTenDaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    //	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //  - Quality increases by 3 when there are 5 days or less
    @Test
    void agedBrieIncreasesInQualityByThreeWhenThereAreTenDaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    //	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //  - Quality drops to 0 after the concert
    @Test
    void agedBrieDropsToZeroInQualityAfterTheConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 0, app.items[0].quality);
    }
}
