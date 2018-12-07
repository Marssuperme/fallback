package com.design.Structural.DecoratorPattern;

public class Beef extends DinnerDecorator {

    private Rices rices;

    public Beef(Rices rices) {
        this.rices = rices;
    }

    @Override
    public void addFood() {
        System.out.print("beef ");
    }

    @Override
    public void getDinner() {
        rices.getDinner();
    }
}
