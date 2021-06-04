package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /*根据id查询*/
    public User selectUserById(@Param("id") long id);

}
