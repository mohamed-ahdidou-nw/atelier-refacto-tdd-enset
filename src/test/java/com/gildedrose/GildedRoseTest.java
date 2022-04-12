package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void givenQualitieInContructorIsTheSameinResultAfterInstantiating(){
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        assertEquals(10, app.items[0].quality);
    }


    @Test
    void TheQualityOfAnItemIsNeverNegative(){
        int quality=-10;
        Item[] items = new Item[] { new Item("foo", 2, quality) };
        GildedRose app = new GildedRose(items);
        assertEquals(quality>0 , true);
    }

    @Test
    void firstConditionTest(){
        int quality=10;
        Item[] items = new Item[] { new Item("item1", 0, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality-1 , app.items[0].quality);
    }

    @Test
    void AgedBrieIncreaseWithTime(){
        int quality = 12;
        Item[] items = new Item[]{new Item("Aged Brie", 4, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality< items[0].quality, true);
    }

}
