package com.gildedrose;

public class Context {
    IUpdate updateAlgorithm;
    Item item;

    public Context(Item item, IUpdate updateAlgorithm){
        this.item = item;
        this.updateAlgorithm = updateAlgorithm;
    }
}
