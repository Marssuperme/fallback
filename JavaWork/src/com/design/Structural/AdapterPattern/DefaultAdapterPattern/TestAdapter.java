package com.design.Structural.AdapterPattern.DefaultAdapterPattern;

public class TestAdapter {

    public static void main(String[] args) {

        Dinner dinner = new ChineseDinnerAdapter(new ChineseDinner());
        dinner.getChineseDinner();
    }
    
}
