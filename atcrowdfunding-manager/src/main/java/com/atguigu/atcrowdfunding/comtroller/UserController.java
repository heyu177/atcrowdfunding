package com.atguigu.atcrowdfunding.comtroller;

import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public Map<String,Object> index(Integer pagenum,Integer pagesize,@RequestParam(required = false,defaultValue = "") String account){
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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreatetime(sdf.format(new Date()));
        user.setUserpassword("1234");
        try {
            userService.insertUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/update")
    public String update(@RequestBody User user){
        try {
            userService.updateUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/delete")
    public Map<String,Object> delete(Integer id){
        Map<String,Object> responseMap=new HashMap<String, Object>();
        try {
            int rows=userService.deleteUser(id);
            responseMap.put("result","success");
            responseMap.put("data",rows);
            return responseMap;
        }catch (Exception e){
            e.printStackTrace();
            responseMap.put("result","fail");
            return responseMap;
        }
    }

    @RequestMapping("/deletes")
    public Map<String,Object> deletes(Integer[] ids){
        Map<String,Object> responseMap=new HashMap<String, Object>();
        try {
            int rows=userService.deleteUsers(ids);
            responseMap.put("result","success");
            responseMap.put("data",rows);
            return responseMap;
        }catch (Exception e){
            e.printStackTrace();
            responseMap.put("result","fail");
            return responseMap;
        }
    }

    @RequestMapping("/getRoles")
    public List<Role> getRoles(Integer id){
        List<Role> list=userService.selectRoles(id);
        return list;
    }

    @RequestMapping("/doAssign")
    public String doAssign(@RequestBody Map<String,Integer> map){
        try {
            userService.assignRole(map);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/doUnAssign")
    public String doUnAssign(Integer userId,Integer roleId){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        try {
            userService.unAssignRole(map);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
