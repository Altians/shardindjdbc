package com.example.demo.domain;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    static List<Apple> appleList = new ArrayList();
    static {
        Apple apple1 = new Apple("1","苹果1",new BigDecimal(10));
        Apple apple2 = new Apple("1","苹果12",new BigDecimal(20));
        Apple apple3 = new Apple("3","苹果3",new BigDecimal(30));
        Apple apple4 = new Apple("4","苹果4",new BigDecimal(40));
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
    }

    public static void main(String[] args) {
        /**分组 List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起*/
        Map<String, List<Apple>> collect = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        /**
         * list转Map id为key，apple对象为value，可以这么做
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
         Map<String, Apple> map = appleList.stream().collect(Collectors.toMap(Apple::getId, apple -> apple, (k1, k2) -> k1));
         /**通过Filter 过滤出符合条件的数据*/
        List<Apple> apples = appleList.stream().filter(apple -> apple.getName().equals("苹果3")).collect(Collectors.toList());
        /**
         * 定义和用法
         * reduce() 方法接收一个函数作为累加器，数组中的每个值（从左到右）开始缩减，最终计算为一个值。
         * reduce() 可以作为一个高阶函数，用于函数的 compose。
         * 注意: reduce() 对于空数组是不会执行回调函数的。
         */
        BigDecimal reduce = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::subtract);
        /**
         * map的用法 将集合中对象的某个属性提取为另外一个集合
         */
        Stream<String> stream = appleList.stream().map(Apple::getName);
        List<String> name = stream.collect(Collectors.toList());

        /**
         * 查找流中最大 最小值
         */
        Optional<Apple> maxMoney = appleList.stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getMoney)));
        Optional<Apple> minMoney = appleList.stream().collect(Collectors.minBy(Comparator.comparing(Apple::getMoney)));
        maxMoney.ifPresent(System.out::println);
        System.out.println("groupby:"+minMoney);

        List<String> list = null;
        List<String> newList = Optional.ofNullable(list).orElse(new ArrayList<>());
        newList.forEach(x -> System.out.println(x));


        Optional.ofNullable(appleList).ifPresent(apple -> {
            Apple apple1 = new Apple("5","添加",null);
            apple.add(apple1);
        });
        System.out.println(appleList);

        List<Integer> asList = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect1 = asList.stream().parallel().filter(a -> a > 2).collect(Collectors.toList());
        System.out.println(collect1);

        /** 0.*/
        int[] array = new int[5];
        //初始化随机数
        Arrays.parallelSetAll(array,i-> new Random().nextInt(100));
        //排序
        Arrays.parallelSort(array);
        //累加求和
        Arrays.parallelPrefix(array,Integer::sum);
        System.out.println(Arrays.toString(array));


        String format = String.format("%s期waj", 2);
        System.out.println(format);

    }

}
