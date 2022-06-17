package com.example.demo.Service;
import com.example.demo.Mapper.RegisterMapper;
import com.example.demo.dto.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hxc
 * @dateTime:2021-12-2
 * @description: 注册service
 * */
@Service
public class RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    // 注册
    public String registerAccount(Account account) {
        registerMapper.registerAccount(account);
        return "注册成功";
    }
}

