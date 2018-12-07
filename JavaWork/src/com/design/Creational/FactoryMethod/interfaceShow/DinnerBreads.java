package com.design.Creational.FactoryMethod.interfaceShow;

public class DinnerBreads implements Dinner{
    @Override
    public Food eatWhat() {
        return new FoodBreads();
    }
}
