package com.design.Behavioral.ObserverPattern.poll;

public class CodeAccount extends OfficialAccount {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void publish(String newMsg){
        this.msg = newMsg;
        System.out.println("发布消息： " + msg);
        this.notifyUser();
    }
}
