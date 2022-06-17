package com.example.demo.dto;
import lombok.Data;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 账号登录注册实体
 * */
@Data
public class Account {
    private String id;
    // 姓名
    private String name;
    // 账号
    private String username;
    // 密码
    private String password;
}

