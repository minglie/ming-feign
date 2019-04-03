package com.ming.feign.controller;


import com.ming.feign.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@RestController
public class TestController { // 直接注入定义的接口

    @Autowired
    IUserApi userApi;

    @GetMapping("/1")
    public String getAlluser() {
        String s = userApi.getAllUser();
        System.out.println("ok");
        return s;
    }

    @GetMapping("/2")
    public List<User> listuser() {
        List<User> s = userApi.listUser();
        System.out.println("ok");
        return s;
    }

    @GetMapping("/3")
    public List<User> listuser1() {
        List<User> s = userApi.listUser("aa", "bb");
        System.out.println("ok");
        return s;
    }

    @GetMapping("/4")
    public String addUser() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = userApi.addUser(user);
        System.out.println("ok");
        return s;
    }

    @GetMapping("/5")
    public String addUser1() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = userApi.addUser("AAAAAAAAAAAA");
        System.out.println("ok");
        return s;
    }

    @GetMapping("/6")
    public String addUser2() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = userApi.addUser(Arrays.asList(user, user));
        System.out.println("ok");
        return s;
    }

    @GetMapping("/7")
    public List<User> addUser3() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        List<User> userList = userApi.addUser1(Arrays.asList(user, user));
        System.out.println("ok");
        return userList;
    }
}