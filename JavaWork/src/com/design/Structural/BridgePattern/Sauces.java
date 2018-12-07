package com.design.Structural.BridgePattern;

public abstract class Sauces {

    Rices rices;

    public Sauces(Rices rices) {
        this.rices = rices;
    }

    public abstract void getSauces();
}
