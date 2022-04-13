package com.gildedrose;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePasses;
import com.gildedrose.item.Item;
import com.gildedrose.item.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    void QualityForPassedSellIn() {
        Item[] items = new Item[] { new Item("non classed item", -1, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].getQuality());
    }

    /**
     *
     */
    @Test
    void QualityForPositiveSellIn () {
        Item[] items = new Item[] { new Item("non classed item", 5, 15) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].getQuality());
    }

    /**
     * The Quality of an item is never negative
     */
    @Test
    void QualityNeverNegative() {
        Item[] items = new Item[] { new Item("non classed item", -5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getQuality());
    }

    /**
     * "Aged Brie" actually increases in Quality the older it gets
     */
    @Test
    void AgeBrieQuality() {
        Item[] items = new Item[] { new AgedBrie("Aged Brie", 5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].getQuality());
    }

    /**
     * The Quality of an item is never more than 50
     */
    @Test
    void QualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].getQuality());
    }

    /**
     * "Sulfuras", being a legendary item, never decreases in Quality
     */
    @Test
    void SulfurasQualityNeverDecreases() {
        Item[] items = new Item[] { new Sulfuras("Sulfuras", 5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].getQuality());
    }

    /**
     * "Sulfuras", being a legendary item, never has to be sold
     */
    @Test
    void SulfurasNeverHasToBeSold() {
        Item[] items = new Item[] { new Sulfuras("Sulfuras", 5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].getSellIn());
    }

    /**
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
     * Quality increases by 2 when there are 10 days or less
     */
    @Test
    void BackstagePassesQualityLessThan10() {
        Item[] items = new Item[] { new BackstagePasses("Backstage passes", 9, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].getQuality());
    }

    /**
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
     * Quality increases by 3 when there are 5 days or less
     */
    @Test
    void BackstagePassesQualityLessThan5() {
        Item[] items = new Item[] { new BackstagePasses("Backstage passes", 2, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15, app.items[0].getQuality());
    }

    /**
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
     * Quality drops to 0 after the concert
     */
    @Test
    void BackstagePassesQualityLessThan0() {
        Item[] items = new Item[] { new BackstagePasses("Backstage passes", -1, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getQuality());
    }
}
