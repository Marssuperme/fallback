package com.design.Structural.DecoratorPattern;

public class Chicken extends DinnerDecorator {

    private Rices rices;

    public Chicken(Rices rices) {
        this.rices = rices;
    }

    @Override
    public void addFood() {
        System.out.print("chicken ");
    }

    @Override
    public void getDinner() {
        rices.getDinner();
    }
}
