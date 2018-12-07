package com.design.Structural.ProxyPattern;

public class Sheldon implements Dinner {

    @Override
    public void getDinner() {
        System.out.println("Sheldon said he would like to eat hamburger.");
    }
}
