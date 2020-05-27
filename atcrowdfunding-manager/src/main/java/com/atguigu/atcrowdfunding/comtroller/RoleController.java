package com.atguigu.atcrowdfunding.comtroller;

import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.User;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public Map<String,Object> index(Integer pagenum,Integer pagesize,@RequestParam(required = false,defaultValue = "") String name){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("start",(pagenum-1)*pagesize);
        map.put("size",pagesize);
        map.put("name","%"+name+"%");
        List<Role> roles = roleService.pageQueryData(map);
        int totalnum=roleService.pageQueryCount(map);
        Map<String,Object> responseMap=new HashMap<String, Object>();
        responseMap.put("total",totalnum);
        responseMap.put("data",roles);
        return responseMap;
    }
}
