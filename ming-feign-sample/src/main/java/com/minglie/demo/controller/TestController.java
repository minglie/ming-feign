package com.minglie.demo.controller;

import com.ming.feign.User;
import java.util.Arrays;
import java.util.List;

import com.minglie.demo.service.IUserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    IUserApi userApi;

    public TestController() {
    }

    @GetMapping({"/1"})
    public String getAlluser() {
        String s = this.userApi.getAllUser();
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/2"})
    public List<User> listuser() {
        List<User> s = this.userApi.listUser();
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/3"})
    public List<User> listuser1() {
        List<User> s = this.userApi.listUser("aa", "bb");
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/4"})
    public String addUser() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = this.userApi.addUser(user);
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/5"})
    public String addUser1() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = this.userApi.addUser("AAAAAAAAAAAA");
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/6"})
    public String addUser2() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        String s = this.userApi.addUser(Arrays.asList(user, user));
        System.out.println("ok");
        return s;
    }

    @GetMapping({"/7"})
    public List<User> addUser3() {
        User user = new User();
        user.setId("aaaaaaa");
        user.setAge(5);
        user.setName("wpf");
        List<User> userList = this.userApi.addUser1(Arrays.asList(user, user));
        System.out.println("ok");
        return userList;
    }
}
