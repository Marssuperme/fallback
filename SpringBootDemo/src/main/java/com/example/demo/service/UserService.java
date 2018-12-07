package com.example.demo.service;

import com.example.demo.entities.TUser;
import com.example.demo.mapper.TUserMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PublicKey;

public interface UserService {

    TUser selectByPrimaryKey(String userId);

    TUser selectAll();

    int insert(TUser record);

}
