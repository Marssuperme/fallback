package com.design.Creational.Builder;

public class Cooker implements DinnerBuilder{

    Dinner dinner = new Dinner();

    @Override
    public void addMeats() {
        dinner.addDinner("beaf");
    }

    @Override
    public void addVegetables() {
        dinner.addDinner("green bean");
    }

    @Override
    public void addDrinks() {
        dinner.addDinner("soup");
    }

    @Override
    public Dinner getDinner() {
        return dinner;
    }
}
