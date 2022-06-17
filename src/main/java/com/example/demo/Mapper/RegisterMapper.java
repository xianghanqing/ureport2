package com.example.demo.Mapper;
import com.example.demo.dto.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 注册mapper
 * */
@Mapper
public interface RegisterMapper {
    // 注册
    void registerAccount(@Param("account")Account account);
}

