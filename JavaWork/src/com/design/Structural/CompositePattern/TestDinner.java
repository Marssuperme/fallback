package com.design.Structural.CompositePattern;

public class TestDinner {

    public static void main(String[] args) {

        Dinner dinner = new Food("今日推荐");

        Dinner food = new Food("主食");
        Dinner drink = new Food("饮品");

        Dinner rices = new Rices("扬州炒饭");
        Dinner noodles = new Noodles("蛋炒面");

        Dinner soup = new Soup("羊肉汤");
        Dinner juice = new Juice("杨枝甘露");

        food.add(rices);
        food.add(noodles);

        drink.add(soup);
        drink.add(juice);

        dinner.add(food);
        dinner.add(drink);

        System.out.println(dinner.getName());

    }
}
