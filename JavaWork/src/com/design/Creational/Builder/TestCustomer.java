package com.design.Creational.Builder;

public class TestCustomer {

    public static void main(String[] args) {

        Waiter waiter = new Waiter();

        DinnerBuilder builder = new Cooker();

        waiter.callCooker(builder);

        Dinner dinner = builder.getDinner();

        dinner.showDinner();

    }
}
