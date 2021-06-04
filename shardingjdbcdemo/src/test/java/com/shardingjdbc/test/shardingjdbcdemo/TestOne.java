package com.shardingjdbc.test.shardingjdbcdemo;

public class TestOne {
    public static void main(String[] args) {
        String str = "  dg sa rkw12 ";
        StringBuffer buffer = new StringBuffer(16);
        StringBuffer reverse = buffer.append(str).reverse();
        System.out.println(str.trim());

    }
}
