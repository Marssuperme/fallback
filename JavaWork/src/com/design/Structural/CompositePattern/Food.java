package com.design.Structural.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Food extends Dinner{

    private String name;

    public Food(String name) {
        this.name = name;
    }

    private List<Dinner> dinners = new ArrayList<>();

    @Override
    public void add(Dinner dinner) {
        dinners.add(dinner);
    }

    @Override
    public Dinner get(int index) {
        return dinners.get(index);
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder("\n【" + name + "】： \n");
        for (Dinner dinner : dinners) {
            sb.append(dinner.getName()).append("\n");
        }
        return sb.toString();
    }
}
