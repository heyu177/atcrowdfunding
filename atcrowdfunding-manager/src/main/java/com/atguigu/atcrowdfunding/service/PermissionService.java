package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Permission;

import java.util.List;

public interface PermissionService {

    public Permission queryRootPermission();

    public List<Permission> queryChildPermissions(Integer pid);

    public void insertPermission(Permission permission);
}
