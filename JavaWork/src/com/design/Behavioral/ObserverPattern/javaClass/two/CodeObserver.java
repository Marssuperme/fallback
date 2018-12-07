package com.design.Behavioral.ObserverPattern.javaClass.two;

import java.util.Observable;
import java.util.Observer;

public class CodeObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("tips: " + arg);
    }
}
