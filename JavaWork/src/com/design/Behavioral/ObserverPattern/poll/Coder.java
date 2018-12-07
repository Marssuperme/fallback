package com.design.Behavioral.ObserverPattern.poll;

public class Coder extends User {
    @Override
    void update(OfficialAccount msg) {
        System.out.println("Coder 查看：" + ((CodeAccount)msg).getMsg());
    }
}
