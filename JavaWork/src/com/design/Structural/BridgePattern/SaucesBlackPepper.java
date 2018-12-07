package com.design.Structural.BridgePattern;

public class SaucesBlackPepper extends Sauces {
    public SaucesBlackPepper(Rices rices) {
        super(rices);
    }

    @Override
    public void getSauces() {
        rices.getRices();
        System.out.print(" + 黑椒汁");
    }
}
