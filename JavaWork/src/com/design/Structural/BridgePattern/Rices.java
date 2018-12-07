package com.design.Structural.BridgePattern;

public abstract class Rices {
    Dinner dinner;
    Rices(Dinner dinner){this.dinner = dinner;}
    public abstract void getRices();
}
