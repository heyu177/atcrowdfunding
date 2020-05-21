package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDAO {

    @Select("select * from t_permission where pid is null")
    public Permission queryRootPermission();

    @Select("select * from t_permission where pid=#{pid}")
    public List<Permission> queryChildPermissions(Integer pid);
}
