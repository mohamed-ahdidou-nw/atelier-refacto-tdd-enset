package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void testItemQuality() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 10, app.items[0].quality);
    }

    // Test quality is never negative
    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        assertEquals(true,app.items[0].quality>=0);
    }
    // Test quality is never more than 50
    @Test
    void testQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        assertEquals(true,app.items[0].quality<=50);
    }


    // Test sellIn is decremented by 1
    @Test
    void testSellInDecrementedBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 9, app.items[0].sellIn);
    }

    // Test quality is incremented by 1
    @Test
    void testQualityIncrementedBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 11, app.items[0].quality);
    }


    // Test quality is incremented by 2 when sellIn is 10 or less
    @Test
    void testQualityIncrementedBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 12, app.items[0].quality);
    }

    // "Aged Brie" actually increases in Quality the older it gets
    @Test
    void testAgedBrieQualityIncrementedBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 11, app.items[0].quality);
    }

    //Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void testQualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo",  0, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 8, app.items[0].quality);
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void testSulfurasQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 10, app.items[0].quality);
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void testSulfurasSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 10, app.items[0].sellIn);
    }



    // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    // Quality drops to 0 after the concert
    @Test
    void testBackstagePassesQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 12, app.items[0].quality);
    }

    // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    // Quality increases by 2 when there are 10 days or less
    @Test
    void testBackstagePassesQuality2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 13, app.items[0].quality);
    }


    // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    // Quality increases by 3 when there are 5 days or less but
    @Test
    void testBackstagePassesQuality3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 13, app.items[0].quality);
    }

    // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    // Quality drops to 0 after the concert
    @Test
    void testBackstagePassesQuality4() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals( 0, app.items[0].quality);
    }


}

