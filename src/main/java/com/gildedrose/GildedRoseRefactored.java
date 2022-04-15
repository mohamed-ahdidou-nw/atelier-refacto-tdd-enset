package com.gildedrose;

public class GildedRoseRefactored {

    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    void updateQuality(){
        for (int i = 0; i < items.length; i++) {
            if(items[i].name=="Aged Brie"){

                changeQualityAgedBarie(items[i]);

            }else if(items[i].name=="Backstage passes to a TAFKAL80ETC concert"){

                changeQualityBackstage(items[i]);

            }else if(items[i].name=="Conjured"){

                changeQualityConjured(items[i]);

            }else{
                QualityDefault(items[i]);
            }

        }
    }
    void changeQualityAgedBarie(Item item){
        if(item.quality>50)
            item.quality++;
    }
    void changeQualityBackstage(Item item){
        if(item.sellIn>=10 && item.quality<50){
            item.quality++;
        }
        if(item.sellIn<10 && item.sellIn>5 && item.quality<=48){
            item.quality+=2;
        }
        if(item.sellIn<=5 && item.quality<=47){
            item.quality+=3;
        }

    }
    void changeQualityConjured(Item item){
        if(item.quality<=48){
            item.quality+=2;
        }
    }
    void QualityDefault(Item item){
        if(item.quality>=2){
            item.quality-=2;
        }
    }
}
