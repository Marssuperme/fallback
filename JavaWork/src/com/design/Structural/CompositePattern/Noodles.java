package com.design.Structural.CompositePattern;

public class Noodles extends Dinner {

    private String name;

    Noodles(String name){
        this.name = name;
    }

    @Override
    public void add(Dinner dinner) {

    }

    @Override
    public Dinner get(int index) {
        return null;
    }

    @Override
    public String getName() {
        return "【面】： " + name ;
    }
}
