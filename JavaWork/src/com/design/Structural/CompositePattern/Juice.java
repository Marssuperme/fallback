package com.design.Structural.CompositePattern;

public class Juice extends Dinner {

    private String name;

    Juice(String name){
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
        return "【饮品】： " + name;
    }
}
