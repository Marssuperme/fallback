package com.design.Structural.BridgePattern;

public abstract class Drink {
    Rices rices;

    public Drink(Rices rices) {
        this.rices = rices;
    }

    public abstract void getDrink();
}
