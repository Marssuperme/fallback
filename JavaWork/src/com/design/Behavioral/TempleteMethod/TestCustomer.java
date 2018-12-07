package com.design.Behavioral.TempleteMethod;

public class TestCustomer {

    public static void main(String[] args) {

        System.out.println("1号桌：");
        RicesDinner rices = new RicesDinner();
        rices.getDinner();

        System.out.println("2号桌：");
        NoodlesDinner noodles = new NoodlesDinner();
        noodles.getDinner();

    }

}
