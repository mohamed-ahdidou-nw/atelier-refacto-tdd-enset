package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FerstTest {
@Test
 public void Test_Qualite_Negative(){
        Item[] items = new Item[] { new Item("abc", 0, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality<0,true);
    }
    @Test
    public void Test_Qualite_decrement(){
        Item[] items = new Item[] { new Item("abc", 0, 150) };
        int a=items[0].quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(a,app.items[0].quality+2);
    }
    @Test
    public  void All_items_have_a_SellIn_value(){
        Item[] items = new Item[] { new Item("abc", 0, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0;i<app.items.length;i++)
            assertNotNull(app.items[i].sellIn);
    }
    @Test
    public  void All_items_have_a_Quality(){
        Item[] items = new Item[] { new Item("abc", 0, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0;i<app.items.length;i++)
            assertNotNull(app.items[i].quality);
    }
    @Test
    void sulfurasSellInUpdateTest(){ // never has to be sold
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 3,5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 3);
    }


}
