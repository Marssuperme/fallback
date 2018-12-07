package com.design.Structural.CompositePattern;

public abstract class Dinner {

    public abstract void add(Dinner dinner);
    public abstract Dinner get(int index);
    public abstract String getName();

}
