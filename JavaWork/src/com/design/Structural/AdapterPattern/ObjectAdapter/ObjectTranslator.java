package com.design.Structural.AdapterPattern.ObjectAdapter;

public class ObjectTranslator implements Fruit {

    private Juice juice = new Juice();

    public ObjectTranslator(Juice juice) {
        this.juice = juice;
    }

    @Override
    public void fruitName(String name) {
        juice.makeJuice(name);
    }
}
