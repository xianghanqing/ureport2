package com.example.demo.controller;
import com.example.demo.Entity.User;
import com.example.demo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
@RestController
@RequestMapping("user")
public class UserLoginController {

    @Value("${Login.username}")
    private String realUsername;

    @Value("${Login.password}")
    private String realPassword;

    @GetMapping("login")
    public String login(String username, String password) {
        if (username.equals(realUsername) && password.equals(realPassword)) {
            User u = new User();
            u.setPassword(password);
            u.setUsername(username);
            return JWTUtils.getToken(u);
        }
        return "登录失败！账号或者密码不对！";
    }

    @GetMapping("test")
    public String test()  {
        return "访问test - API";
    }
}
