package com.design.Creational.AbstractFactory;

public class TestDinner {

    public static void main(String[] args) {

        Dinner dinner = null;

        dinner = DinnerFactory.getAbstractFactory("Food");
        Food rices = dinner.getFood("rices");
        rices.eat();

        dinner = DinnerFactory.getAbstractFactory("Drink");
        Drink soup = dinner.getDrink("Soup");
        soup.drink();
    }

}
