package com.design.Behavioral.ObserverPattern.javaClass.two;

public class Test {
    public static void main(String[] args) {
        AccountObservable accountObservable = new AccountObservable();
        CodeObserver codeObserver = new CodeObserver();

        accountObservable.addObserver(codeObserver);
        accountObservable.update("aaaaaa");

        accountObservable.deleteObserver(codeObserver);
    }
}
