package com.atguigu.atcrowdfunding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/doLogin")
    public String login(){
        return "success";
    }
}
