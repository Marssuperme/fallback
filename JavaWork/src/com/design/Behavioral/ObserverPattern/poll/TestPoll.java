package com.design.Behavioral.ObserverPattern.poll;

public class TestPoll {

    public static void main(String[] args) {

        OfficialAccount codeAccount = new CodeAccount();
        User coder = new Coder();

        codeAccount.addUser(coder);

        ((CodeAccount) codeAccount).publish("最新权威发布");

        codeAccount.removeUser(coder);
    }

}
