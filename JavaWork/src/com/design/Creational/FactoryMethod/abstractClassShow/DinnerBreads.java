package com.design.Creational.FactoryMethod.abstractClassShow;

public class DinnerBreads extends Dinner {
    @Override
    public Food eatWhat() {
        return new FoodBreads();
    }
}
