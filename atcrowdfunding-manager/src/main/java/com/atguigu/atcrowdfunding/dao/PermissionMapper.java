package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select * from t_permission where pid is null")
    public Permission queryRootPermission();

    @Select("select * from t_permission where pid=#{pid}")
    public List<Permission> queryChildPermissions(Integer pid);

    public void insertPermission(Permission permission);

    public void updatePermission(Permission permission);

    public void deletePermission(Integer id);
}
