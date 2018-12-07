package com.design.Behavioral.ObserverPattern.push;

import java.util.ArrayList;
import java.util.List;

public class Flowers extends Plant {
    private static List<Insect> insects = new ArrayList<>();
    @Override
    void addInsect(Insect insect) {
        insects.add(insect);
    }

    @Override
    void removeInsect(Insect insect) {
        insects.remove(insect);
    }

    @Override
    void notifyInsect(Boolean isOpen) {
        if (isOpen){
            System.out.println("花开");
            for (Insect insect : insects) {
                insect.doWork();
            }
        } else {
            System.out.println("花闭");
            for (Insect insect : insects) {
                insect.unWork();
            }
        }
    }
}
