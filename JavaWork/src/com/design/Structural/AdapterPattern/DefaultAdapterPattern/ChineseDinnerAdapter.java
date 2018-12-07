package com.design.Structural.AdapterPattern.DefaultAdapterPattern;

public class ChineseDinnerAdapter extends BaseDinnerAdapter{

    private ChineseDinner chineseDinner;

    public ChineseDinnerAdapter(ChineseDinner chineseDinner) {
        this.chineseDinner = chineseDinner;
    }

    @Override
    public void getChineseDinner() {
        chineseDinner.getChineseFood();
    }
}
