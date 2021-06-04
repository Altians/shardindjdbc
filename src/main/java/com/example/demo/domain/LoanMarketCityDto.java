package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class LoanMarketCityDto implements Serializable {
    private Integer id;
    private Integer productId;
    //一级城市编码
    private String city0code;
    //一级城市名称
    private String city0name;
    //二级城市 K编码code V名字name
    private Map<String,String>cities;

    private Date createdTime;
    private Date modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCity0code() {
        return city0code;
    }

    public void setCity0code(String city0code) {
        this.city0code = city0code;
    }

    public String getCity0name() {
        return city0name;
    }

    public void setCity0name(String city0name) {
        this.city0name = city0name;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "LoanMarketCityDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", city0code='" + city0code + '\'' +
                ", city0name='" + city0name + '\'' +
                ", cities=" + cities +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
