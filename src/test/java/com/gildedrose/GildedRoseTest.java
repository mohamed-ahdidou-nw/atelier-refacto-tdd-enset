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

    // The Quality of an item is never more than 50
   // The Quality of an item is never negative
    @Test
    void Qualityvalue(){
        Item[] items = new Item[] { new Item("foo", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        if(!app.items[0].name.equals("Sulfuras, Hand of Ragnaros")) {
            assertEquals(app.items[0].quality < 50&&app.items[0].quality>0, true);
        }
    }

    @Test
    void qualityDecreasedDateNotPassed(){
        Item[] items = new Item[] { new Item("foo", 3, 59) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(58,app.items[0].quality);

    }
    @Test
    void qualityDecreasedDatePassed(){
        Item[] items = new Item[] { new Item("foo", -2, 59) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(57,app.items[0].quality);

    }
    //"Aged Brie" actually increases in Quality the older it gets
    @Test
    void AgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 30, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21,app.items[0].quality);

    }

    //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    //	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //	Quality drops to 0 after the concert
    @Test
    void Backstagepasses(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",10 , 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        if(app.items[0].sellIn<=10) {
            assertEquals(32, app.items[0].quality);
            app.updateQuality();
            assertEquals(34, app.items[0].quality);
        }
        if(app.items[0].sellIn<=5) {
            assertEquals(33, app.items[0].quality);
        }
        if(app.items[0].sellIn==0) {
            assertEquals(0, app.items[0].quality);
        }
    }

    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void Sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 90)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(90, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }
}
