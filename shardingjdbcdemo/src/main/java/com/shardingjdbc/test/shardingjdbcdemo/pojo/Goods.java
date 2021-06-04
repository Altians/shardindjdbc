package com.shardingjdbc.test.shardingjdbcdemo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {

    private Long gid;//商品主键id
    private String gname;//商品名称
    private Long userId;//用户id
    private String gstatus;//商品状态
}
