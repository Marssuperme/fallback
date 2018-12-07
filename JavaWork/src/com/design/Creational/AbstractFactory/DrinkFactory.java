package com.design.Creational.AbstractFactory;

public class DrinkFactory extends Dinner{

    @Override
    public Food getFood(String name) {
        return null;
    }

    @Override
    public Drink getDrink(String name) {
        if (name == null) {
            return null;
        }

        if ("Soup".equalsIgnoreCase(name)) {
            return new DrinkSoup();
        }

        if ("Juice".equalsIgnoreCase(name)) {
            return new DrinkJuice();
        }

        return null;
    }
}
