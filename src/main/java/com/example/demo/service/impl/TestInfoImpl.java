package com.example.demo.service.impl;

import com.example.demo.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestInfoImpl implements ApplicationContextAware {

   /* @Autowired
    private Map<String,UserService> map;
*/
@Autowired
    private  ApplicationContext applicationContext;

    public void query(String str){
        UserService userService = null;
       if ("User".equals(str)){
           userService = (UserService) applicationContext.getBean("userServiceImpl");
           User data = userService.getData(2);
           System.out.println(data);
       }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, UserService> beans = applicationContext.getBeansOfType(UserService.class);
        for (Map.Entry<String, UserService> entry : beans.entrySet()) {

        }
//        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
