package com.example.demo.controller;
import com.example.demo.Service.LoginService;
import com.example.demo.constant.ResultVo;
import com.example.demo.constant.ResutEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 登录Controller
 * */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    // 登录到系统
    @GetMapping("loginTosystem")
    public ResultVo loginTosystem(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        return new ResultVo(ResutEnum.OK,loginService.loginTosystem(username,password));
    }
    @GetMapping("findName")
    public ResultVo findName(@RequestParam(value="username") String username) {
        return new ResultVo(ResutEnum.OK,loginService.findName(username));
    }
}

