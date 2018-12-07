package com.design.Creational.FactoryMethod.interfaceShow;

public class DinnerRices implements Dinner{
    @Override
    public Food eatWhat() {
        return new FoodRices();
    }
}
