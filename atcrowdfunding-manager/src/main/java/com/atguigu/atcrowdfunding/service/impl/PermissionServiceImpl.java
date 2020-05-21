package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.PermissionDAO;
import com.atguigu.atcrowdfunding.entity.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    public Permission queryRootPermission() {
        return permissionDAO.queryRootPermission();
    }

    public List<Permission> queryChildPermissions(Integer pid) {
        return permissionDAO.queryChildPermissions(pid);
    }
}
