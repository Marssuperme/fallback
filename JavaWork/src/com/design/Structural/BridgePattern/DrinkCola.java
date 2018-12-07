package com.design.Structural.BridgePattern;

public class DrinkCola extends Drink {
    public DrinkCola(Rices rices) {
        super(rices);
    }

    @Override
    public void getDrink() {
        rices.getRices();
        System.out.println(" + 可乐");
    }
}
