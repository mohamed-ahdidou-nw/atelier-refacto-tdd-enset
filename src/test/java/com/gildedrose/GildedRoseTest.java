package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testSellDatePassed() {
        Item[] items = new Item[] { new Item("item1", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void testQualityNegativeValue() {
        Item[] items = new Item[] { new Item("item2", 5, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.items[0].quality < 0);
    }

    @Test
    void testAgedBrieIncreaseTheOlderItGets() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.items[0].quality > 5);
    }



}
