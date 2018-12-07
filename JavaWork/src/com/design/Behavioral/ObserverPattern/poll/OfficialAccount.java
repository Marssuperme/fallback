package com.design.Behavioral.ObserverPattern.poll;

import java.util.ArrayList;
import java.util.List;

public abstract class OfficialAccount {
    private static List<User> users = new ArrayList<>();
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public void notifyUser(){
        for (User user : users) {
            user.update(this);
        }
    }

}
