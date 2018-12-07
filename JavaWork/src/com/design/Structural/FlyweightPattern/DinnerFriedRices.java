package com.design.Structural.FlyweightPattern;

public class DinnerFriedRices extends Dinner {
    public DinnerFriedRices() {
        super();
    }

    @Override
    public void getDinner(String meat) {
        System.out.println(meat + "炒饭");
    }
}
