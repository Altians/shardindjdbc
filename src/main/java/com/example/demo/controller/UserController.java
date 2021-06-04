package com.example.demo.controller;

import com.alibaba.dubbo.common.utils.Assert;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getById")
    public User getData(@RequestParam("id") long id){
        User user = userService.getData(id);
        String string = JSONObject.toJSONString(user);

        return user;
    }

    @RequestMapping("/getuserid")
    public String getuserid(){
        String userid = "abc123";

        return userid;
    }

    @RequestMapping("/getParam")
    public String getParam(@RequestBody String request){
       try {
           JSONObject jsonObject = JSONObject.parseObject(request);
           String idno = jsonObject.getString("idno");
           Assert.notNull(idno,"idno is not null");
       }catch (Exception e){
           Throwable cause = e.getCause();
               System.out.println(cause);//null
       }

        return "success";
    }
}
