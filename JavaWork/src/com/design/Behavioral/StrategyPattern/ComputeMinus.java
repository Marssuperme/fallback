package com.design.Behavioral.StrategyPattern;

public class ComputeMinus extends Compute {
    @Override
    public void doMath(int num1, int num2) {
        System.out.println("减法：" + num1 + " - " + num2 + " = " + (num1 - num2));
    }
}
