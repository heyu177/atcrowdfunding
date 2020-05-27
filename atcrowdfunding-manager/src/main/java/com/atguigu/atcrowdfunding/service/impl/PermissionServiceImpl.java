package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.PermissionMapper;
import com.atguigu.atcrowdfunding.entity.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public Permission queryRootPermission() {
        return permissionMapper.queryRootPermission();
    }

    public List<Permission> queryChildPermissions(Integer pid) {
        return permissionMapper.queryChildPermissions(pid);
    }

    public void insertPermission(Permission permission) {
        permissionMapper.insertPermission(permission);
    }
}
