package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.service.impl.TestInfoImpl;
import com.example.demo.util.LocalDateToDateConvert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TestInfoImpl testInfo;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        int x = 5; int y = 3;
        Integer x1 = Optional.ofNullable(x).map(n -> 2 * y).orElse(2);
        if (x1 > y){
            return;
        }
        int temp =  x + y;
        System.out.println(temp);
    }

    @Test
    void test1(){
        LocalDate localDate = LocalDate.now().minusDays(1);//日期减去一天
        LocalDate localDate1 = LocalDate.now().plusDays(3);//日期加上3天
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(localDate1);
//        System.out.println(localDate);
        Date date = new Date();
        int date1 = date.getDate();
        System.out.println(date1);
        int i = date.getDate() + 1;
        date.setDate(i);
        System.out.println(date);

        String str = "1,2,3,601,5";
        System.out.println(str.contains("601"));
    }

    @Test
    public void test2(){
        Date date = null;
        LocalDate localDate = LocalDate.now();
//        Date date1 = LocalDateToDateConvert.LocalDateToDate(localDate);
        LocalDate localDate1 = LocalDateToDateConvert.DateToLocalDate(date);
    }

    @Test
    public void test3(){
        //需要到毫秒 否时间不对
        String dateMs = timeStamp2DateMs("1601193131", "yyyy-MM-dd HH:mm:ss");
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date( 10* 1000));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date(Long.valueOf("1601193131000")));
        System.out.println(format1);
    }

    public static String timeStamp2DateMs(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }
    @Test
    public void test4(){
        testInfo.query("User");
    }

    @Test
    public void test5(){
        List list = new ArrayList();
        list.forEach((s) -> System.out.println(s));
    }
    @Test
    public void test6() {

    }

}
