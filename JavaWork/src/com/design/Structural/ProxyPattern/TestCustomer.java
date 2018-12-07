package com.design.Structural.ProxyPattern;

public class TestCustomer {

    public static void main(String[] args) {

        Dinner dinner = new DeliverProxy();
        dinner.getDinner();
    }

}
