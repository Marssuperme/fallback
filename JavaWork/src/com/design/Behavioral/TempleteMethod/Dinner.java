package com.design.Behavioral.TempleteMethod;

public abstract class Dinner {

    public abstract void orderFood();   // 下单
    public abstract void callCooker();  // 通知后厨
    public abstract void makeDinner();  // 做菜

    // 晚餐准备固定模板，一般为final修饰
    public final void getDinner(){

        orderFood();
        callCooker();
        makeDinner();
        served();
    }

    // 上菜
    void served(){
        System.out.println("晚餐已准备好.");
        System.out.println();
    };


}
