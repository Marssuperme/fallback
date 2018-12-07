package com.design.Structural.FacadePattern;

public class Dinner {

    private FriedRices friedRices = null;
    private Soup soup = null;
    private Chicken chicken = null;
    private Cola cola = null;

    public Dinner() {
        this.friedRices = new FriedRices();
        this.soup = new Soup();
        this.chicken = new Chicken();
        this.cola = new Cola();
    }

    public void getRestaurantDinner(){
        friedRices.getRices();
        soup.getSoup();
    }

    public void getKfcDinner() {
        chicken.getChicken();
        cola.getCola();
    }
}
