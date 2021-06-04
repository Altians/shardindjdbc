package com.example.demo.service.impl;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

@Service("recordServiceImpl")
public class RecordServiceImpl implements UserService {

    @Override
    public User getData(long id) {
        return new User();
    }


}
