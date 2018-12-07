package com.design.Structural.FlyweightPattern;

public class TestDinner {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Dinner dinner = null;

            switch ((int)(Math.random()*3)){

                case 0 : dinner = DinnerFactory.getDinners("fried");break;
                case 1 : dinner = DinnerFactory.getDinners("steam");break;
                case 2 : dinner = DinnerFactory.getDinners("soup");break;

            }

            if (dinner != null) {

                switch ((int)(Math.random()*3)){

                    case 0 : dinner.getDinner("排骨");break;
                    case 1 : dinner.getDinner("羊肉");break;
                    case 2 : dinner.getDinner("牛肉");break;

                }

            }

        }

    }

}
