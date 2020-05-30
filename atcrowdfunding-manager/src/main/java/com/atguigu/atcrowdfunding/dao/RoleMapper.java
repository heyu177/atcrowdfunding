package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    public List<Role> pageQueryData(Map<String,Object> map);

    public int pageQueryCount(Map<String,Object> map);

    public void assignPermission(Map<String,Object> map);

    public void deletePermission(Map<String,Object> map);
}
