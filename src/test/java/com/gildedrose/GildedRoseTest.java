package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

   // @Test
    void foo() {
        Item[] items = new Item[] { 
        		new Item("foo", 50, 9) 
        		};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
   // @Test
    void testerQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -2, 9) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // assertEquals(12,app.items[0].quality);  new Item("Backstage passes to a TAFKAL80ETC concert", 5, 9)  success
        //assertEquals(11,app.items[0].quality); new Item("Backstage passes to a TAFKAL80ETC concert", 10, 9) success
        //assertEquals(10,app.items[0].quality); new Item("Backstage passes to a TAFKAL80ETC concert", 40, 9) success 
    } 
    //The quality of an item is never negative
    //@Test
    void NegativeQualite() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0) };
        GildedRose app = new GildedRose(items);
        assertEquals(0,app.items[0].quality);
    }
    
  //The quality of an item is never more than 50
   // @Test
    void QualityNeverMoreThanFifteen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }
    
    //@Test
    void QualityOfSulfurasDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6,app.items[0].quality);
    }
    
    //@Test
    void QualityIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(24,app.items[0].quality);
    }
    //@Test
    void QualityDropToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 22) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }
   // @Test
    void NewItem() {
        Item[] items = new Item[] { new Item("Conjured", 0, 22) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20,app.items[0].quality);
    }
    
    
    
}
