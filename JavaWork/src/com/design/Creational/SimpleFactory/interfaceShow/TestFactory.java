package com.design.Creational.SimpleFactory.interfaceShow;

public class TestFactory {

    public static void main(String[] args) {

        Food food = null;

        food = DinnerFactory.getDinner("rices");

        food.eat();

        food = DinnerFactory.getDinner("noodles");

        food.eat();

    }


}
