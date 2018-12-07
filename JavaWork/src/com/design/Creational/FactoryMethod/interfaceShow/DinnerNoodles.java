package com.design.Creational.FactoryMethod.interfaceShow;

public class DinnerNoodles implements Dinner {
    @Override
    public Food eatWhat() {
        return new FoodNoodles();
    }
}
