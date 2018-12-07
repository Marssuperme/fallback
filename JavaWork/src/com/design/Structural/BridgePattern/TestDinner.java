package com.design.Structural.BridgePattern;

public class TestDinner {

    public static void main(String[] args) {

        Rices ricesWithBeef = new RicesWithBeef(new DinnerFood());
        ricesWithBeef.getRices();

        System.out.println();

        Rices ricesWithPork = new RicesWithPork(new DinnerFood());
        ricesWithPork.getRices();

        System.out.println();

        Sauces dinners = new SaucesBlackPepper(new RicesWithPork(new DinnerFood()));
        dinners.getSauces();

        System.out.println();

        Drink dinner = new DrinkCola(new RicesWithBeef(new DinnerFood()));
        dinner.getDrink();

        Drink dinner1 = new DrinkSoup(new RicesWithPork(new DinnerFood()));
        dinner1.getDrink();
    }
    
}
