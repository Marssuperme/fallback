package com.design.Creational.Builder;

import java.util.ArrayList;
import java.util.List;

public class Dinner {

    private List<String> dinner = new ArrayList<String>();

    public void addDinner(String name){
        dinner.add(name);
    }

    public void showDinner(){

        for (int i = 0; i < dinner.size(); i++) {
            System.out.println(dinner.get(i));
        }
        System.out.println("done.");
    }

}
