package com.design.Structural.AdapterPattern.ObjectAdapter;

public class TestTranslator {

    public static void main(String[] args) {
        Fruit fruit = new ObjectTranslator(new Juice());
        fruit.fruitName("apple");
    }

}
