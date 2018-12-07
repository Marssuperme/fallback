package com.design.Structural.ProxyPattern;

public class DeliverProxy implements Dinner {

    @Override
    public void getDinner() {

        Sheldon sheldon = new Sheldon();
        sheldon.getDinner();

        // 代理完成提示
        this.goBuyFood();

    }

    private void goBuyFood(){

        System.out.println("Proxy done.");

    }



}
