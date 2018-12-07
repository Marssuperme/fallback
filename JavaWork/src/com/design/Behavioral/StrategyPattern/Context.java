package com.design.Behavioral.StrategyPattern;

public class Context {

    private Compute compute;

    public Context(Compute compute) {
        this.compute = compute;
    }

    public void callMath(int num1, int num2){
        compute.doMath(num1, num2);
    }
}
