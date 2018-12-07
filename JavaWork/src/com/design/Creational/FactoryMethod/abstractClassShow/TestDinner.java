package com.design.Creational.FactoryMethod.abstractClassShow;

public class TestDinner {

    public static void main(String[] args) {

        Dinner dinner = null;

        dinner = new DinnerBreads();
        Food food = dinner.eatWhat();
        food.eat();

        dinner = new DinnerRices();
        dinner.eatWhat().eat();

    }

}
