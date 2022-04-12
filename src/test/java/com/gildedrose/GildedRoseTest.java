package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void sellbydatehaspassedQualitydegradestwiceasfast() {
        Item[] items = new Item[] { new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);
        int q1=app.items[app.items.length-1].quality;
        app.modifiedUpdateQuality();
        assertEquals(2,
            app.items[app.items.length-1].quality);
    }
    @Test
    void qualityofanitemisnevernegative() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        boolean isNegative=false;
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(true, app.items[0].quality>=0);
    }


    @Test
    void agedBrieactuallyincreasesinQualitytheolderitgets() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void Qualityofanitemisnevermorethan50() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(true, app.items[0].quality<50);
    }
    @Test
    void SulfurasneverhastobesoldordecreasesinQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(10, app.items[0].quality);
    }
    @Test
    void BackstagepassesincreasesinQualityincreasesby2whenthereare10days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void BackstagepassesincreasesinQualityincreasesby2whenthereare5days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.modifiedUpdateQuality();
        assertEquals(13, app.items[0].quality);
    }
}
