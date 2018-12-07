package com.example.demo.controller;

import com.example.demo.entities.TUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String getUser(){
        TUser user = userService.selectAll();
        return user.toString();
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
