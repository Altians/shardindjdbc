package com.shardingjdbc.test.shardingjdbcdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingjdbc.test.shardingjdbcdemo.dao.GoodsMapper;
import com.shardingjdbc.test.shardingjdbcdemo.pojo.Goods;
import com.shardingjdbc.test.shardingjdbcdemo.service.ServiceTestA;
import com.shardingjdbc.test.shardingjdbcdemo.service.ServiceTestB;
import com.shardingjdbc.test.shardingjdbcdemo.service.rocketmq.provider.OrderMessageProvider;
import com.shardingjdbc.test.shardingjdbcdemo.service.rocketmq.provider.consumer.OrderMessageConsumer;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void test1() {
        for (int i = 16; i <= 18; i++) {
            Goods goods = new Goods();
            goods.setGname("小米手机"+i);
            goods.setUserId(102L);
            goods.setGstatus("SUCCESS");
            int insert = goodsMapper.insert(goods);
        }
    }
    @Test
    void test2() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        //查询 相等条件的商品
        QueryWrapper<Goods> gid = queryWrapper.eq("gid", 571359540910489600L);
        Goods goods = goodsMapper.selectOne(gid);
        System.out.println(goods);
    }
    @Test
    void test3() {
        /*Set<String> set = new HashSet();
        set.add("1");
        set.add("2");
        boolean remove = set.remove("1");
        System.out.println(remove);*/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,10L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"输出");
                }
            });
        }
    }

    @Autowired
    private ServiceTestB serviceTestB;
    @Autowired
    private ServiceTestA serviceTestA;

    @Autowired
    private OrderMessageConsumer consumer;
    @Autowired
    private OrderMessageProvider provider;
    @Test
    public void test4(){
//        serviceTestB.methodC();
//        serviceTestA.methodA();
//        consumer.consumeMessage();
//        provider.sendMessage();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    @Test
    public void test5(){

    }
}
