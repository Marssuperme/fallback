package com.design.Behavioral.ObserverPattern.javaClass.one;

import java.util.Observer;

/**
 * Test对象首先创建了Watched和Watcher对象。
 * 在创建Watcher对象时，将Watched对象作为参数传入；
 * 然后Test对象调用Watched对象的setData()方法，触发Watched对象的内部状态变化；
 * Watched对象进而通知实现登记过的Watcher对象，也就是调用它的update()方法。
 */
public class TestObserver {

    public static void main(String[] args) {

        Watched watched = new Watched();
        Observer watcher = new Watcher(watched);
        watched.setData("changed");
        watched.setData("back");
    }

}
