package com.example.demo.controller;
import com.example.demo.Service.RegisterService;
import com.example.demo.constant.ResultVo;
import com.example.demo.constant.ResutEnum;
import com.example.demo.dto.Account;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 注册Controller
 * */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private RegisterService registerService;

    // 注册
    @PostMapping("registerAccount")
    public ResultVo registerAccount(@RequestBody Account account) {
        return new ResultVo(ResutEnum.OK,registerService.registerAccount(account));
    }
}
