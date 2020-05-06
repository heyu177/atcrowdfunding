package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DispatcherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public String doLogin(@RequestBody User user, HttpSession session){
        User dbUser=userService.getUserByAccountUserpassword(user);
        if (dbUser!=null){
            session.setAttribute("user",dbUser);
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/getUsername")
    public Map<String,Object> getUsername(HttpSession session){
        User user= (User) session.getAttribute("user");
        Map<String,Object> map=new HashMap<String, Object>();
        if (user!=null){
            map.put("result","success");
            map.put("username",user.getUsername());
        }else {
            map.put("result","fail");
        }
        return map;
    }

    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "success";
    }
}
