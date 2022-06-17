package com.example.demo.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 登录mapper
 * */
@Mapper
public interface LoginMapper {
    // 登录
    String loginTosystem(@Param("username")String username, @Param("password")String password);
    // 获取登录的人的姓名
    String findName(@Param("username")String username);
}

