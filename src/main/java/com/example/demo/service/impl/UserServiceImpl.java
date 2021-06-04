package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getData(long id){
        return userMapper.selectUserById(id);
    }
}
