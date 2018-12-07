package com.design.Structural.FacadePattern;

public class TestDinner {

    public static void main(String[] args) {

        Dinner dinner = new Dinner();
        dinner.getRestaurantDinner();

        System.out.println();

        dinner.getKfcDinner();

    }

}
