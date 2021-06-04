package com.example.demo.TestDev;

import com.example.demo.domain.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test1 {
    public static void main(String[] args) {
       String a = "abc";
       String b = new String("abc");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//        System.out.println(a=="abc");
        ThreadLocal local = new ThreadLocal();
        Random random = new Random();
        IntStream.range(0,5).forEach(c ->new Thread(()->{
            local.set(c+" "+random.nextInt(10));
            System.out.println("local的值是"+local.get());
        }).start());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       String s = "abc";
        int hashCode = s.hashCode();
//        System.out.println("hashCode:"+hashCode);
//        System.out.println(hashCode%3);


    }


}
