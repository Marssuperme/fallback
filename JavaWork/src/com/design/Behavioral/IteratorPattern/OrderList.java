package com.design.Behavioral.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class OrderList implements Menu {
    private List<Food> lists = new ArrayList<>();

    public OrderList(List<Food> lists) {
        this.lists = lists;
    }

    @Override
    public Iterator getIterator() {
        return new MenuListIterator();
    }

    private class MenuListIterator implements Iterator{

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < lists.size() ? true : false;
        }

        @Override
        public Food getCurrentFood() {
            return lists.get(cursor);
        }

        @Override
        public Food next() {
            Food food = null;
            cursor++;
            if (hasNext()){
                food = lists.get(cursor);
            }
            return food;
        }
    }

}
