package com.design.Creational.Builder;

public class Waiter {

    public void callCooker(DinnerBuilder builder){

        builder.addMeats();
        builder.addVegetables();
        builder.addDrinks();

    }

}
