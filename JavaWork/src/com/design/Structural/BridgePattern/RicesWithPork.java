package com.design.Structural.BridgePattern;

public class RicesWithPork extends Rices{
    public RicesWithPork(Dinner dinner) {
        super(dinner);
    }

    @Override
    public void getRices() {
        dinner.getDinner();
        System.out.print("排骨盖浇饭");
    }
}
