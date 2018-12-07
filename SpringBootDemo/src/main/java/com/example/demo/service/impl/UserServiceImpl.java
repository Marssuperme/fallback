package com.example.demo.service.impl;

import com.example.demo.entities.TUser;
import com.example.demo.mapper.TUserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper userMapper;

    @Override
    public TUser selectByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public TUser selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(TUser record) {
        return userMapper.insert(record);
    }
}
