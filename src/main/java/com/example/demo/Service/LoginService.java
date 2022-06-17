package com.example.demo.Service;
import com.example.demo.Mapper.LoginMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 登录service
 * */
@Service
public class LoginService {
    @Resource
    private LoginMapper loginMapper;
    // 登录
    public String loginTosystem(String username,String password){
        String message = "";
        // 判断登录的角色是否为空
        if(loginMapper.loginTosystem(username,password)== null) {
            message = "登录失败";
        }else {
            loginMapper.loginTosystem(username,password);
            message = "登录成功";
        }
        return message;
    }

    // 获取登录人员的姓名
    public String findName(String username) {
        return loginMapper.findName(username);
    }
}

