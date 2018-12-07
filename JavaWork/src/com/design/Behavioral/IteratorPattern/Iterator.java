package com.design.Behavioral.IteratorPattern;

public interface Iterator {
    boolean hasNext();
    Food next();
    Food getCurrentFood();
}
