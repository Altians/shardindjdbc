package com.example.demo.TestDev;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\ip.txt";
        String keyWord = "环境";
        int countByIo = findCountByIo(filePath, keyWord);
        System.out.println("出现次数"+countByIo);
    }

    /**
     * 统计字符串在文件中的出现次数
     * @param filePath
     * @param keyWord
     * @return
     */
    public static int findCountByIo(String filePath, String keyWord){
        int time = 0;
        BufferedReader br = null;
        try {
             br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line=br.readLine())!= null){
                Pattern compile = Pattern.compile(keyWord);
                Matcher matcher = compile.matcher(line); //如果未匹配到，有可能是出现乱码 ，txt的编码方式默认不是utf-8要修改
                while (matcher.find())
                time++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return time;
    }
}
