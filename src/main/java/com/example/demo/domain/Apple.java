package com.example.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Apple implements Serializable {

    private String id;
    private String name;
    private BigDecimal money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Apple(String id, String name, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

}
