package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

   

    @Test
    void sulfuras_should_never_decrease_in_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.items[0].quality == 15 && app.items[0].sellIn == 5);
    }

    @Test
    void aged_brie_should_increase_the_older_it_gets() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 5);
    }

    @Test
    void should_never_have_negative_qualities() {
        Item[] items = new Item[] { new Item("item2", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality == 0);
    }

    @Test
    void should_never_pass_fifteen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality == 50);
    }
    void testAgedBrieShouldIncreaseWithTime(){

        int qualityBefore = 22;
        Item[] items = new Item[]{new Item("Aged Brie", 9, qualityBefore)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // the result quality never have to be changed
        assertEquals(qualityBefore < items[0].quality, true);
    }

    @Test
    void testAnyNegativeQualitiesAfterUpdating(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 9), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 10), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4)
        };

        GildedRose app = new GildedRose(items);
        for (int i =0; i<50; i++){
            app.updateQuality();
        }

        for(Item item: items){
            assertEquals(item.quality > 50, false);
        }
    }

   /* @Test
    void conjured_should_increased_two_times_in_quality(){

        int conjuredQualityBefore = 40;
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 2, 80),
            new Item("Aged Brie", 10, 30)
            //new Item("Conjured", 5, conjuredQualityBefore)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(items[2].quality, conjuredQualityBefore/2);

    } */

}
