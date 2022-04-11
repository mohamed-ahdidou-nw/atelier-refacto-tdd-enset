package com.gildedrose;

public class GildedR {
    Item[] items;

    public GildedR(Item[] items) {
        this.items = items;
    }

    public  void updateQuality(){
        for( Item it:items){
           switch (it.name){
               case "Backstage passes to a TAFKAL80ETC concert" :  updateBackstageAndAgeBrie(it);
               case "Aged Brie" : updateBackstageAndAgeBrie(it);
               case "Sulfuras, Hand of Ragnaros" :;

               default: ;
           }
        }
    }
    public void updateBackstageAndAgeBrie(Item it){
        //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        if (it.quality < 50) {  //	Quality drops to 0 after the concert
            if(it.sellIn==0){
                it.quality=0;
            }
            else if (it.sellIn<=5){ //incr  by 3
                it.quality= it.quality+3;
            }
            else if(it.sellIn<=10){ //incr by 2
                it.quality= it.quality+2;
            }else it.quality= it.quality+1; //incr by 1

        }
    }


}

