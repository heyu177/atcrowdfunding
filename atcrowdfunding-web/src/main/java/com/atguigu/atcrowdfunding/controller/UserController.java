package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public String login(@RequestBody Map<String, User> map){
        User dbUser=userService.getUserByAccountUserpassword(map.get("params"));
        if (dbUser!=null){
            return "success";
        }else {
            return "fail";
        }
    }
}
