package com.design.Creational.FactoryMethod.abstractClassShow;

public class DinnerRices extends Dinner {
    @Override
    public Food eatWhat() {
        return new FoodRices();
    }
}
