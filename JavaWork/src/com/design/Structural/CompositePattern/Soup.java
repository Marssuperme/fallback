package com.design.Structural.CompositePattern;

public class Soup extends Dinner {

    private String name;

    Soup(String name){
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
        return "【汤】： " + name ;
    }
}
