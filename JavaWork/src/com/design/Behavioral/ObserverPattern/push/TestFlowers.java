package com.design.Behavioral.ObserverPattern.push;

public class TestFlowers {

    public static void main(String[] args) {

        Plant flowers = new Flowers();

        Insect bee1 = new Bee(1);
        Insect bee2 = new Bee(2);
        Insect bee3 = new Bee(3);

        flowers.addInsect(bee1);
        flowers.addInsect(bee2);
        flowers.addInsect(bee3);

        flowers.notifyInsect(true);

        System.out.println("------------------");

        flowers.notifyInsect(false);

        flowers.removeInsect(bee1);
        flowers.removeInsect(bee2);
        flowers.removeInsect(bee3);

    }

}
