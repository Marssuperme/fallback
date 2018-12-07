package com.design.Creational.AbstractFactory;

public class FoodFactory extends Dinner {

    @Override
    public Food getFood(String name) {
        if (name == null) {
            return null;
        }

        if ("Noodles".equalsIgnoreCase(name)) {
            return new FoodNoodles();
        }

        if ("Rices".equalsIgnoreCase(name)) {
            return new FoodRices();
        }
        return null;
    }

    @Override
    public Drink getDrink(String name) {
        return null;
    }
}
