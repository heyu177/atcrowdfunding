package com.atguigu.atcrowdfunding.comtroller;

import com.atguigu.atcrowdfunding.entity.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/loadData")
    public Object loadData(){
        Permission parent=new Permission();
        parent.setId(0);
        queryChildPermissions(parent);
        return parent.getChildren();
    }

    @RequestMapping("/insert")
    public String insert(@RequestBody Permission permission){
        try {
            permissionService.insertPermission(permission);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/update")
    public String update(@RequestBody Permission permission){
        try {
            permissionService.updatePermission(permission);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        try {
            permissionService.deletePermission(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/loadAssignData")
    public Object loadAssignData(Integer roleId){
        List<Integer> permissionIds=permissionService.getPermissionIdsByRoleId(roleId);
        Permission parent=new Permission();
        parent.setId(0);
        queryChildPermissions(parent,permissionIds);
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

    private void queryChildPermissions(Permission parent,List<Integer> permissionIds){
        List<Permission> childPermissions=permissionService.queryChildPermissions(parent.getId());
        for (Permission childPermission:childPermissions){
            if (permissionIds.contains(childPermission.getId())){
                childPermission.setChecked(true);
            }
            queryChildPermissions(childPermission,permissionIds);
        }
        if (!childPermissions.isEmpty()){
            parent.setChildren(childPermissions);
        }
    }
}
