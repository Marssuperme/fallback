package com.design.Structural.AdapterPattern.ClassAdapter;

public class ClassTranslator extends Juice implements Fruit {

    @Override
    public void fruitName(String name) {

        makeJuice(name);

    }
}
