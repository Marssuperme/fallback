package com.design.Structural.FlyweightPattern.simple;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

    private Map<UserBean, FlyWeight> maps = new HashMap<>();

    public FlyWeight getFlyWeight(UserBean userBean){

        FlyWeight flyWeight = maps.get(userBean);

        if (flyWeight == null) {
            flyWeight = new ConcreteFlyWeight(userBean);
            maps.put(userBean, flyWeight);
        }

        return flyWeight;
    }

}
