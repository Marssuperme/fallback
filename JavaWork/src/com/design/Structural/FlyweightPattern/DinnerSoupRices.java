package com.design.Structural.FlyweightPattern;

public class DinnerSoupRices extends Dinner {
    public DinnerSoupRices() {
        super();
    }

    @Override
    public void getDinner(String meat) {
        System.out.println(meat + "汤饭");
    }
}
