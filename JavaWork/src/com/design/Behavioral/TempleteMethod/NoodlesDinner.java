package com.design.Behavioral.TempleteMethod;

public class NoodlesDinner extends Dinner{

    @Override
    public void orderFood() {
        System.out.println("猪杂汤面 x 1");
    }

    @Override
    public void callCooker() {
        System.out.println("通知后厨制作1份猪杂汤面");
    }

    @Override
    public void makeDinner() {
        System.out.println("后厨制作1份猪杂汤面中");
    }
}
