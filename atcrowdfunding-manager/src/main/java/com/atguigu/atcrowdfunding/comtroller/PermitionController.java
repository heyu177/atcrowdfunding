package com.atguigu.atcrowdfunding.comtroller;

import com.atguigu.atcrowdfunding.entity.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermitionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/loadData")
    public Object loadData(){
        Permission parent=new Permission();
        parent.setId(0);
        queryChildPermissions(parent);
        return parent.getChildren();
    }

    private void queryChildPermissions(Permission parent){
        List<Permission> childPermissions=permissionService.queryChildPermissions(parent.getId());
        for (Permission childPermission:childPermissions){
            queryChildPermissions(childPermission);
        }
        if (!childPermissions.isEmpty()){
            parent.setChildren(childPermissions);
        }
    }
}
