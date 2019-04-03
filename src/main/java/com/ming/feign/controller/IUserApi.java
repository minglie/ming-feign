package com.ming.feign.controller;

import com.ming.feign.ApiServer;
import com.ming.feign.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@ApiServer("http://localhost:11111")
public interface IUserApi {
    @GetMapping("/user")
    String getAllUser();

    @GetMapping("/user")
    List<User> listUser();

    @GetMapping("/user")
    List<User> listUser(@PathVariable("a") String a, @PathVariable("b") String b);

    @PostMapping("/user")
    String addUser(@RequestBody User user);

    @PostMapping("/user")
    String addUser(@RequestBody String user);

    @PostMapping("/user")
    String addUser(@RequestBody List<User> user);

    @PostMapping("/user")
    List<User> addUser1(@RequestBody List<User> user);
}