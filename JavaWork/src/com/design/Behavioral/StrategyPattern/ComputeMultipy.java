package com.design.Behavioral.StrategyPattern;

public class ComputeMultipy extends Compute {
    @Override
    public void doMath(int num1, int num2) {
        System.out.println("乘法：" + num1 + " * " + num2 + " = " + (num1 * num2));
    }
}
