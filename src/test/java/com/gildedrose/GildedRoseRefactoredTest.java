package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseRefactoredTest {

    @Test
    void assertQuality(){
        Item item = new Item( "NewProduct", 0, 50);
        assertEquals( 50, item.quality );
    }


    //Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void sellDatePassedQualityDegradestwice() {
        // given
        Item[] items = new Item[] { new Item("Any", -4, 3) };
            GildedRoseRefactored app = new GildedRoseRefactored(items);
        // when
        app.updateQuality();
        // then
        assertEquals(1, app.items[0].quality);
    }


    //	- The Quality of an item is never negative
    @Test
    void assertQualityNeverNegative(){
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 10, 1), // single item !
        };
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        // when
        app.updateQuality();
        // then
        for( Item item : items){
            assertEquals(true, item.quality>0 );
        }
    }


    //	- "Aged Brie" actually increases in Quality the older it gets
    @Test
    void assertAgedBrieQualityIncrease(){
        // given
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 1)
        };
        // when
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        app.updateQuality();
        // then
        assertEquals(2, app.items[0].quality);

        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }


    //	- The Quality of an item is never more than 50
    @Test
    void assertQualityUnderFifty(){
        // given
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 1),
            // new Item("Aged Brie", 10, 49),  => error : the older it gets the quality increases
            // new Item("Any", 51, 50),
            // new Item("Sulfuras, Hand of Ragnaros", 10, 1),
            // new Item("Backstage passes to a TAFKAL80ETC concert", 1, 2),
            // new Item("Aged Brie", 31, 13)
        };
        // when
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        app.updateQuality();
        // then
        assertEquals(2, app.items[0].quality);

        int rand = (int) Math.random() * 137;

        while( rand-->0 )
            app.updateQuality();

        for( Item item: items )
            assertEquals(true, item.quality<50);
    }



    // - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void assertLegendarySulfuras(){
        // given
        Item[] items = new Item[] { new Item("Sulfuras", 21, 12) };
        GildedRoseRefactored app = new GildedRoseRefactored(items);
        // when
        int rand = (int) Math.random()*177;
        while( rand-->0)
            app.updateQuality();
        // then
        assertEquals(12, app.items[0].quality);
    }


    /*
    	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	        Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    	    Quality drops to 0 after the concert
     */
    @Test
    void BackstagePassesQualityIncreasesAsItLasts(){
        // given
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 12),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 21),
        };
        GildedRoseRefactored app = new GildedRoseRefactored(items);

        // when
        app.updateQuality();

        // then
        assertEquals(14, app.items[0].quality);
        assertEquals(24, app.items[1].quality);


    }





}
