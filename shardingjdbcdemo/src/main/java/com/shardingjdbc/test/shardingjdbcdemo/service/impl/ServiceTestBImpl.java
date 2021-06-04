package com.shardingjdbc.test.shardingjdbcdemo.service.impl;

import com.shardingjdbc.test.shardingjdbcdemo.dao.GoodsMapper;
import com.shardingjdbc.test.shardingjdbcdemo.pojo.Goods;
import com.shardingjdbc.test.shardingjdbcdemo.service.ServiceTestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTestBImpl implements ServiceTestB {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,isolation = Isolation.DEFAULT)
    public void methodB() {
        try {
            Goods goods = new Goods();
            goods.setUserId(15L);
            goods.setGname("Test_TX");
            goods.setGstatus("success");
            int insert = goodsMapper.insert(goods);
            /*事务生效  如果发生异常数据是不会落库的。 不加事务注解或事务未生效 在发生异常之前数据已经落库,*/
            int i = 1/0;
            System.out.println("保存"+insert);
        }catch (Exception e){
            throw new RuntimeException("抛出异常。。。"+e.getMessage());
        }

    }

    @Override
    public void methodC() {
        this.methodB();
    }
}
