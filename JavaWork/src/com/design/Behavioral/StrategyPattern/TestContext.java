package com.design.Behavioral.StrategyPattern;

public class TestContext {

    public static void main(String[] args) {

        Context context = null;

        context = new Context(new ComputeAdd());
        context.callMath(10, 10);

        context = new Context(new ComputeMinus());
        context.callMath(10, 10);

        context = new Context(new ComputeMultipy());
        context.callMath(10, 10);

        context = new Context(new ComputeDivide());
        context.callMath(10, 10);

    }

}
