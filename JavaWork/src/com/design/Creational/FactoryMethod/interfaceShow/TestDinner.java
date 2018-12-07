package com.design.Creational.FactoryMethod.interfaceShow;

public class TestDinner {

    public static void main(String[] args) {

        Dinner dinner = null;

        dinner = new DinnerNoodles();
        Food food = dinner.eatWhat();
        food.eat();

        dinner = new DinnerBreads();
        dinner.eatWhat().eat();
    }

}
