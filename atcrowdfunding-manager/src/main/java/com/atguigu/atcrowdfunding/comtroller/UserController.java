package com.atguigu.atcrowdfunding.comtroller;

import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param pagenum 查询第几页
     * @param pagesize 一页显示几条记录
     * @return
     */
    @RequestMapping("/index")
    public Map<String,Object> index(@RequestParam(required = false,defaultValue = "1") Integer pagenum,@RequestParam(required = false,defaultValue = "2") Integer pagesize,@RequestParam(required = false,defaultValue = "") String account){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("start",(pagenum-1)*pagesize);
        map.put("size",pagesize);
        map.put("account","%"+account+"%");
        List<User> users = userService.pageQueryData(map);
        int totalnum=userService.pageQueryCount(map);
        Map<String,Object> responseMap=new HashMap<String, Object>();
        responseMap.put("total",totalnum);
        responseMap.put("data",users);
        return responseMap;
    }

    @RequestMapping("/insert")
    public String insert(@RequestBody User user){
        user.setUserpassword("1234");
        try {
            userService.insertUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
