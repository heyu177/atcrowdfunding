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
        List<Permission> permissions=new ArrayList<Permission>();
        Permission root=permissionService.queryRootPermission();
        List<Permission> childPermissions=permissionService.queryChildPermissions(root.getId());
        for (Permission childPermission:childPermissions){
            List<Permission> childchildPermissions=permissionService.queryChildPermissions(childPermission.getId());
            childPermission.setChildren(childchildPermissions);
        }
        root.setChildren(childPermissions);
        permissions.add(root);
        return permissions;
    }
}
