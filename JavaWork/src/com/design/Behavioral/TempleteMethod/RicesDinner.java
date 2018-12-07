package com.design.Behavioral.TempleteMethod;

public class RicesDinner extends Dinner {

    @Override
    public void orderFood() {
        System.out.println("扬州炒饭 x 1");
    }

    @Override
    public void callCooker() {
        System.out.println("通知后厨准备1份扬州炒饭");
    }

    @Override
    public void makeDinner() {
        System.out.println("后厨制作1份扬州炒饭中");
    }
}
