package com.design.Behavioral.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class TestMenu {
    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("醉鸭"));
        foods.add(new Food("姜葱鸡"));
        foods.add(new Food("豆豉鸭"));
        foods.add(new Food("剁椒鱼头"));

        OrderList orderList = new OrderList(foods);
        Iterator iterator = orderList.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.getCurrentFood());
            iterator.next();
        }
    }
}
