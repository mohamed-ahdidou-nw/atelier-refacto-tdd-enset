package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTestV2 {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    /**
     * assert that the quality decrease by 1 and sellIn by 1 when name is not
     * "Aged Brie"
     * "Backstage passes to a TAFKAL80ETC concert"
     * "Sulfuras, Hand of Ragnaros"
     * **/
    @Test
    void testQualityRandomName(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    /**
     * assert that the quality decrease by 1 and sellIn by 1
     * and the sellIn is negative
     * when name is not
     * "Aged Brie"
     * "Backstage passes to a TAFKAL80ETC concert"
     * "Sulfuras, Hand of Ragnaros"
     * **/
    @Test
    void testQualityRandomNameAndSellInPassed(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    /**
     * Test if quality will increase by 2 when name
     * "Aged Brie"
     * and SellIn is passed
     * **/
    @Test
    void testQualityWhenNameAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 4) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    /**
     * Test if quality will increase by 2 when name
     * "Aged Brie"
     * and SellIn is still on
     * **/
    @Test
    void testQualityWhenNameAgedBrie2(){
        Item[] items = new Item[] { new Item("Aged Brie", 6, 4) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    /**
     * Test name Backstage passes when sellIn under 6
     * **/
    @Test
    void testQualityWhenNameBackstage(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    /**
     * Test name Backstage passes when sellIn under over 11
     * **/
    @Test
    void testQualityWhenNameBackstage2(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);
    }

    /**
     * Test name Backstage passes when sellIn under under 11
     * but Quality is over 50
     * **/
    @Test
    void testQualityWhenNameBackstage3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 56) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(56, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    /**
     * Test name Backstage passes when sellIn under 0
     * **/
    @Test
    void testQualityWhenNameBackstage4(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 15) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


}
