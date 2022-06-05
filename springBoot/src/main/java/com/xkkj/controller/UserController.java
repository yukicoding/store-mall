package com.xkkj.controller;

import com.xkkj.dao.UserDao;
import com.xkkj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/findAllUser")
    public List<User> findUser(){
        return  userDao.findAll();
    }
}
