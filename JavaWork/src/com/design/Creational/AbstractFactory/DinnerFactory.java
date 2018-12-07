package com.design.Creational.AbstractFactory;

public class DinnerFactory {

    public static Dinner getAbstractFactory(String factory){
        if (factory == null) {
            return null;
        }

        if ("Drink".equalsIgnoreCase(factory)) {
            return new DrinkFactory();
        }

        if ("Food".equalsIgnoreCase(factory)) {
            return new FoodFactory();
        }

        return null;
    }

}
