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
    void sellByDatePassed(){
        Item[] items = new Item[] { new Item("test1", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void qualityNeverNegative(){
        //Item[] items = new Item[] { new Item("test2", 1, 0) };
        Item[] items = new Item[] { new Item("TEST2", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void AgedBrieIncreasesQualityTheOrderitGets(){
        Item[] items = new Item[] { new Item("Aged Brie",0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].quality);
    }


    @Test
    void qualityOfanItemIsNeverMoreThan50(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void sulfurasLegendary(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",10, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(12,app.items[0].quality);
    }

    @Test
    void backstagePasses(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",10, 12),
            new Item("Backstage passes to a TAFKAL80ETC concert",5, 12)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14,app.items[0].quality);
        assertEquals(15,app.items[1].quality);

    }

}
