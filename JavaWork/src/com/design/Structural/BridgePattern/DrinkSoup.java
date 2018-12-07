package com.design.Structural.BridgePattern;

public class DrinkSoup extends Drink {
    public DrinkSoup(Rices rices) {
        super(rices);
    }

    @Override
    public void getDrink() {
        rices.getRices();
        System.out.println(" + 鱼头豆腐汤");
    }
}
