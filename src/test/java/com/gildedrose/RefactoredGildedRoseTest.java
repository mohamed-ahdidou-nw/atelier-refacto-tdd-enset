package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefactoredGildedRoseTest {

    // General Tests
    @Test
    void ItemNameReturnTest() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void QualityUpdateAfterSellInPassedTest(){ // sellIn = 0
        Item[] items = new Item[]{ new Item("item", 0,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 3);
    }

    @Test
    void negativeQualityTest(){ // quality can't never be negative
        Item[] items = new Item[]{ new Item("item", 0,-5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        assertTrue(app.items[0].quality < 0);
    }

    @Test
    void positiveQualityTest(){
        Item[] items = new Item[]{ new Item("item", 0,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        assertFalse(app.items[0].quality < 0);
    }

    @Test
    void qualityReturnTest(){
        Item[] items = new Item[]{ new Item("item", 0,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        assertEquals(app.items[0].quality, 5);
    }

    @Test
    void qualityGtMaxTest(){ // Gt : greater than  // max = 50
        Item[] items = new Item[]{new Item("Aged Brie", 3,51)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        assertTrue(app.items[0].quality > 50);
    }

    // Aged Brie tests
    @Test
    void agedBrieQualityUpdateTest(){  //"Aged Brie" actually increases in Quality the older it gets
        Item[] items = new Item[]{new Item("Aged Brie", 3,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 6);
    }

    // sulfuras Tests
    @Test
    void sulfurasQualityUpdateTest(){  // never decreases in Quality
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 3,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 5);
    }

    @Test
    void sulfurasSellInUpdateTest(){ // never has to be sold
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 3,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 3);
    }

    // Concert Test
    @Test
    void concertQualityUpdateIfSellInGtTenTest(){ //Gt : greater than
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 6);
    }

    @Test
    void concertQualityUpdateIfSellInLtTenTest(){ // Quality increases by 2 when there are 10 days or less
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 7);
    }

    @Test
    void concertSellInLtFiveQualityUpdateTest(){ //Quality increases by 3 when there are 5 days or less
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 8);
    }

    @Test
    void afterConcertQualityUpdateTest(){ // sellIn = 0  // Quality drops to 0 after the concert
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0,5)};
        RefactoredGildedRose app = new RefactoredGildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
    }

}
