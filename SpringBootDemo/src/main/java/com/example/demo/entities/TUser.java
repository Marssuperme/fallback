package com.example.demo.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class TUser {

    private String userId;
    private String userName;
    private String sex;


    public TUser(String userId, String userName, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}