package com.design.Structural.DecoratorPattern;

public class TestDinner {

    public static void main(String[] args) {

        Rices rices = new Rices();
        Beef dinner = new Beef(rices);
        dinner.addFood();
        dinner.getDinner();
    }

}
