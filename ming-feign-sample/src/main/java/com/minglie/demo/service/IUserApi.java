package com.minglie.demo.service;

import com.ming.feign.ApiServer;
import com.ming.feign.User;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@ApiServer("http://localhost:11111")
public interface IUserApi {
    @GetMapping({"/user"})
    String getAllUser();

    @GetMapping({"/user"})
    List<User> listUser();

    @GetMapping({"/user"})
    List<User> listUser(@PathVariable("a") String var1, @PathVariable("b") String var2);

    @PostMapping({"/user"})
    String addUser(@RequestBody User var1);

    @PostMapping({"/user"})
    String addUser(@RequestBody String var1);

    @PostMapping({"/user"})
    String addUser(@RequestBody List<User> var1);

    @PostMapping({"/user"})
    List<User> addUser1(@RequestBody List<User> var1);
}
