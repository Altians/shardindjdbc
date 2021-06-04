package com.shardingjdbc.test.shardingjdbcdemo.controller;

import com.shardingjdbc.test.shardingjdbcdemo.pojo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControlller {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@Validated @RequestBody User user){
        String name = user.getName();
        System.out.println(name);
        return user.toString();
    }
}
