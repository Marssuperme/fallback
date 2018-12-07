package com.design.Structural.FlyweightPattern.simple;

public class TestFactory {

    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        FlyWeight flyWeight = flyWeightFactory.getFlyWeight(new UserBean("a"));
        flyWeight.operation("");

        FlyWeightFactory flyWeightFactory1 = new FlyWeightFactory();
        FlyWeight flyWeight1 = flyWeightFactory1.getFlyWeight(new UserBean("a"));
        flyWeight1.operation("w");

        FlyWeightFactory flyWeightFactory2 = new FlyWeightFactory();
        FlyWeight flyWeight2 = flyWeightFactory2.getFlyWeight(new UserBean("ab"));
        flyWeight2.operation("e");
    }

}
