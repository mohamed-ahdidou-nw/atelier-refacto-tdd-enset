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
    void Once_the_sell_by_date_has_passed_Quality_degrades_twice_as_fast(){
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10-2, app.items[0].quality);
    }

    @Test
    void The_Quality_of_an_item_is_never_negative(){
        Item[] items = new Item[] { new Item("foo", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void Aged_Brie_actually_increases_in_Quality_the_older_it_gets(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void The_Quality_of_an_item_is_never_more_than_50(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void Sulfuras_being_a_legendary_item_never_has_to_be_sold(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }
    @Test
    void Sulfuras_being_a_legendary_item_never_has_to_be_decreases_in_Quality(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void Backstage_passes_actually_increases_in_Quality_the_older_it_gets(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }
    @Test
    void Backstage_passes_actually_increases_in_Quality_when_there_are_10_days_or_less(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }
    @Test
    void Backstage_passes_actually_increases_in_Quality_when_there_are_5_days_or_less(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }
}
