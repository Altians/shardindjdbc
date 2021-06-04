package com.example.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

@Component
@ConfigurationProperties(prefix = "user")
public class User implements Serializable {

    private long id;
    private String name;
    private String password;
    private String idNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        String name = logger.getName();
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", idNo='" + idNo + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public User(long id, String name, String password, String idNo, Date createTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.idNo = idNo;
        this.createTime = createTime;
    }

    public User() {
    }
}
