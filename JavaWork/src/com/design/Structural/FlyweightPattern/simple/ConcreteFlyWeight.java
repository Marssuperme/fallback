package com.design.Structural.FlyweightPattern.simple;

public class ConcreteFlyWeight extends FlyWeight {

    private UserBean userBean = null;

    // 内部状态传入
    public ConcreteFlyWeight(UserBean userBean) {
        this.userBean = userBean;
    }

    // 外部状态传入，改变方法的行为，不改变对象的内部状态
    @Override
    public void operation(String state) {
        System.out.println("Internal UserBean： " + userBean);
        System.out.println("External state = " + state);
    }
}
