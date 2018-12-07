package com.design.Structural.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class DinnerFactory {

    static Map<String, Dinner> maps = new HashMap<>();

    static Dinner getDinners(String cookWays){

        Dinner dinner = null;

        if (maps.containsKey(cookWays)) {

            System.out.print("对象复用: " + maps.get(cookWays) + " ： ");
            return maps.get(cookWays);
            
        }else{

            System.out.print("新建对象: ");

            switch (cookWays){

                case "fried" : dinner = new DinnerFriedRices();break;
                case "steam" : dinner = new DinnerSteamRices();break;
                 case "soup" : dinner = new DinnerSoupRices();break;
                     default : dinner = new DinnerFriedRices();break;
            }

            maps.put(cookWays, dinner);
            return dinner;
        }
        
        
    }

}
