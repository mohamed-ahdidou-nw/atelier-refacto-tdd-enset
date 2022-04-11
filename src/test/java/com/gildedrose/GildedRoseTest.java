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
    void testQualityIfNegative(){
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3)
        };
        int oldQuality = items[0].quality;
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        if(gildedRose.items[0].sellIn < 6) {
            assertEquals(oldQuality + 2  ,gildedRose.items[0].quality);
        }
        if(gildedRose.items[0].sellIn < 11) {
            assertEquals(oldQuality + 1  ,gildedRose.items[0].quality);
        }

    }

    @Test
    void OnceTheSellByDateHasPassedQualityDegradesTwiceAsFast(){
        Item[] items = new Item[]{
            new Item("Any Other Catogory", 0, 100)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(100, gildedRose.items[0].quality);
    }

    @Test
    void AgedBrieActuallyIncreasesInQualityTheOlderItGets(){
        Item[] items = new Item[]{
            new Item("Aged Brie", 10, 10)
        };
        int expected_value = items[0].quality;
        if (items[0].sellIn <= 0){
            expected_value += 2;
        } else expected_value += 1;
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(expected_value, gildedRose.items[0].quality);
    }


}
