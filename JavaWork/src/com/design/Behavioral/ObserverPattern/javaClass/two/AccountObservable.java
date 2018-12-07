package com.design.Behavioral.ObserverPattern.javaClass.two;

import java.util.Observable;

public class AccountObservable extends Observable {
    private String tips;

    public String getTips() {
        return tips;
    }
    public void update(String msg){
        this.tips = msg;
        System.out.println("changed： " + tips);
        setChanged();
        notifyObservers(this.tips); // 推
    }
}
