package com.design.Creational.Builder;

public interface DinnerBuilder {

    void addMeats();

    void addVegetables();

    void addDrinks();

    Dinner getDinner();

}
