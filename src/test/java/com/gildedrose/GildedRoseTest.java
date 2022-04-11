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
    void onceTheSellByDatePassedQualityDegreesTwiceAsFast_v1(){
        Item[] items= new Item[] { new Item("kugj", 0, 20) };
        GildedRose app = new GildedRose(items);

        boolean b=true;

        for (int i = 0; i < 50; i++) {
            if(items[0].sellIn<0){
                int previousQuality=items[0].quality;
                app.updateQuality();
                b = b && (items[0].quality - previousQuality)==2;
            }
        }

        assertEquals(true, b);
    }
    @Test
    void onceTheSellByDatePassedQualityDegreesTwiceAsFast_v2(){
        Item[] items= new Item[] { new Item("kugj", 0, 20) };
        GildedRose app = new GildedRose(items);

        boolean b=true;

        for (int i = 0; i < 50; i++) {
            if(items[0].sellIn<0){
                int previousQuality=items[0].quality;
                int previousSellIn=items[0].sellIn;
                app.updateQuality();
                b = b && (items[0].quality - previousQuality)==(items[0].sellIn-previousSellIn);
            }
        }

        assertEquals(true, b);
    }
    @Test
    void qualityNeverGoesAbove50(){
        Item[] items= new Item[] { new Item("foo", 10, 20) };
        int sellInBeforeOP=10,qualityBeforeOP=20;
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertEquals(true,app.items[0].quality<50);
    }
    @Test
    void qualityIsNeverNegative(){
        Item[] items= new Item[] { new Item("foo", 10, 20) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertEquals(true,app.items[0].quality>=0);
    }
    @Test
    void agedBrieIncreasesInQualityTheOlderItGets(){
        Item[] items= new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int quality1=app.items[0].quality;
        app.updateQuality();
        int quality2=app.items[0].quality;
        app.updateQuality();
        int quality3=app.items[0].quality;
        assertEquals(true,0 < quality1 && quality1 < quality2 && quality2 < quality3);
    }
    @Test
    void sulfurasNeverHasToBeSoldOrDecreasesInQuality(){
        Item[] items= new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                                    new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertEquals(true, app.items[0].quality == 80
                                        && app.items[1].quality == 80
                                        && app.items[0].sellIn<=0
                                        && app.items[1].sellIn<=0);
    }
    @Test
    void backstage_passesIncreasesInQualityAsItsSellInValueApproaches_v1(){
        Item[] items= new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };

        boolean b=signle_backstage_passes_test(new Item[]{items[0]})
                &&signle_backstage_passes_test(new Item[]{items[1]})
                &&signle_backstage_passes_test(new Item[]{items[2]});

        assertEquals(true,b);
    }
    boolean signle_backstage_passes_test(Item[] items){
        GildedRose app = new GildedRose(items);

        boolean b=true;

        int maxI=items[0].sellIn;

        for (int i = 0; i < maxI+10; i++) {
            int previousQuatity=app.items[0].quality;
            app.updateQuality();
            if(app.items[0].sellIn>0){
                b=b && previousQuatity <= app.items[0].quality;
            }
        }
        return b;
    }
    @Test
    void backstage_passesIncreasesInQualityAsItsSellInValueApproaches_v2(){
        Item[] items= new Item[] {  new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);

        boolean b=true;

        int maxI= Math.max(items[0].sellIn,items[1].sellIn);
        maxI=Math.max(maxI,items[2].sellIn);
        /**
         *  I can make directly
         *  int maxI=15;//or 100
         *  I did it like that just to be precise
         * */

        for (int i = 0; i < maxI; i++) {
            int previousQuatity_item0=app.items[0].quality;
            int previousQuatity_item1=app.items[1].quality;
            int previousQuatity_item2=app.items[2].quality;
            app.updateQuality();
            if(app.items[0].sellIn>0) {
                b = b && previousQuatity_item0 <= app.items[0].quality;
            }
            if (app.items[1].sellIn>0) {
                b = b && previousQuatity_item1 <= app.items[1].quality;
            }
            if (app.items[2].sellIn>0){
                b = b && previousQuatity_item2 <= app.items[2].quality;
            }
        }
        assertEquals(true,b);

    }

/*
    @Test
    void qualityIncreasesBy2WhenTheSellInIsBetween10AND6(){}
    @Test
    void qualityIncreasesBy3WhenTheSellInIsBetween5AND1(){}
    @Test
    void qualityDropsTo0WhenTheSellInIsBelow0(){}
*/
}

/*
 * test unitaire
 * mook service : mookito
 * */
