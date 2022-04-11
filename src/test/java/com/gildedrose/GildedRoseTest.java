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
    void NormalQualite(){
        Item[] items = new Item[] { new Item("", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);

    }
    @Test
    void testNegativeQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 9) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality>=0,true);
    }
    @Test
    void testQualityNeverMoreThanFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality>=50,false);
    }

    @Test
    void sellinPastBackstage(){
        //Backstage avec un sellin past Quality drops to 0 after the concert
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void sellinPastAgeBrieQuality(){
        // Once the sell by date has passed, Quality degrades twice as fast
        Item[] items = new Item[] { new Item("", -2, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality==38,true);
    }

    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void sulfurasTestLegendary(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -2, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality==40,true);
    }









}
