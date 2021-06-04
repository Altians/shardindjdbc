package com.shardingjdbc.test.shardingjdbcdemo.service.impl;

import com.shardingjdbc.test.shardingjdbcdemo.service.ServiceTestA;
import com.shardingjdbc.test.shardingjdbcdemo.service.ServiceTestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTestAImpl implements ServiceTestA {

    @Autowired
    private ServiceTestB serviceTestB;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void methodA() {
     try {
         serviceTestB.methodB();
     }catch (Exception e){
         throw new RuntimeException(e.getMessage());
     }

    }

}
