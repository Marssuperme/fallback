package com.design.Structural.FlyweightPattern;

public class DinnerSteamRices extends Dinner{
    public DinnerSteamRices() {
        super();
    }

    @Override
    public void getDinner(String meat) {
        System.out.println(meat + "蒸饭");
    }
}
