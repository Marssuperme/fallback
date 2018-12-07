package com.design.Structural.BridgePattern;

public class RicesWithBeef extends Rices{

    RicesWithBeef(Dinner dinner) {
        super(dinner);
    }

    @Override
    public void getRices() {
        dinner.getDinner();
        System.out.print("牛肉盖浇饭");
    }
}
