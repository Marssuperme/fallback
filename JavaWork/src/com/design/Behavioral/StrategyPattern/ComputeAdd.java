package com.design.Behavioral.StrategyPattern;

public class ComputeAdd extends Compute {
    @Override
    public void doMath(int num1, int num2) {
        System.out.println("加法：" + num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
