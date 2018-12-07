package com.design.Creational.FactoryMethod.abstractClassShow;

public class DinnerNoodles extends Dinner {
    @Override
    public Food eatWhat() {
        return new FoodNoodles();
    }
}
