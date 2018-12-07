package com.design.Behavioral.ObserverPattern.push;

public class Bee extends Insect {
    private int id;

    public Bee(int id) {
        this.id = id;
    }

    @Override
    public void doWork() {
        System.out.println("蜜蜂" + id + "采蜜");
    }

    @Override
    public void unWork() {
        System.out.println("蜜蜂" + id + "回巢");
    }

}
