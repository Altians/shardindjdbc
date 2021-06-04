package com.shardingjdbc.test.shardingjdbcdemo.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

    //注解默认--"不能为空"
    @NotEmpty//@NotEmpty :不能为null，且Size>0
    private String name;
    @Size(min = 0,max = 101)
    @NotNull(message = "年龄不能为空")//@NotNull:不能为null，但可以为empty
    private String age;
    @NotBlank(message = "state为空")//@NotBlank:只用于String,不能为null且trim()之后size>0
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
