package com.example.demo.TestDev;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.domain.LoanMarketCityDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {

        List<LoanMarketCityDto> list = new ArrayList<>();
        LoanMarketCityDto dto = new LoanMarketCityDto();
        dto.setCity0code("13000");
        dto.setCity0name("河北省");
        Map<String,String>map = new HashMap<>();
        map.put("130400","唐山市");
        map.put("130200","邯郸市");
        dto.setCities(map);

//        System.out.println(JSON.toJSON(list));

    }

}
