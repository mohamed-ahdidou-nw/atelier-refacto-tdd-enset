package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

   // @Test
    void foo() {
        Item[] items = new Item[] { 
        		new Item("foo", 50, 9) 
        		};
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    //The quality of an item is never negative
    //@Test
    void NegativeQualite() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0) };
        GildedRoseV2 app = new GildedRoseV2(items);
        assertEquals(0,app.items[0].quality);
    }
    
  //The quality of an item is never more than 50
    //@Test
    void QualityNeverMoreThanFifteen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }
    
    //@Test
    void QualityOfSulfurasDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 6) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(6,app.items[0].quality);
    }
    
    //@Test
    void QualityIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(24,app.items[0].quality);
    }
    //@Test
    void QualityDropToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 22) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }
    @Test
    void NewItem() {
        Item[] items = new Item[] { new Item("Conjured", 0, 22) };
        GildedRoseV2 app = new GildedRoseV2(items);
        app.updateQuality();
        assertEquals(20,app.items[0].quality);
    }
   
    
    
    
}
