package com.design.Creational.SimpleFactory.interfaceShow;

public class DinnerFactory {

    public static Food getDinner(String name) {

        if (name == null){ return null; }

        if (name.equalsIgnoreCase("noodles")) {

            return new Noodles();

        }else if (name.equalsIgnoreCase("rices")) {

            return new Rices();

        }

        return null;

    }
}
