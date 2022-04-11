package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {


    //    check if quality is changed in creation
    @Test
    void check_if_quality_isnt_changed_in_creation() {
        Item[] items = new Item[]{new Item("foo", 0, 5)};
        GildedRose app = new GildedRose(items);
        assertEquals(5, app.items[0].quality);
    }

    //    - The Quality of an item is never negative
    @Test
    void check_if_quality_is_never_negative() {
        Item[] items = new Item[]{new Item("test", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 0);
    }

    //    - The Quality of an item is never more than 50
    @Test
    void check_if_quality_is_never_more_than_50() {
        Item[] items = new Item[]{new Item("test", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality <= 50);
    }

    //"Aged Brie" actually increases in Quality the older it gets
    @Test
    void check_if_quality_of_aged_brie_increases_the_older_it_gets() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 49);
    }

    //    Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void check_if_once_sellbydate_has_passed_Quality_degrades_twice_as_fast() {
        Item[] items = new Item[]{new Item("test", -1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
    }


}
